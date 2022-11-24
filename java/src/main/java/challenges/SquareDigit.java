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
