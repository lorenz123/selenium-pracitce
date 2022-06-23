package com.bibvip.futures;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.bibvip.jumpers.Jumper.jumpToFutures;
import static com.bibvip.variables.FuturesVars.*;

@Slf4j
public class Timeframes {

    public static void visitAllTimeframes(WebDriver driverChrome, JavascriptExecutor j) throws InterruptedException {
        //item 5 - timeframes
        j.executeScript ("document.querySelector('"+ONE_MIN_TF+"').click();");
        log.info("One Minute TimeFrame Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        j.executeScript ("document.querySelector('"+FIVE_MIN_TF+"').click();");
        log.info("Five Minute TimeFrame Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        j.executeScript ("document.querySelector('"+FIFTEEN_MIN_TF+"').click();");
        log.info("Fifteen Minute TimeFrame Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        j.executeScript ("document.querySelector('"+THIRTY_MIN_TF+"').click();");
        log.info("Thirty Minute TimeFrame Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        j.executeScript ("document.querySelector('"+SIXTY_MIN_TF+"').click();");
        log.info("Sixty Minute TimeFrame Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        j.executeScript ("document.querySelector('"+FOUR_HOUR_TF+"').click();");
        log.info("Four Hour TimeFrame Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        j.executeScript ("document.querySelector('"+ONE_DAY_TF+"').click();");
        log.info("One Day TimeFrame Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        j.executeScript ("document.querySelector('"+ONE_WEEK_TF+"').click();");
        log.info("One Week TimeFrame Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        j.executeScript ("document.querySelector('"+ONE_MONTH_TF+"').click();");
        log.info("One Month TimeFrame Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        j.executeScript ("document.querySelector('"+FULL_SCREEN_GRAPH+"').click();");
        log.info("Full Screen Trading View Chart Displayed");
        Thread.sleep(3000); //wait 3secs before going to next timeframe

        jumpToFutures(driverChrome); //reusable jumper to Futures page
        Thread.sleep(5000);
    }
}
