package challenges;

/*
Complete the function that accepts a string parameter, and reverses each word in the string.
All spaces in the string should be retained.
Examples
"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"
 */
public class ReverseWords {

    public static String reverseWords(final String original){

        if (original.isBlank()) return original;

        String[] words = original.split("\\s");

        StringBuilder reversedString = new StringBuilder();

        for (String word: words) {
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            reversedString.append(sb).append(" ");
        }

        return reversedString.toString().trim();

    }
}
