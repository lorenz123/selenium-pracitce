package com.bibvip.validators;

public class LoginFieldsValidator {
    public static void checkIfNull(String mobile, String password){
        if (mobile != null && password != null){
            System.out.println("Test Passed! All fields are filled.");
        } else {
            System.out.println("Test Failed! Fields was not filled.");
        }
    }
}
