/*
Have the function LongestWord(sen) take the sen parameter being passed and return the longest word in the string.
If there are two or more words that are the same length, return the first word from the string with that length.
Ignore punctuation and assume sen will not be empty. Words may also contain numbers, for example "Hello world123 567"
 */

package challenges;

import java.util.Scanner;

public class LongestWord {

    public static String LongestWord(String sen) {
        String stringSemPontuacao = sen.replaceAll("\\p{Punct}", "");
        String[] palavras = stringSemPontuacao.split(" ");
        String maiorPalavra = "";
        for (int i = 0; i < palavras.length; i++) {
            if (maiorPalavra.length() < palavras[i].length()){
                maiorPalavra = palavras[i];
            }
        }

        return maiorPalavra;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }
}
