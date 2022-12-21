package challenges;

import java.util.Arrays;

public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) {

        String strNumbers = Arrays.toString(numbers);
        strNumbers = strNumbers.replaceAll("[\\[\\], ]", "");
        return strNumbers.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }

}
