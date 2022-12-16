package challenges;

/*
Prince Arthas needs your help! Mal'ganis has spread an infection amongst the Stratholme citizens,
and we must help Arthas prevent this infection from spreading to other parts of the Kingdom.

You will receive a string s as input: Each "word" represents a house, and each letter represents a citizen.
All infected citizens are represented as "i" or "I" in s. You must eradicate them, and their neighbors.
If an infected citizen appears after or before a space, you should not delete the space,
but keep in mind that the distance from "house" to "house" (word to word) has to have only one whitespace.

EXAMPLES:

"STRING"                       -> "STG"
"1i2 33 i4i5 i555ii5"          -> "33 5"
"It is a bit chilly"           -> "a cly"
"Pineapple pizza is delicious" -> "eapple za deus"
"It is not there"              -> "not there"
NOTES:

There are no apostrophes or any non-alphanumeric characters other than whitespaces.
Make sure there are no leading or trailing spaces in the result string
You will always be given a valid string.
You won't be provided any empty strings.
Good luck and for the Alliance!
 */

public class TheCullingOfStratholme {

    public static String purify(String s) {

        s = s.trim();

        if (s.isEmpty()){
            return s;
        }

        char[] arr = s.toCharArray();

        if (s.length() == 1){
            if (isClear(arr[0])){
                return s;
            }else return "";
        }

        StringBuilder answer = new StringBuilder();

        if (isClear(arr[0]) && isClear(arr[1])){
            answer.append(arr[0]);
        }

        for (int i = 1; i < s.length() - 1; i++) {

            if(isClear(arr[i-1]) && isClear(arr[i]) && isClear(arr[i+1]) || arr[i] == ' '){
                answer.append(arr[i]);
            }

        }

        if (isClear(arr[s.length() - 2]) && isClear(arr[s.length() - 1])){
            answer.append(arr[s.length() - 1]);
        }

        return answer.toString().replaceAll(" {2,}", " ").trim();
    }

    public static boolean isClear(char i){
        return i != 'i' && i != 'I';
    }
    
    public static void main(String[] args) {
        System.out.println("Stg - " + purify("String"));
        System.out.println("BatChesg - " + purify("BatChesting"));
        System.out.println("on Men - " + purify("Iron Maiden"));
        System.out.println(" - " + purify("IIIIiiiiiiIIIII"));
    }

}
