package challenges;

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
