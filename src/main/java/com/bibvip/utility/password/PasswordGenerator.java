package com.bibvip.utility.password;

import java.util.Random;

public class PasswordGenerator {

    static String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public static String getPasswordGenerator() {

        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
