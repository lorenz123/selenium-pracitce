package com.bibvip.futures;

import com.bibvip.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.bibvip.consts.ElementType.*;
import static com.bibvip.jumpers.Jumper.jumpToFutures;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.variables.FuturesVars.*;

@Slf4j
public class Timeframes {

    public static void visitAllTimeframes(WebDriver driverChrome, JavascriptExecutor j) throws InterruptedException {

        //item 5 - timeframes
//        j.executeScript ("document.querySelector('"+ONE_MIN_TF+"').click();");
//        log.info("One Minute TimeFrame Trading View Chart Displayed");
//        Thread.sleep(2000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForOneMinuteGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForOneMinuteGraph);
//
//        WebElement oneMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String oneMinuteGraphStr = oneMinuteGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+oneMinuteGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);

        checkTimeframes(driverChrome, j, ONE_MIN_TF, ACTIVE_TF_GRAPH, 2000);
        checkTimeframes(driverChrome, j, ONE_MIN_TF, OPEN_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MIN_TF, HIGH_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MIN_TF, LOW_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MIN_TF, CLOSE_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MIN_TF, CHANGE_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MIN_TF, MA5_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MIN_TF, MA10_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MIN_TF, MA30_PRICE, 0);

        checkTimeframes(driverChrome, j, FIVE_MIN_TF, ACTIVE_TF_GRAPH, 2000);
        checkTimeframes(driverChrome, j, FIVE_MIN_TF, OPEN_PRICE, 0);
        checkTimeframes(driverChrome, j, FIVE_MIN_TF, HIGH_PRICE, 0);
        checkTimeframes(driverChrome, j, FIVE_MIN_TF, LOW_PRICE, 0);
        checkTimeframes(driverChrome, j, FIVE_MIN_TF, CLOSE_PRICE, 0);
        checkTimeframes(driverChrome, j, FIVE_MIN_TF, CHANGE_PRICE, 0);
        checkTimeframes(driverChrome, j, FIVE_MIN_TF, MA5_PRICE, 0);
        checkTimeframes(driverChrome, j, FIVE_MIN_TF, MA10_PRICE, 0);
        checkTimeframes(driverChrome, j, FIVE_MIN_TF, MA30_PRICE, 0);

        checkTimeframes(driverChrome, j, FIFTEEN_MIN_TF, ACTIVE_TF_GRAPH, 2000);
        checkTimeframes(driverChrome, j, FIFTEEN_MIN_TF, OPEN_PRICE, 0);
        checkTimeframes(driverChrome, j, FIFTEEN_MIN_TF, HIGH_PRICE, 0);
        checkTimeframes(driverChrome, j, FIFTEEN_MIN_TF, LOW_PRICE, 0);
        checkTimeframes(driverChrome, j, FIFTEEN_MIN_TF, CLOSE_PRICE, 0);
        checkTimeframes(driverChrome, j, FIFTEEN_MIN_TF, CHANGE_PRICE, 0);
        checkTimeframes(driverChrome, j, FIFTEEN_MIN_TF, MA5_PRICE, 0);
        checkTimeframes(driverChrome, j, FIFTEEN_MIN_TF, MA10_PRICE, 0);
        checkTimeframes(driverChrome, j, FIFTEEN_MIN_TF, MA30_PRICE, 0);

        checkTimeframes(driverChrome, j, THIRTY_MIN_TF, ACTIVE_TF_GRAPH, 2000);
        checkTimeframes(driverChrome, j, THIRTY_MIN_TF, OPEN_PRICE, 0);
        checkTimeframes(driverChrome, j, THIRTY_MIN_TF, HIGH_PRICE, 0);
        checkTimeframes(driverChrome, j, THIRTY_MIN_TF, LOW_PRICE, 0);
        checkTimeframes(driverChrome, j, THIRTY_MIN_TF, CLOSE_PRICE, 0);
        checkTimeframes(driverChrome, j, THIRTY_MIN_TF, CHANGE_PRICE, 0);
        checkTimeframes(driverChrome, j, THIRTY_MIN_TF, MA5_PRICE, 0);
        checkTimeframes(driverChrome, j, THIRTY_MIN_TF, MA10_PRICE, 0);
        checkTimeframes(driverChrome, j, THIRTY_MIN_TF, MA30_PRICE, 0);

        checkTimeframes(driverChrome, j, SIXTY_MIN_TF, ACTIVE_TF_GRAPH, 2000);
        checkTimeframes(driverChrome, j, SIXTY_MIN_TF, OPEN_PRICE, 0);
        checkTimeframes(driverChrome, j, SIXTY_MIN_TF, HIGH_PRICE, 0);
        checkTimeframes(driverChrome, j, SIXTY_MIN_TF, LOW_PRICE, 0);
        checkTimeframes(driverChrome, j, SIXTY_MIN_TF, CLOSE_PRICE, 0);
        checkTimeframes(driverChrome, j, SIXTY_MIN_TF, CHANGE_PRICE, 0);
        checkTimeframes(driverChrome, j, SIXTY_MIN_TF, MA5_PRICE, 0);
        checkTimeframes(driverChrome, j, SIXTY_MIN_TF, MA10_PRICE, 0);
        checkTimeframes(driverChrome, j, SIXTY_MIN_TF, MA30_PRICE, 0);

        checkTimeframes(driverChrome, j, FOUR_HOUR_TF, ACTIVE_TF_GRAPH, 2000);
        checkTimeframes(driverChrome, j, FOUR_HOUR_TF, OPEN_PRICE, 0);
        checkTimeframes(driverChrome, j, FOUR_HOUR_TF, HIGH_PRICE, 0);
        checkTimeframes(driverChrome, j, FOUR_HOUR_TF, LOW_PRICE, 0);
        checkTimeframes(driverChrome, j, FOUR_HOUR_TF, CLOSE_PRICE, 0);
        checkTimeframes(driverChrome, j, FOUR_HOUR_TF, CHANGE_PRICE, 0);
        checkTimeframes(driverChrome, j, FOUR_HOUR_TF, MA5_PRICE, 0);
        checkTimeframes(driverChrome, j, FOUR_HOUR_TF, MA10_PRICE, 0);
        checkTimeframes(driverChrome, j, FOUR_HOUR_TF, MA30_PRICE, 0);

        checkTimeframes(driverChrome, j, ONE_DAY_TF, ACTIVE_TF_GRAPH, 2000);
        checkTimeframes(driverChrome, j, ONE_DAY_TF, OPEN_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_DAY_TF, HIGH_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_DAY_TF, LOW_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_DAY_TF, CLOSE_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_DAY_TF, CHANGE_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_DAY_TF, MA5_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_DAY_TF, MA10_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_DAY_TF, MA30_PRICE, 0);

        checkTimeframes(driverChrome, j, ONE_WEEK_TF, ACTIVE_TF_GRAPH, 2000);
        checkTimeframes(driverChrome, j, ONE_WEEK_TF, OPEN_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_WEEK_TF, HIGH_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_WEEK_TF, LOW_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_WEEK_TF, CLOSE_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_WEEK_TF, CHANGE_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_WEEK_TF, MA5_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_WEEK_TF, MA10_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_WEEK_TF, MA30_PRICE, 0);

        checkTimeframes(driverChrome, j, ONE_MONTH_TF, ACTIVE_TF_GRAPH, 2000);
        checkTimeframes(driverChrome, j, ONE_MONTH_TF, OPEN_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MONTH_TF, HIGH_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MONTH_TF, LOW_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MONTH_TF, CLOSE_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MONTH_TF, CHANGE_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MONTH_TF, MA5_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MONTH_TF, MA10_PRICE, 0);
        checkTimeframes(driverChrome, j, ONE_MONTH_TF, MA30_PRICE, 0);


//
//        j.executeScript ("document.querySelector('"+FIVE_MIN_TF+"').click();");
//        log.info("Five Minute TimeFrame Trading View Chart Displayed");
//        Thread.sleep(3000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForFiveMinuteGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForFiveMinuteGraph);
//        WebElement fiveMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String fiveMinuteGraphStr = fiveMinuteGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+fiveMinuteGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//        j.executeScript ("document.querySelector('"+FIFTEEN_MIN_TF+"').click();");
//        log.info("Fifteen Minute TimeFrame Trading View Chart Displayed");
//        Thread.sleep(3000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForFifteenMinuteGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForFifteenMinuteGraph);
//        WebElement fifteenMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String fifteenMinuteGraphStr = fifteenMinuteGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+fifteenMinuteGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//        j.executeScript ("document.querySelector('"+THIRTY_MIN_TF+"').click();");
//        log.info("Thirty Minute TimeFrame Trading View Chart Displayed");
//        Thread.sleep(3000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForThirtyMinuteGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForThirtyMinuteGraph);
//        WebElement thirtyMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String thirtyMinuteGraphStr = thirtyMinuteGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+thirtyMinuteGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//
//        j.executeScript ("document.querySelector('"+SIXTY_MIN_TF+"').click();");
//        log.info("Sixty Minute TimeFrame Trading View Chart Displayed");
//        Thread.sleep(3000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForSixtyMinuteGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForSixtyMinuteGraph);
//        WebElement sixtyMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String sixtyMinuteGraphStr = sixtyMinuteGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+sixtyMinuteGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//        j.executeScript ("document.querySelector('"+FOUR_HOUR_TF+"').click();");
//        log.info("Four Hour TimeFrame Trading View Chart Displayed");
//        Thread.sleep(3000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForFourHourGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForFourHourGraph);
//        WebElement fourHourGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String fourHourGraphStr = fourHourGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+fourHourGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//        j.executeScript ("document.querySelector('"+ONE_DAY_TF+"').click();");
//        log.info("One Day TimeFrame Trading View Chart Displayed");
//        Thread.sleep(3000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForOneDayGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForOneDayGraph);
//        WebElement oneDayGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String oneDayGraphStr = oneDayGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+oneDayGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//        j.executeScript ("document.querySelector('"+ONE_WEEK_TF+"').click();");
//        log.info("One Week TimeFrame Trading View Chart Displayed");
//        Thread.sleep(3000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForOneWeekGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForOneWeekGraph);
//        WebElement oneWeekGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String oneWeekGraphStr = oneWeekGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+oneWeekGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//        j.executeScript ("document.querySelector('"+ONE_MONTH_TF+"').click();");
//        log.info("One Month TimeFrame Trading View Chart Displayed");
//        Thread.sleep(3000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForOneMonthGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForOneMonthGraph);
//        WebElement oneMonthGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String oneMonthGraphStr = oneMonthGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+oneMonthGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//
//        j.executeScript ("document.querySelector('"+FULL_SCREEN_GRAPH+"').click();");
//        log.info("Full Screen Trading View Chart Displayed");
//        Thread.sleep(3000); //wait 3secs before going to next timeframe
//
//        WebElement iframeForFullScreenGraph = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframeForFullScreenGraph);
//        WebElement fullScreenGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String fullScreenGraphStr = fullScreenGraph.getText();
//        log.info("What timeframe is it? (Minutes) "+fullScreenGraphStr.substring(2));
//        driverChrome.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//        jumpToFutures(driverChrome); //reusable jumper to Futures page
//        Thread.sleep(5000);
//
//        //item 6
//        WebElement iframe2 = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
//        driverChrome.switchTo().frame(iframe2);
//        WebElement chartTypesBtn = driverChrome.findElement(getBy("header-toolbar-chart-styles", ID));
//        chartTypesBtn.click();
//        String isChartTypesOptions = String.valueOf(chartTypesBtn.isDisplayed());
//        log.info("Chart Types options appeared? "+isChartTypesOptions);
//        Thread.sleep(3000);
//
//        WebElement indicatorsBtn = driverChrome.findElement(getBy("header-toolbar-indicators", ID));
//        indicatorsBtn.click();
//        String isIndicatorsOptionsAppearing = String.valueOf(indicatorsBtn.isDisplayed());
//        log.info("Indicators options appeared? "+isIndicatorsOptionsAppearing);
//        Thread.sleep(3000);
//
//        WebElement chartProperties = driverChrome.findElement(getBy("header-toolbar-properties", ID));
//        chartProperties.click();
//        String isChartPropertiesAppearing = String.valueOf(chartProperties.isDisplayed());
//        log.info("Chart Properties options appeared? "+isChartPropertiesAppearing);
//        Thread.sleep(3000);
        //if new test are added to this next step, make this to -- driverChrome.switchTo().defaultContent();

    }
    public static void checkTimeframes(WebDriver driverChrome, JavascriptExecutor j, String timeframeSelector, String activeTFGraph, int sleepTime) throws InterruptedException {

        j.executeScript ("document.querySelector('"+timeframeSelector+"').click();"); //ONE_MIN_TF
        Thread.sleep(sleepTime); //wait 3secs before going to next timeframe

        //switch content to iframe
        WebElement iframe = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
        driverChrome.switchTo().frame(iframe);

        //check the graphTime here (upper-left on chart, the minutes beside pair-name)
        checkGraphTime(driverChrome, activeTFGraph);

        //switch back content from iframe to default
        driverChrome.switchTo().defaultContent();
        Thread.sleep(sleepTime);
    }

    public static String checkGraphTime(WebDriver driverChrome, String activeTFGraph){
        WebElement graphTimeElement = driverChrome.findElement(getBy(activeTFGraph, CSS_SELECTOR));
        String selectedValues = graphTimeElement.getText();
//        if(selectedValues.contains(", ")){
//            selectedValues = selectedValues.substring(2);
//        } else {
//            selectedValues = selectedValues.toString();
//        }
        log.info("Values inside the chart = "+selectedValues);
        return selectedValues;
    }
}
