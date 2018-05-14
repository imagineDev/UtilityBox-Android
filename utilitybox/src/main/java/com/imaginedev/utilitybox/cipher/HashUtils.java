package com.imaginedev.utilitybox.cipher;

import android.support.annotation.Nullable;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by batman on 04/03/18.
 */

public final class HashUtils {

    private static final char HEX_DIGITS[] =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


    public static String toMd5AsString(String input, String salt) {
        return toMd5AsString(input + salt);
    }

    public static String toMd5AsString(String input) {
        byte[] data = toMd5(input);

        if (data != null) {
            return toHexString(data);
        }

        return null;

    }

    public static byte[] toMd5(String input, String salt) {
        return toMd5(input + salt);
    }

    public static byte[] toMd5(String input) {
        try {
            byte[] data = hash(input.getBytes(), "MD5");
            return data;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static String toSha1AsString(String input, String salt) {
        return toSha1AsString(input + salt);
    }

    public static String toSha1AsString(String input) {
        byte[] data = toSha1(input);

        if (data != null) {
            return toHexString(data);
        }

        return null;

    }

    public static byte[] toSha1(String input, String salt) {
        return toSha1(input + salt);
    }

    public static byte[] toSha1(String input) {
        try {
            byte[] data = hash(input.getBytes(), "SHA1");
            return data;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static String toSha256AsString(String input, String salt) {
        return toSha256AsString(input + salt);
    }

    public static String toSha256AsString(String input) {
        byte[] data = toSha256(input);

        if (data != null) {
            return toHexString(data);
        }

        return null;

    }

    public static byte[] toSha256(String input, String salt) {
        return toSha256(input + salt);
    }

    public static byte[] toSha256(String input) {
        try {
            byte[] data = hash(input.getBytes(), "SHA256");
            return data;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static String toSha512AsString(String input, String salt) {
        return toSha512AsString(input + salt);
    }

    public static String toSha512AsString(String input) {
        byte[] data = toSha512(input);

        if (data != null) {
            return toHexString(data);
        }

        return null;

    }

    public static byte[] toSha512(String input, String salt) {
        return toSha512(input + salt);
    }

    public static byte[] toSha512(String input) {
        try {
            byte[] data = hash(input.getBytes(), "SHA512");
            return data;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;

    }


    public static String toSha3AsString(String input, String salt) {
        return toSha3AsString(input + salt);
    }

    public static String toSha3AsString(String input) {
        byte[] data = toSha3(input);

        if (data != null) {
            return toHexString(data);
        }

        return null;

    }

    public static byte[] toSha3(String input, String salt) {
        return toSha512(input + salt);
    }

    public static byte[] toSha3(String input) {
        try {
            byte[] data = hash(input.getBytes(), "SHA3");
            return data;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;

    }


    public static byte[] hash(byte[] input, String hashingAlgorithm) throws NoSuchAlgorithmException {
        MessageDigest digest;
        digest = MessageDigest.getInstance(hashingAlgorithm);
        digest.update(input, 0, input.length);
        return digest.digest();
    }

    public static String toHexString(byte[] data) {
        char[] chars = new char[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            chars[i * 2] = HEX_DIGITS[(data[i] >> 4) & 0xf];
            chars[i * 2 + 1] = HEX_DIGITS[data[i] & 0xf];
        }
        return new String(chars);
    }

}
