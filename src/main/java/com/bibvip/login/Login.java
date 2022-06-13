package com.bibvip.login;

import com.bibvip.credential.Credentials;
import com.bibvip.SeleniumRunner;

public class Login {

    public static void main(String[] args){
        Credentials credentials = new Credentials(Credentials.passwordGenerator(),Credentials.mobileNumberGenerator());
        SeleniumRunner.runTheSelenium(credentials);
    }

}
