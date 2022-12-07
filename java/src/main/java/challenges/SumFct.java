package challenges;

/*
The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8. It's easy to see that the sum of the perimeters of these squares is : 4 * (1 + 1 + 2 + 3 + 5 + 8) = 4 * 20 = 80

Could you give the sum of the perimeters of all the squares in a rectangle when there are n + 1 squares disposed in the same manner as in the drawing:

Hint:
See Fibonacci sequence

Ref:
http://oeis.org/A000045

The function perimeter has for parameter n where n + 1 is the number of squares (they are numbered from 0 to n) and returns the total perimeter of all the squares.

perimeter(5)  should return 80
perimeter(7)  should return 216
 */

import java.math.BigInteger;

public class SumFct {

    public static BigInteger perimeter(BigInteger n) {

        BigInteger n1 = BigInteger.valueOf(0), n2 = BigInteger.valueOf(1), sum = BigInteger.valueOf(1);

        if (n.intValue() > 0){
            for (int qtd = n.intValue(); qtd > 0; qtd--) {
                BigInteger n3 = n1.add(n2);
                sum = sum.add(n3);
                n1 = n2;
                n2 = n3;
            }
        }


        return sum.multiply(BigInteger.valueOf(4));
    }

    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(5)));
    }
}
