package com.bibvip.futures;

import com.bibvip.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.variables.FuturesVars.MARKET_BLOCK;
import static com.bibvip.variables.FuturesVars.SHOW_PAIRS_DROPDOWN_BUTTON;

@Slf4j
public class MarketBlock {

    public static boolean isMarketBlockDisplayed;
    public static boolean isMarketBlockDismissed;

    public static void checkMarketBlockDisplay(WebDriver driverChrome, JavascriptExecutor j) throws InterruptedException {
        //item 2
        j.executeScript ("document.querySelector('"+SHOW_PAIRS_DROPDOWN_BUTTON+"').click();"); //javascript executeScript was used because click() of selenium is not working on dropdown buttons
        log.info("Market Block was displayed after clicking dropdown button");

        isMarketBlockDisplayed = driverChrome.findElement(getBy(MARKET_BLOCK, ElementType.CSS_SELECTOR)).isDisplayed();
        log.info("Market Block displayed? " + String.valueOf(isMarketBlockDisplayed));

        // wait time added 3s
        Thread.sleep(3000);

    }

    public static void checkMarketBlockDismiss(WebDriver driverChrome, JavascriptExecutor j) {

        j.executeScript ("document.querySelector('"+SHOW_PAIRS_DROPDOWN_BUTTON+"').click();"); //javascript executeScript was used because click() of selenium is not working on dropdown buttons
        log.info("Market Block was dismissed after clicking dropdown button");

        isMarketBlockDismissed = driverChrome.findElement(getBy(MARKET_BLOCK, ElementType.CSS_SELECTOR)).isDisplayed();
        log.info("Market Block displayed? " + String.valueOf(isMarketBlockDismissed)); 
    }
}
