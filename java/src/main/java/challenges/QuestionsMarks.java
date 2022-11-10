package challenges;

/*
Have the function QuestionsMarks(str) take the str string parameter, which will contain single digit numbers, letters,
and question marks, and check if there are exactly 3 question marks between every pair of two numbers that add up to 10.
If so, then your program should return the string true, otherwise it should return the string false.
If there aren't any two numbers that add up to 10 in the string, then your program should return false as well.
*/

import java.util.Scanner;
import java.util.regex.Pattern;

public class QuestionsMarks {

    public static String QuestionsMarks(String str) {
        boolean valid = Pattern.compile("[0-9].*[?]{3}.*[0-9]").matcher(str).find();
        return String.valueOf(valid);
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(QuestionsMarks(s.nextLine()));
    }
}
