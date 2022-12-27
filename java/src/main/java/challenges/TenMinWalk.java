package challenges;

/*
You live in the city of Cartesia where all roads are laid out in a perfect grid. You arrived ten minutes too early to
an appointment, so you decided to take the opportunity to go for a short walk. The city provides its citizens with a
Walk Generating App on their phones -- everytime you press the button it sends you an array of one-letter strings
representing directions to walk (eg. ['n', 's', 'w', 'e']). You always walk only a single block for each letter
(direction) and you know it takes you one minute to traverse one city block, so create a function that will return
true if the walk the app gives you will take you exactly ten minutes (you don't want to be early or late!) and will,
of course, return you to your starting point. Return false otherwise.

Note: you will always receive a valid array containing a random assortment of direction letters
('n', 's', 'e', or 'w' only). It will never give you an empty array (that's not a walk, that's standing still!).
 */

public class TenMinWalk {

    public static boolean isValid(char[] walk) {

        if (walk.length != 10) return false;

        int xAxis = 0;
        int yAxis = 0;

        for (char c: walk) {
            switch (c) {
                case 'n' -> yAxis++;
                case 's' -> yAxis--;
                case 'w' -> xAxis--;
                case 'e' -> xAxis++;
                default -> {
                    return false;
                }
            }
        }

        return (xAxis == 0 && yAxis == 0);
    }

    public static boolean isValidClever(char[] walk) {

        String s = new String(walk);
        return s.chars().filter(p -> p == 'n').count() == s.chars().filter(p -> p == 's').count()
                && s.chars().filter(p -> p == 'e').count() == s.chars().filter(p -> p == 'w').count()
                && s.chars().count() == 10;
    }
}
