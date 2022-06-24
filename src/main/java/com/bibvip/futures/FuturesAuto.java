package com.bibvip.futures;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.bibvip.jumpers.Jumper.jumpToFutures;


public class FuturesAuto {

    public static void doFuturesAuto(WebDriver driverChrome, JavascriptExecutor j) throws InterruptedException {
        //Perform Auto Futures using selenium

        jumpToFutures(driverChrome); //reusable jumper to Futures page

        ActivePairPrices.checkActivePairPrices(driverChrome); //item 1
        ActivePairPrices.checkChangesActivePairPrices(driverChrome); //item 3
        ActivePairPrices.checkSymbolsValues(driverChrome); //item 4
        MarketBlock.checkMarketBlockDisplay(driverChrome, j); //item 2 - displayed market block
        MarketBlock.checkMarketBlockDismiss(driverChrome, j); //item 2 - dismissed market block
        Timeframes.visitAllTimeframes(driverChrome, j); //item 5

        //item 6 - TODO cannot select element using selenium and javascript

    }


}
