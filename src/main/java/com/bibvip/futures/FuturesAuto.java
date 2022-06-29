package com.bibvip.futures;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibvip.jumpers.Jumper.jumpToFutures;


public class FuturesAuto {

    public static void doFuturesAuto(WebDriver driverChrome, WebDriverWait wait) throws Exception {
        //Perform Auto Futures using selenium

        jumpToFutures(driverChrome); //reusable jumper to Futures page

        ActivePairPrices.checkActivePairPrices(wait); //item 1
        ActivePairPrices.checkChangesActivePairPrices(wait); //item 3
        ActivePairPrices.checkSymbolsValues(wait); //item 4
        MarketBlock.checkMarketBlockDisplay(driverChrome); //item 2 - displayed market block
        MarketBlock.checkMarketBlockDismiss(driverChrome); //item 2 - dismissed market block

        Timeframes.visitAllTimeframes(driverChrome, wait); //item 5


    }


}
