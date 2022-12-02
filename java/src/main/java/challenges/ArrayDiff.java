package challenges;

/*
Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.

It should remove all values from list a, which are present in list b keeping their order.

Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
If a value is present in b, all of its occurrences must be removed from the other:

Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayDiff {

    public static int[] arrayDiff(int[] a, int[] b) {

        List<Integer> list = new ArrayList<>(Arrays.stream(a).boxed().toList());

        for (int i : b) {
            list.removeAll(Collections.singleton(i));
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayDiff(new int[]{1, 2}, new int[]{1})));
    }
}
