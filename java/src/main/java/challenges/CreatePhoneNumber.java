package challenges;

import java.util.Arrays;

public class CreatePhoneNumber {

    public static String createPhoneNumber(int[] numbers) {

        String strNumbers = Arrays.toString(numbers);
        strNumbers = strNumbers.replaceAll("[\\[\\], ]", "");
        return strNumbers.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
    }

    public static String createPhoneNumberBestPractices(int[] numbers) {

        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3],
                numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }
}
