package CoreJava.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

    public static void main(String args[]){
        Pattern pattern=Pattern.compile("abc");
        Matcher matcher=pattern.matcher("abcOmOmOmOMabsabcOmCKabs");

        while (matcher.find()){
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println(matcher.group());
        }

        //TODO: something related to string also add


    }
}
