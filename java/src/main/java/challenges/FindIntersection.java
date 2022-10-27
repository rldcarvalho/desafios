/*
Have the function FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements:
the first element will represent a list of comma-separated numbers sorted in ascending order,
the second element will represent a second list of comma-separated numbers (also sorted).
Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order.
If there is no intersection, return the string false.
 */

package challenges;

import java.util.*;
import java.io.*;

public class FindIntersection {
    public static void main(String[] args) {
        System.out.println(FindIntersection());
    }

    public static String FindIntersection() {
        String[] strArr = new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};

        String[] strArr0 = strArr[0].split(",");
        String[] strArr1 = strArr[1].split(",");

        ArrayList<String> intersectionArr = new ArrayList<>();

        for (int i = 0; i < strArr0.length; i++) {
            for (int j = 0; j < strArr1.length; j++) {
                if(strArr0[i].equals(strArr1[j])){
                    intersectionArr.add(strArr0[i]);
                }
            }
        }

        if(intersectionArr.isEmpty()) return "false";

        return intersectionArr.toString().replaceAll("[()\\[\\] ]", "");
    }
}
