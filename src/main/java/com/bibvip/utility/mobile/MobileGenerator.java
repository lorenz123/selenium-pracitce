package com.bibvip.utility.mobile;

public class MobileGenerator {

    static long min = 100000000L;
    static long max = 999999999L;

    public static String getRandomMobileNumber() {
        long randomMobileNumber = (long)(Math.random()*(max-min+1)+min);
        String mobileNumber = Long.toString(randomMobileNumber);
        return mobileNumber;
    }

}
