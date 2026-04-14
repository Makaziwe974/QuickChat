
    
package com.quickchat;

/**
 * Login class handles all registration
 * and login logic for QuickChat app.
 * 
 * @author Makaziwe Mtsweni
 * @version 1.0
 */
public class Login {

    // ── Fields — store the user's info ──
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;

    // ── Constructor — saves user's details ──
    public Login(String firstName, String lastName,
                 String username, String password,
                 String cellPhoneNumber) {
        this.firstName     = firstName;
        this.lastName      = lastName;
        this.username      = username;
        this.password      = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // ─────────────────────────────────────────
    // METHOD 1: checkUserName()
    // Checks: has underscore + max 5 chars
    // Example PASS: "kyl_1"  (5 chars, has _)
    // Example FAIL: "kyle!!!!!!!" (too long, no _)
    // ─────────────────────────────────────────
    public boolean checkUserName() {
        return username.contains("_")
               && username.length() <= 5;
    }

    // ─────────────────────────────────────────
    // METHOD 2: checkPasswordComplexity()
    // Checks: 8+ chars, capital, number, special
    // Example PASS: "Ch&&sec@ke99!"
    // Example FAIL: "password"
    // ─────────────────────────────────────────
    public boolean checkPasswordComplexity() {
        return password.matches(
            "(?=.*[A-Z])" +           // capital letter
            "(?=.*[0-9])" +           // number
            "(?=.*[!@#$%^&*()_+\\-])" + // special char
            ".{8,}"                   // 8+ characters
        );
    }

    // ─────────────────────────────────────────
    // METHOD 3: checkCellPhoneNumber()
    // Checks: starts with + country code,
    //         followed by max 10 digits
    // Example PASS: "+27838968976"
    // Example FAIL: "08966553"
    //
    // Regex Reference:
    // Friedl, J.E.F. (2006). Mastering Regular
    // Expressions. 3rd ed. O'Reilly Media.
    // Also see: https://www.baeldung.com/
    //           java-regex-phone-numbers
    // ─────────────────────────────────────────
    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber.matches(
            "\\+[0-9]{10,11}"
        );
    }

    // ─────────────────────────────────────────
    // METHOD 4: registerUser()
    // Returns success OR error messages
    // ─────────────────────────────────────────
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; " +
                   "please ensure that your username contains " +
                   "an underscore and is no more than five " +
                   "characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; " +
                   "please ensure that the password contains " +
                   "at least eight characters, a capital " +
                   "letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted " +
                   "or does not contain international code.";
        }
        return "Username successfully captured.\n" +
               "Password successfully captured.\n" +
               "Cell phone number successfully added.";
    }

    // ─────────────────────────────────────────
    // METHOD 5: loginUser()
    // Returns true if username AND password match
    // ─────────────────────────────────────────
    public boolean loginUser(String enteredUsername,
                             String enteredPassword) {
        return username.equals(enteredUsername)
               && password.equals(enteredPassword);
    }

    // ─────────────────────────────────────────
    // METHOD 6: returnLoginStatus()
    // Returns welcome message OR error message
    // ─────────────────────────────────────────
    public String returnLoginStatus(String enteredUsername,
                                    String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + " " + lastName +
                   ", it is great to see you again.";
        } else {
            return "Username or password incorrect, " +
                   "please try again.";
        }
    }
}
