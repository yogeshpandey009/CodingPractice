package code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

    /*
     * ( start of pattern, where group of conditions involved. (?=.*\d) — This
     * specifies the password should contain any digit from 0-9 (?=.*[a-z]) —
     * This specifies the password should contain any one lower case letter.
     * (?=.*[A-Z]) — This specifies the password should contain any one upper
     * case letter. (?=.*[@#$%-_!&*+]) — The password should contain any of the
     * special characters from the given list. . — After matching previous
     * condition it will match the length of literal. {5, 10} — Password length
     * should be more than 5 characters and less than 10 characters. ) End
     * symbol for pattern, where group of conditions involved.
     */
    public static final String UNAMEPATTERN = "^[a-z0-9_*#@$]{8,20}$";

    /*
     * ^ – stands for start symbol for the Regular Expression Pattern [] - this
     * array contains all the symbol or characters which are allowed in username
     * such as here you can have a-z,0-9 and some special characters. {8, 20} –
     * this specifies the length of the literal having minimum length as 8 and
     * maximum characters should be less than 8. $ – stands for end symbol for
     * the Regular Expression Pattern
     */
    public static final String PWDPATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{5,10})";

    public static Matcher matcher;

    public static void main(String[] args) {

        String userName = "ankita@12a";
        String password = "1aA@2345";
        System.out.println("Username validation result : "
                + validateUserName(userName));
        System.out.println("Password validation result : "
                + validatePassword(password));

    }

    public static boolean validateUserName(String value) {
        Pattern unamepattern;
        unamepattern = Pattern.compile(UNAMEPATTERN);
        matcher = unamepattern.matcher(value);
        return matcher.matches();
    }

    public static boolean validatePassword(String value) {
        Pattern pwdpattern;
        pwdpattern = Pattern.compile(PWDPATTERN);
        matcher = pwdpattern.matcher(value);
        return matcher.matches();
    }
}