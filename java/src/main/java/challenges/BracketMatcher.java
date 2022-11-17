package challenges;

/*
Have the function BracketMatcher(str) take the str parameter being passed and return 1 if the brackets are
correctly matched and each one is accounted for. Otherwise return 0. For example: if str is "(hello (world))",
then the output should be 1, but if str is "((hello (world))" the the output should be 0 because the brackets
do not correctly match up. Only "(" and ")" will be used as brackets. If str contains no brackets return 1.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketMatcher {

    public static String BracketMatcher(String str) {
        Pattern pattern1 = Pattern.compile("[(]");
        Pattern pattern2 = Pattern.compile("[)]");
        Matcher matcher1 = pattern1.matcher(str);
        Matcher matcher2 = pattern2.matcher(str);
        int count1 = 0;
        while (matcher1.find()) {
            count1++;
        }

        int count2 = 0;
        while (matcher2.find()) {
            count2++;
        }

        if(count1 != count2){return "0";}

        return "1";
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(BracketMatcher(s.nextLine()));
    }

}
