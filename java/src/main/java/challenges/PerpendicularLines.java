package challenges;

public class PerpendicularLines {

    public static int maxBisectors(int n) {

        int m = n /2;
        return n % 2 == 0 ? (int) Math.pow(m, 2) : (int) (Math.pow(m, 2) + m);
    }

    public static void main(String[] args) {
        System.out.println(maxBisectors(51));
    }
}
