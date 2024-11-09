package Repository;

public class TestQuestion {
    public static void main(String args[]){

        char[][]arr={{'D','R','L'},{'L','L','U'}};
        System.out.println(isExitPossible(arr));
    }

   // public static int score;
    public static int isExitPossible(char [][]arr){

        int i=0;
        int j=0;
        int n=arr.length;
        int m=arr[0].length;
        int score=0;
        while(i>=0 && i<n && j>=0 && j<m ){
            char move=arr[i][j];
            if(arr[i][j]=='X'){
                return 0;
            }
            arr[i][j]='X';
            score++;
            if(move =='L'){
                j--;
            }
            else if(move=='R'){
                j++;
            }
            else if(move == 'U'){
                i--;
            }
            else if(move =='D'){
                i++;
            }
        }
        return score;
    }

}
