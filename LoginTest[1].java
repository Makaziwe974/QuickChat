package com.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * LoginTest — unit tests for Login class.
 * Uses EXACT test data from assignment spec.
 *
 * @author Makaziwe Mtsweni
 * @version 1.0
 */
public class LoginTest {

    // ════════════════════════════════════════
    // assertEquals TESTS
    // ════════════════════════════════════════

    // ── TEST 1: Username CORRECTLY formatted ──
    // Test data: "kyl_1" (has _ and is 5 chars)
    
    public void testUsernameCorrectlyFormatted() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertEquals
            "Welcome Kyle Smith, it is great to see you again.",
            login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!")
        );
    }

    // ── TEST 2: Username INCORRECTLY formatted ──
    // Test data: "kyle!!!!!!!" (no _ and too long)
    
    public void testUsernameIncorrectlyFormatted() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyle!!!!!!!",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertEquals(
            "Username is not correctly formatted; " +
            "please ensure that your username contains " +
            "an underscore and is no more than five " +
            "characters in length.",
            login.registerUser()
        );
    }

    // ── TEST 3: Password MEETS complexity ──
    // Test data: "Ch&&sec@ke99!"
    
    public void testPasswordMeetsComplexity() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertEquals(
            "Username successfully captured.\n" +
            "Password successfully captured.\n" +
            "Cell phone number successfully added.",
            login.registerUser()
        );
    }

    // ── TEST 4: Password DOES NOT meet complexity ──
    // Test data: "password"
    
    public void testPasswordFailsComplexity() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "password",
            "+27838968976"
        );
        assertEquals(
            "Password is not correctly formatted; " +
            "please ensure that the password contains " +
            "at least eight characters, a capital " +
            "letter, a number, and a special character.",
            login.registerUser()
        );
    }

    // ── TEST 5: Cell phone CORRECTLY formatted ──
    // Test data: "+27838968976"
    
    public void testCellPhoneCorrectlyFormatted() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertEquals(
            "Username successfully captured.\n" +
            "Password successfully captured.\n" +
            "Cell phone number successfully added.",
            login.registerUser()
        );
    }

    // ── TEST 6: Cell phone INCORRECTLY formatted ──
    // Test data: "08966553"
    
    public void testCellPhoneIncorrectlyFormatted() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "08966553"
        );
        assertEquals(
            "Cell phone number incorrectly formatted " +
            "or does not contain international code.",
            login.registerUser()
        );
    }

    // ════════════════════════════════════════
    // assertTrue / assertFalse TESTS
    // ════════════════════════════════════════

    // ── TEST 7: Login SUCCESSFUL → assertTrue ──
    
    public void testLoginSuccessful() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertTrue(
            login.loginUser("kyl_1", "Ch&&sec@ke99!")
        );
    }

    // ── TEST 8: Login FAILED → assertFalse ──
    
    public void testLoginFailed() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertFalse(
            login.loginUser("wrongUser", "wrongPass")
        );
    }

    // ── TEST 9: Username correctly formatted → assertTrue ──
    
    public void testUsernameFormatTrue() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertTrue(login.checkUserName());
    }

    // ── TEST 10: Username incorrectly formatted → assertFalse ──
   
    public void testUsernameFormatFalse() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyle!!!!!!!",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertFalse(login.checkUserName());
    }

    // ── TEST 11: Password meets complexity → assertTrue ──
    
    public void testPasswordComplexityTrue() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertTrue(login.checkPasswordComplexity());
    }

    // ── TEST 12: Password fails complexity → assertFalse ──
    
    public void testPasswordComplexityFalse() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "password",
            "+27838968976"
        );
        assertFalse(login.checkPasswordComplexity());
    }

    // ── TEST 13: Cell phone correct → assertTrue ──
    
    public void testCellPhoneTrue() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "+27838968976"
        );
        assertTrue(login.checkCellPhoneNumber());
    }

    // ── TEST 14: Cell phone incorrect → assertFalse ──
    
    public void testCellPhoneFalse() {
        Login login = new Login(
            "Kyle", "Smith",
            "kyl_1",
            "Ch&&sec@ke99!",
            "08966553"
        );
        assertFalse(login.checkCellPhoneNumber());
    }
}
