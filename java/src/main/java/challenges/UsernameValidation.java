/*
Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine if the string is a valid username according to the following rules:

1. The username is between 4 and 25 characters.
2. It must start with a letter.
3. It can only contain letters, numbers, and the underscore character.
4. It cannot end with an underscore character.

If the username is valid then your program should return the string true, otherwise return the string false.
 */

package challenges;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UsernameValidation {
    public static boolean CodelandUsernameValidation(String str) {
        boolean stringLen = (str.length() > 3 && str.length() < 26);
        boolean stringStartsEnds = Pattern.compile("^[a-zA-Z].*[^_]$").matcher(str).find();
        boolean stringContains = str.matches("^[a-zA-Z0-9\\_]+$");

        if(stringLen && stringStartsEnds && stringContains){
            return true;
        }

        return false;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(CodelandUsernameValidation(s.nextLine()));
    }
}
