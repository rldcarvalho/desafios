package challenges;

/*
Write a function that takes in a string of one or more words, and returns the same string,
but with all five or more letter words reversed (Just like the name of this Kata).
Strings passed in will consist of only letters and spaces. Spaces will be included only
when more than one word is present.

Examples:

spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
spinWords( "This is a test") => returns "This is a test"
spinWords( "This is another test" )=> returns "This is rehtona test"
 */

public class SpinWords {

    public String spinWords(String sentence) {

        if (sentence.isBlank()) return sentence;

        String[] words = sentence.split("\\s");

        StringBuilder finalString = new StringBuilder();

        for (String word : words) {
            if (word.length() >= 5) {
                StringBuilder sb = new StringBuilder(word);
                sb.reverse();
                finalString.append(sb).append(" ");
            }else {
                finalString.append(word).append(" ");
            }
        }

        return finalString.toString().trim();
    }

    public static String spinWordsAlternative(String sentence){

        for (String word : sentence.split(" ")) {

            if (word.length() >= 5){
                sentence = sentence.replace(word, new StringBuilder(word).reverse());
            }
        }

        return sentence;
    }
}
