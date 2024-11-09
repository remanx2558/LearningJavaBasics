import java.util.Arrays;
import java.util.stream.IntStream;

//Part1: Efficient Code
//Part2: Streams Code


public class StreamsExamples {
    boolean isPalindrome=isPalindrome(123);

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            int bitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bitB = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = bitA + bitB + carry;
            result.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }

        //Doing reverse of string builder
        //adding in front be like :
        result.insert(0,"somthingAdded");
        return result.reverse().toString();
    }



    private boolean isPalindrome(int x) {
        String str = String.valueOf(x); // Inlined string conversion

        return IntStream.range(0, str.length() / 2)
                //Here is allMatch
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
    }

    public int singleNumber(int[] nums) {
        return Arrays.stream(nums)
                .reduce(0, (answer, val) -> answer ^ val);
    }

    public int singleNumber2(int[] nums) {
        final int[] answer = {0};  // Use an array to allow modification inside the lambda
        Arrays.stream(nums).forEach(val -> answer[0] ^= val);
        return answer[0];
    }

    //Problem1.
    public boolean isSubsequence(String s, String t) {
        int currentIndex = 0;
        char []arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            //Star Point: In your code, the variable i is being incremented in the for loop, so it's not "effectively final.
            //work around: Capture the value of arr[i] in a local variable within each iteration of the loop. This way, the lambda expression will reference a local variable that is final or effectively final.
            char currentChar = arr[i];
            currentIndex=IntStream.range(currentIndex,t.length())//create one lesser
                    .filter(index -> currentChar==t.charAt(index))
                    .findFirst()
                    .orElse(-1);
            if(currentIndex==-1){return false;}
            currentIndex++;
        }
        return true;
    }

    //Problem2:
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        dp[0][0] = nums[0];

        return IntStream.range(1, n)
                .mapToObj(i -> {
                    //Doubt: Changing value of outside local variable is not allowed then how this is possible
                    dp[i][0] = nums[i] + dp[i - 1][1];
                    dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                    return Math.max(dp[i][0], dp[i][1]); // Find max here
                })
                .max(Integer::compareTo) // Compare Integers
                .orElse(nums[0]);  // Default value if empty stream
    }
}

/*
*
1. IntStream.range(currentIndex,t.length()) : create 1 lesser element
2. filter("some condition") have : findFirst() + orElse("what to return")
3. orElse("what to return"): if stream is empty then default return value.
3. variables used inside a lambda expression must be either final or "effectively final," meaning they cannot change after being assigned.
4.mapToObj: It returns a stream of Objects
5.max(Integer::compareTo) : If stream is of Integer, must to this way to get max value
*
* */


/*
Common Errors
1. local variables referenced from a lambda expression must be final or effectively final
2.method max in interface Stream<T> cannot be applied to given types;.max() // Compare Integers ; required: Comparator<? super Integer> ; found:    no arguments
3. Streams work best when you're transforming collections or working with sequential operations that can be parallelized.
* */

