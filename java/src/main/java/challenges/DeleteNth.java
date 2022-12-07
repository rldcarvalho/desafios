package challenges;

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
