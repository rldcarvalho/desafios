package challenges;

/*
The drawing below gives an idea of how to cut a given "true" rectangle into squares ("true" rectangle meaning that the two dimensions are different).

*image* 5x3 rectangle with 3x3, 2x2, 1x1 and 1x1 squares inside it.

Can you translate this drawing into an algorithm?
You will be given two dimensions

a positive integer length
a positive integer width

Examples in general form:

  sqInRect(5, 3) should return [3, 2, 1, 1]
  sqInRect(3, 5) should return [3, 2, 1, 1]
 */

import java.util.ArrayList;
import java.util.List;

public class RectangleIntoSquares {

    public static List<Integer> sqInRect(int lng, int wdth) {

        if (lng == wdth) return null;

        List<Integer> squares = new ArrayList<>();

        int min = Math.min(lng, wdth);
        int max = Math.max(lng, wdth);

        while (min > 0){
            squares.add(min);
            int diff = max - min;
            max = Math.max(min, diff);
            min = Math.min(min, diff);
        }

        return squares;
    }

    public static void main(String[] args) {
        System.out.println(sqInRect(14, 20));
    }
}
