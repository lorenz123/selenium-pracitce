package com.bibvip;

import static com.bibvip.futures.ExecuteFutures.performFutures;
import static com.bibvip.login.ExecuteLogin.performLogin;

public class SeleniumRunner {

    public static void main(String[] args) throws InterruptedException {
        //performLogin();
        performFutures();
    }
}
