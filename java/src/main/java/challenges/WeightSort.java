package challenges;

/*
My friend John and I are members of the "Fat to Fit Club (FFC)". John is worried because each month a list with
the weights of members is published and each month he is the last on the list which means he is the heaviest.

I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list".
It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.

For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.

Given a string with the weights of FFC members in normal order can you give this string ordered by "weights" of these numbers?

Example:
"56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:

"100 180 90 56 65 74 68 86 99"
When two numbers have the same "weight", let us class them as if they were strings (alphabetical ordering) and not numbers:

180 is before 90 since, having the same "weight" (9), it comes before as a string.

All numbers in the list are positive numbers and the list can be empty.

Notes
it may happen that the input string have leading, trailing whitespaces and more than a unique whitespace between two consecutive numbers
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeightSort {

    public static String orderWeight(String strng) {

        List<String> list = new ArrayList<>(List.of(strng.split(" ")));
        list.removeAll(Arrays.asList(" ", "", null));

        Collections.sort(list, (o1, o2) -> {
            int diff = getSum(o1) - getSum(o2);
            return diff == 0 ? o1.compareTo(o2) : diff < 0 ? -1 : 1;
        });
        return String.join(" ", list);
    }

    private static int getSum(String s) {
        int sum = 0;
        for(String d: s.split("")) {
            sum += Integer.parseInt(d);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("11 11 2000 10003 22 123 1234000 44444444 9999");
        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

}
