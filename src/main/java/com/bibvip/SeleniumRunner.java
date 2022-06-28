package com.bibvip;

import java.net.MalformedURLException;

import static com.bibvip.futures.ExecuteFutures.performFutures;

public class SeleniumRunner {

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        //performLogin();
        performFutures();
    }
}
