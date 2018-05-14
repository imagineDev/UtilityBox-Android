package com.imaginedev.utilitybox.validations;

import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by rashmijv on 03/05/17.
 */

public final class Validator {

    private static final String REGEX_ALPHA_NUMERIC = "[A-Za-z0-9]+";
    private static final String REGEX_NUMERIC = "[0-9]+";
    private static final String REGEX_NAME = "^[\\p{L} .'-]+$";

    public static boolean isValidPhone(String phoneNumber) {
        return phoneNumber != null && Patterns.PHONE.matcher(phoneNumber).matches();
    }

    public static boolean isEmailValid(String target) {
        return target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean isUrlValid(String target) {
        return target != null && Patterns.WEB_URL.matcher(target).matches();
    }

    public static boolean isAlphanumeric(String target) {
        return target != null && target.matches(REGEX_ALPHA_NUMERIC);
    }

    public static boolean isOnlyNumeric(String target) {
        return target != null && target.matches(REGEX_NUMERIC);
    }


    /**
     * Name such as:
     * > Peter Müller
     * > François Hollande
     * > Patrick O'Brian
     * > Silvana Koch-Mehrin
     * <p>
     * It checks for Alphabets are few special characters
     */
    public static boolean isValidName(String target) {
        return target != null && target.matches(REGEX_NAME);
    }

    public static boolean isValidPassword(String password) {
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+.=])(?=\\S+$).{8,}$";
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }


}
