package challenges;

/*
Description
An infinite number of shelves are arranged one above the other in a staggered fashion.
The cat can jump up to 3 shelves at the same time: from shelf 1 to shelf 2 or 4
(the cat cannot climb on the shelf directly above its head), according to the illustration:

                 ┌────────┐
                 │-6------│
                 └────────┘
┌────────┐
│------5-│
└────────┘  ┌─────► OK!
            │    ┌────────┐
            │    │-4------│
            │    └────────┘
┌────────┐  │
│------3-│  │
BANG!────┘  ├─────► OK!
  ▲  |\_/|  │    ┌────────┐
  │ ("^-^)  │    │-2------│
  │ )   (   │    └────────┘
┌─┴─┴───┴┬──┘
│------1-│
└────────┘
Input
Start and finish shelf numbers (always positive integers, finish no smaller than start)

Task
Find the minimum number of jumps to go from start to finish

Example
Start 1, finish 5, then answer is 2 (1 => 4 => 5 or 1 => 2 => 5)
 */

public class CatsAndShelves {

    public static int solution(int start, int finish) {

        int diff = finish - start;

        return diff / 3 + diff % 3;
    }

    public static void main(String[] args) {
        System.out.println(2 + " - " + solution(1, 5));
        System.out.println(192 + " - " + solution(155, 729));
        System.out.println(113 + " - " + solution(583, 918));
        System.out.println(38 + " - " + solution(11, 121));
    }
}
