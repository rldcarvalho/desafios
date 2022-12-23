package challenges;

/*
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */

import java.util.HashSet;

public class CountingDuplicates {

    public static int duplicateCount(String text) {

        char[] charText = text.toLowerCase().toCharArray();

        HashSet<Character> uniqueCharsText = new HashSet<>();

        for (char each: charText) {
            uniqueCharsText.add(each);
        }

        int occurs = 0;
        for (Character uniqueCharacter: uniqueCharsText) {
            int count = 0;
            for (char c: charText) {
                if (uniqueCharacter == c) count++;
            }

            if (count > 1) occurs++;
        }

        return occurs;
    }

    public static int duplicateCountBestPractices(String text){

        text = text.toLowerCase();

        int ans = 0;
        while (text.length() > 0){
            String firstLetter = text.substring(0, 1);
            text = text.substring(1);

            if(text.contains(firstLetter)) ans++;

            text = text.replace(firstLetter, "");
        }

        return ans;

    }

}
