package challenges;

/*
The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("
 */

public class DuplicateEncoder {

    static String encode(String word){

        word = word.toLowerCase();
        StringBuilder encodedWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {

            int count = 0;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) count++;
            }

            if (count > 1)encodedWord.append(")");
            else encodedWord.append("(");
        }

        return encodedWord.toString();
    }

    public static void main(String[] args) {
        encode("   ()(   ");
    }
}
