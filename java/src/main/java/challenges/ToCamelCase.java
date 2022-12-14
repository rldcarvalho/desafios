package challenges;

/*
Complete the method/function so that it converts dash/underscore delimited words into camel casing.
The first word within the output should be capitalized only if the original word was capitalized
(known as Upper Camel Case, also often referred to as Pascal case). The next words should be always capitalized.

Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"
"The_Stealth_Warrior" gets converted to "TheStealthWarrior"
 */

import java.util.Arrays;

public class ToCamelCase {

    static String toCamelCase(String s){

        String[] splited = s.split("[-_]");
        String solution = splited[0];
        for (int i = 1; i < splited.length; i++) {
            if (!splited[i].isBlank()) solution += Character.toUpperCase(splited[i].charAt(0)) + splited[i].substring(1);
        }

        return solution;
    }

    static String toCamelCaseBestPractices(String str){
        String[] splited = str.split("[-_]");
        return Arrays.stream(splited, 1, splited.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(splited[0], String::concat);
    }
}
