package challenges;

/*
Given two Arrays in which values are the power of each soldier, return true if you survive the attack or false if you perish.

CONDITIONS

Each soldier attacks the opposing soldier in the same index of the array. The survivor is the number with the highest value.
If the value is the same they both perish
If one of the values is empty(different array lengths) the non-empty value soldier survives.
To survive the defending side must have more survivors than the attacking side.
In case there are the same number of survivors in both sides, the winner is the team with the highest initial attack power. If the total attack power of both sides is the same return true.
The initial attack power is the sum of all the values in each array.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.IntStream.of;


public class SurviveTheAttack {

    public static boolean block(int[] attackers, int[] defenders){

        if (defenders.length == 0) return true;

        int maxLength = Integer.max(attackers.length, defenders.length);

        List<Integer> atk = completeWithZeros(attackers, maxLength);
        List<Integer> def = completeWithZeros(defenders, maxLength);

        int count = 0;

        for (int i = 0; i < maxLength; i++) {

            if (atk.get(i) < def.get(i)){
                count++;
            }else if (atk.get(i) > def.get(i)){
                count--;
            }
        }

        if (count > 0) return true;
        if (count < 0) return false;

        int sumAtk = atk.stream().mapToInt(i -> i).sum();
        int sumDef = def.stream().mapToInt(i -> i).sum();

        return sumDef >= sumAtk && sumDef + sumAtk != 0;

    }

    public static List<Integer> completeWithZeros(int[] arr, int maxLength){

        List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().toList());

        if (list.size() < maxLength){
            for (int i = list.size(); i < maxLength; i++) {
                list.add(0);
            }
        }

        return list;
    }

    public static boolean blockBestPractices(int[] attackers, int[] defenders){
        
        int survived = defenders.length - attackers.length;

        for (int i = 0; i < Math.min(defenders.length, attackers.length); i++) {
            survived += Math.signum(defenders[i] - attackers[i]);
        }

        return survived > 0 || survived == 0 && of(defenders).sum() >= of(attackers).sum();
    }

}
