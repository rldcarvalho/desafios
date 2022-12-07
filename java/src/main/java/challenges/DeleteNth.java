package challenges;

/*
Enough is enough!
Alice and Bob were on a holiday. Both of them took many pictures of the places they've been, and now they want to show Charlie their entire collection.
However, Charlie doesn't like these sessions, since the motif usually repeats. He isn't fond of seeing the Eiffel tower 40 times.
He tells them that he will only sit for the session if they show the same motif at most N times. Luckily, Alice and Bob are able to encode the motif as a number.
Can you help them to remove numbers such that their list contains each number only up to N times, without changing the order?

Task
Given a list and a number, create a new list that contains each number of list at most N times, without reordering.
For example if the input number is 2, and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2],
drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
With list [20,37,20,21] and number 1, the result would be [20,37,21].
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteNth {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        List<Integer> answer = new ArrayList<>();


        for (int i = 0; i < elements.length; i++) {
            int ocurrence = 0;
            for (int j = 0; j <= i; j++) {
                if (elements[i] == elements[j]) ocurrence++;
            }
            if (ocurrence <= maxOccurrences)answer.add(elements[i]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println("20, 37, 21");
        System.out.println(Arrays.toString(deleteNth(new int[]{20, 37, 20, 21}, 1)));

        System.out.println("1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5");
        System.out.println(Arrays.toString(deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3)));
    }
}
