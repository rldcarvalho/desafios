package challenges;

/*
Return the number (count) of vowels in the given string.

We will consider a, e, i, o, u as vowels for this Kata (but not y).

The input string will only consist of lower case letters and/or spaces.
 */

public class VowelCount {

    public static int getCount(String str) {
        int count = (int) str.chars().filter(ch -> ch == 'a').count();
        count += (int) str.chars().filter(ch -> ch == 'e').count();
        count += (int) str.chars().filter(ch -> ch == 'i').count();
        count += (int) str.chars().filter(ch -> ch == 'o').count();
        count += (int) str.chars().filter(ch -> ch == 'u').count();

        return count;
    }

    public static void main(String[] args) {
        System.out.println("5 - " + getCount("abracadabra"));
    }

}
