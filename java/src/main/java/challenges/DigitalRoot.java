package challenges;

import java.util.Arrays;

public class DigitalRoot {

    public static int digital_root(int n) {

        String temp = Integer.toString(n);
        int[] nArr = new int[String.valueOf(n).length()];

        for (int i = 0; i < temp.length(); i++) {
            nArr[i] = temp.charAt(i) - '0';
        }

        int sum = 0;
        for (int i : nArr) {
            sum += i;
        }

        return (sum < 10) ? sum : digital_root(sum);
    }

}
