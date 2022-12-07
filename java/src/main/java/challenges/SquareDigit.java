/*
Welcome. In this kata, you are asked to square every digit of a number and concatenate them.

For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1.

Note: The function accepts an integer and returns an integer
 */

package challenges;

import java.util.stream.Collectors;

public class SquareDigit {

    public static int squareDigits(int n) {

        String srtNumber = String.valueOf(n);

        String strSquareDigits = "";

        for (char strDigit : srtNumber.toCharArray()) {

            int intDigit = Character.getNumericValue(strDigit);

            strSquareDigits += String.valueOf(intDigit * intDigit);
        }

        return Integer.parseInt(strSquareDigits);
    }

    public static int squareDigitsAlternative(int n){
        return Integer.parseInt(String.valueOf(n).chars()
                .map(i -> Integer.parseInt(String.valueOf((char) i)))
                .map(i -> i * i)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));
    }

}
