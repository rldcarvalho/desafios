package challenges;

/*
There is an array with some numbers. All numbers are equal except for one. Try to find it!

Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
It’s guaranteed that array contains at least 3 numbers.

The tests contain some very huge arrays, so think about performance.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class FindUniqueNumber {

    public static double findUniq(double arr[]) {
        //this solution fail in high precision tests
        List<Double> list = DoubleStream.of(arr).boxed().collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1 ; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(list.get(i));
                }
            }
        }

        return list.get(0);
    }

    public static double findUniqBestPractices(double arr[]){

        Arrays.sort(arr);
        if (arr[0] == arr[1]){
            return arr[arr.length-1];
        }else{
            return arr[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(findUniqBestPractices(new double[]{1, 1, 1, 2, 1, 1}));
    }
}
