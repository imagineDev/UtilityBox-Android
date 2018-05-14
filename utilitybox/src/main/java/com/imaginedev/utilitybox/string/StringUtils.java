package com.imaginedev.utilitybox.string;

import android.content.Context;
import android.support.annotation.StringRes;

/**
 * Created by batman on 27/02/18.
 */

public final class StringUtils {


    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }


    public static String getStringSaftely(String str) {
        if (str == null)
            return "";
        return str;
    }

    public static String getStringSaftely(Context ctx, @StringRes int res) {

        String str = "";

        if (ctx != null) {
            str = ctx.getString(res);
        }

        return str;
    }

    public static String getStringSaftely(Context ctx, @StringRes int res, Object... args) {

        String str = "";

        if (ctx != null) {
            str = ctx.getString(res, args);
        }

        return str;
    }


    /**
     * Set the first letter of string upper.
     *
     * @param s The string.
     * @return the string with first letter upper.
     */
    public static String upperFirstLetter(final String s) {
        if (s == null || s.length() == 0) return "";
        if (!Character.isLowerCase(s.charAt(0))) return s;
        return String.valueOf((char) (s.charAt(0) - 32)) + s.substring(1);
    }

    /**
     * Set the first letter of string lower.
     *
     * @param s The string.
     * @return the string with first letter lower.
     */
    public static String lowerFirstLetter(final String s) {
        if (s == null || s.length() == 0) return "";
        if (!Character.isUpperCase(s.charAt(0))) return s;
        return String.valueOf((char) (s.charAt(0) + 32)) + s.substring(1);
    }

    /**
     * Reverse the string.
     *
     * @param s The string.
     * @return the reverse string.
     */
    public static String reverse(final String s) {
        if (s == null) return "";
        int len = s.length();
        if (len <= 1) return s;
        int mid = len >> 1;
        char[] chars = s.toCharArray();
        char c;
        for (int i = 0; i < mid; ++i) {
            c = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = c;
        }
        return new String(chars);
    }


}
