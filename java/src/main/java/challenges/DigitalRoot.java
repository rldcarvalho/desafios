package challenges;

public class DigitalRoot {

    public static int digitalRoot(int n) {

        String temp = Integer.toString(n);
        int[] nArr = new int[String.valueOf(n).length()];

        for (int i = 0; i < temp.length(); i++) {
            nArr[i] = temp.charAt(i) - '0';
        }

        int sum = 0;
        for (int i : nArr) {
            sum += i;
        }

        return (sum < 10) ? sum : digitalRoot(sum);
    }

    public static int digitalRootBestPractices(int n){
        while (n > 9){
            n = n / 10 + n % 10;
        }
        return n;
    }

}
