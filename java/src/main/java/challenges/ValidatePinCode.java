package challenges;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePinCode {

    public static boolean validatePin(String pin) {

        if(pin.length() != 4 && pin.length() != 6) return false;

        Pattern pattern = Pattern.compile("^\\d{4}(?:\\d{2})?$");
        Matcher matcher = pattern.matcher(pin);

        return matcher.find();
    }
}
