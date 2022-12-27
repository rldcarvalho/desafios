package challenges;

/*
Digital root is the recursive sum of all the digits in a number.

Given n, take the sum of the digits of n. If that value has more than one digit,
continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.

Examples
    16  -->  1 + 6 = 7
   942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 */

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
