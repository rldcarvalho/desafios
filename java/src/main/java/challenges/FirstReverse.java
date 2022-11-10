package challenges;

/*
Have the function FirstReverse(str) take the str parameter being passed and return the string in reversed order.
For example: if the input string is "Hello World and Coders" then your program should return
the string sredoC dna dlroW olleH.
 */

import java.util.Scanner;

public class FirstReverse {

    public static String FirstReverse(String str) {
        StringBuilder stringReverse = new StringBuilder(str);
        return String.valueOf(stringReverse.reverse());
    }

    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(FirstReverse(s.nextLine()));
    }
}
