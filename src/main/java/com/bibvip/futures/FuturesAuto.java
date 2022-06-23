package com.bibvip.futures;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.bibvip.futures.LeftPanePrices.checkPrices;
import static com.bibvip.futures.MarketBlock.checkMarketBlockDisplay;
import static com.bibvip.futures.Timeframes.visitAllTimeframes;
import static com.bibvip.jumpers.Jumper.jumpToFutures;


public class FuturesAuto {

    public static void doFuturesAuto(WebDriver driverChrome, JavascriptExecutor j) throws InterruptedException {
        //Perform Auto Futures using selenium

        jumpToFutures(driverChrome); //reusable jumper to Futures page

        checkPrices(driverChrome); //item 1,3,4
        checkMarketBlockDisplay(driverChrome, j); //item 2
        visitAllTimeframes(driverChrome, j); //item 5

        //item 6 - TODO cannot select element using selenium and javascript

    }


}
