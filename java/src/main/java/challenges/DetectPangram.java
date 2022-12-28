package challenges;

/*
A pangram is a sentence that contains every single letter of the alphabet at least once.
For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether or not it is a pangram. Return True if it is, False if not.
Ignore numbers and punctuation.
 */

public class DetectPangram {

    public static boolean check(String sentence){

        sentence = sentence.toLowerCase().replaceAll("[^a-z]", "");

        StringBuilder temp = new StringBuilder("" + sentence.charAt(0));

        for (int i = 1; i < sentence.length(); i++) {
            if (!temp.toString().contains(String.valueOf(sentence.charAt(i))))
                temp.append(sentence.charAt(i));
        }

        return temp.length() == 26;
    }

    public static boolean checkBestPractices(String sentence){

        for (char c = 'a'; c <= 'z'; c++){
            if (!sentence.toLowerCase().contains("" + c)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkBestClever(String sentence){

        return sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic).distinct().count() == 26;
    }

}
