package com.bibvip.credential;

import java.util.Random;

public class Credentials {

    //Password random A-z 0-9 generator
    public static String passwordGenerator() {
        String saltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * saltChars.length());
            salt.append(saltChars.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    //mobileNumber random 100000000-999999999 generator
    public static String mobileNumberGenerator() {
        long min = 100000000;
        long max = 999999999;
        long randomMobileNumber = (long)(Math.random()*(max-min+1)+min);
        String mobileNumber = Long.toString(randomMobileNumber);
        return mobileNumber;
    }

    private String mobileNumber = mobileNumberGenerator();
    private String password = passwordGenerator();

    public Credentials(String mobileNumber, String password) {
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
