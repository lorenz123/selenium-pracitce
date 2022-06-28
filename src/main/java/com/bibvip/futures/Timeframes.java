package com.bibvip.futures;

import com.bibvip.jumpers.Jumper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.bibvip.consts.ElementType.*;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.variables.FuturesVars.*;

@Slf4j
public class Timeframes {

    //fields of my timeframe selectors
    public static String oneMinTF = ONE_MIN_TF;
    public static String fiveMinTF = FIVE_MIN_TF;
    public static String fifteenMinTF = FIFTEEN_MIN_TF;
    public static String thirtyMinTF = THIRTY_MIN_TF;
    public static String sixtyMinTF = SIXTY_MIN_TF;
    public static String fourHourTF = FOUR_HOUR_TF;
    public static String oneDayTF = ONE_DAY_TF;
    public static String oneWeekTF = ONE_WEEK_TF;
    public static String oneMonthTF = ONE_MONTH_TF;
    public static String fullScreenTF = FULL_SCREEN_GRAPH;

    //fields of my each values in a timeframe
    public static List<String> allGraphElementsList = new ArrayList<>();


    public static void visitAllTimeframes(WebDriver driverChrome) throws InterruptedException {

        //item 5

        timeframeExecutor(driverChrome, oneMinTF);

        timeframeExecutor(driverChrome, fiveMinTF);

        timeframeExecutor(driverChrome, fifteenMinTF);

        timeframeExecutor(driverChrome, thirtyMinTF);

        timeframeExecutor(driverChrome, sixtyMinTF);

        timeframeExecutor(driverChrome, fourHourTF);

        timeframeExecutor(driverChrome, oneDayTF);

        timeframeExecutor(driverChrome, oneWeekTF);

        timeframeExecutor(driverChrome, oneMonthTF);

        timeframeExecutor(driverChrome, fullScreenTF);

        log.info("Graph Elements are: {}", allGraphElementsList);

        driverChrome.navigate().back();
        Thread.sleep(3000);

        //item 6
        WebElement iframe2 = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
        driverChrome.switchTo().frame(iframe2);
        WebElement chartTypesBtn = driverChrome.findElement(getBy("header-toolbar-chart-styles", ID));
        chartTypesBtn.click();
        String isChartTypesOptions = String.valueOf(chartTypesBtn.isDisplayed());
        log.info("Chart Types options appeared? " + isChartTypesOptions);
        Thread.sleep(3000);

        WebElement indicatorsBtn = driverChrome.findElement(getBy("header-toolbar-indicators", ID));
        indicatorsBtn.click();
        String isIndicatorsOptionsAppearing = String.valueOf(indicatorsBtn.isDisplayed());
        log.info("Indicators options appeared? " + isIndicatorsOptionsAppearing);
        Thread.sleep(3000);

        WebElement chartProperties = driverChrome.findElement(getBy("header-toolbar-properties", ID));
        chartProperties.click();
        String isChartPropertiesAppearing = String.valueOf(chartProperties.isDisplayed());
        log.info("Chart Properties options appeared? " + isChartPropertiesAppearing);
        Thread.sleep(3000);

        //if new test are added to this next step, make this to -- driverChrome.switchTo().defaultContent();

    }

    public static void timeframeExecutor(WebDriver driverChrome, String timeframe) throws InterruptedException {
        checkTimeframeValues(driverChrome, timeframe, ACTIVE_TF_GRAPH, 2000);
        checkTimeframeValues(driverChrome, timeframe, OPEN_PRICE, 0);
        checkTimeframeValues(driverChrome, timeframe, HIGH_PRICE, 0);
        checkTimeframeValues(driverChrome, timeframe, LOW_PRICE, 0);
        checkTimeframeValues(driverChrome, timeframe, CLOSE_PRICE, 0);
        checkTimeframeValues(driverChrome, timeframe, CHANGE_PRICE, 0);
        checkTimeframeValues(driverChrome, timeframe, MA5_PRICE, 0);
        checkTimeframeValues(driverChrome, timeframe, MA10_PRICE, 0);
        checkTimeframeValues(driverChrome, timeframe, MA30_PRICE, 0);

    }

    public static void checkTimeframeValues(WebDriver driverChrome, String timeframeSelector, String checkValueOf, int sleepTime) throws InterruptedException {
        JavascriptExecutor j = (JavascriptExecutor) driverChrome;
        j.executeScript("document.querySelector('" + timeframeSelector + "').click();"); //ONE_MIN_TF
        Thread.sleep(sleepTime); //wait 3secs before going to next timeframe

        //switch content to iframe
        WebElement iframe = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
        driverChrome.switchTo().frame(iframe);

        //getting all the values of "checkValueOf"
//        WebElement graphElement = driverChrome.findElement(getBy(checkValueOf, CSS_SELECTOR));
//        log.info("value of graphElement " +graphElement.getText());

        List<WebElement> graphElement = driverChrome.findElements(getBy(checkValueOf, CSS_SELECTOR));
        if (!graphElement.isEmpty()) {
            int getValue = graphElement.size();
            int index = getValue - 1;
            allGraphElementsList.add(graphElement.get(index).getText());
            log.info("value of graphElement {}\tindex is {}", graphElement.get(index).getText(), index);
        }

        //switch back content from iframe to default
        driverChrome.switchTo().defaultContent();
        Thread.sleep(sleepTime);
    }

}
