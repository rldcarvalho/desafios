package challenges;

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

}
