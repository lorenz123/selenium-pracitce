package com.bibvip.futures;

import com.bibvip.jumpers.Jumper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static com.bibvip.consts.ElementType.*;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.variables.FuturesVars.*;

@Slf4j
public class Timeframes {

    //fields of my each values in a timeframe
    public static List<String> allGraphElementsList = new ArrayList<>();
    public static String isChartTypesOptions;
    public static String isIndicatorsOptionsAppearing;
    public static String isChartPropertiesAppearing;

    public static void visitAllTimeframes(WebDriver driverChrome) throws Exception {


        checkChartTypeOptions(driverChrome);//item 6
        checkIndicatorsOptions(driverChrome);//item 6
        checkChartProperties(driverChrome);//item 6

        //item 5
        timeframeExecutor(driverChrome, ONE_MIN_TF);
        timeframeExecutor(driverChrome, FIVE_MIN_TF);
        timeframeExecutor(driverChrome, FIFTEEN_MIN_TF);
        timeframeExecutor(driverChrome, THIRTY_MIN_TF);
        timeframeExecutor(driverChrome, SIXTY_MIN_TF);
        timeframeExecutor(driverChrome, FOUR_HOUR_TF);
        timeframeExecutor(driverChrome, ONE_DAY_TF);
        timeframeExecutor(driverChrome, ONE_WEEK_TF);
        timeframeExecutor(driverChrome, ONE_MONTH_TF);
        timeframeExecutor(driverChrome, FULL_SCREEN_GRAPH);

        log.info("Graph Elements are: {}", allGraphElementsList);

        //TODO
        //TODO Make this into a for loop, where first index is always the 0,9,18... on value of the original List


        //if new test are added to this next step, make this to -- driverChrome.switchTo().defaultContent();

    }

    public static void timeframeExecutor(WebDriver driverChrome, String timeframe) throws Exception {
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

    public static void checkTimeframeValues(WebDriver driverChrome, String timeframeSelector, String checkValueOf, int sleepTime) throws Exception {
        JavascriptExecutor j = (JavascriptExecutor) driverChrome;
        j.executeScript("document.querySelector('" + timeframeSelector + "').click();"); //ONE_MIN_TF
        Thread.sleep(sleepTime); //wait 3secs before going to next timeframe

        //switch content to iframe
        WebElement iframe = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
        driverChrome.switchTo().frame(iframe);

        List<WebElement> graphElement = driverChrome.findElements(getBy(checkValueOf, CSS_SELECTOR));
        if (!graphElement.isEmpty()) {
            int index = graphElement.size() - 1;
            String graphElementStr = graphElement.get(index).getText().replaceAll("[ ,]", "");

            allGraphElementsList.add(graphElementStr);
            log.info("value of graphElement {}", graphElementStr);

        }

        //switch back content from iframe to default
        driverChrome.switchTo().defaultContent();
        Thread.sleep(sleepTime);
    }

    public static void checkChartTypeOptions(WebDriver driverChrome) throws InterruptedException {
        //item 6
        WebElement iframe2 = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
        driverChrome.switchTo().frame(iframe2);
        WebElement chartTypesBtn = driverChrome.findElement(getBy("header-toolbar-chart-styles", ID));
        chartTypesBtn.click();
        isChartTypesOptions = String.valueOf(chartTypesBtn.isDisplayed());
        log.info("Chart Types options appeared? " + isChartTypesOptions);

        driverChrome.switchTo().defaultContent();
        Thread.sleep(3000);

    }

    public static void checkIndicatorsOptions(WebDriver driverChrome) throws InterruptedException {
        //item 6
        WebElement iframe2 = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
        driverChrome.switchTo().frame(iframe2);
        WebElement indicatorsBtn = driverChrome.findElement(getBy("header-toolbar-indicators", ID));
        indicatorsBtn.click();
        isIndicatorsOptionsAppearing = String.valueOf(indicatorsBtn.isDisplayed());
        log.info("Indicators options appeared? " + isIndicatorsOptionsAppearing);

        driverChrome.switchTo().defaultContent();
        Thread.sleep(3000);
    }

    public static void checkChartProperties(WebDriver driverChrome) throws InterruptedException {
        //item 6
        WebElement iframe2 = driverChrome.findElement(getBy("iframe", TAG_NAME)); //Solution to my problem <3
        driverChrome.switchTo().frame(iframe2);
        WebElement chartProperties = driverChrome.findElement(getBy("header-toolbar-properties", ID));
        chartProperties.click();
        isChartPropertiesAppearing = String.valueOf(chartProperties.isDisplayed());
        log.info("Chart Properties options appeared? " + isChartPropertiesAppearing);

        driverChrome.switchTo().defaultContent();
        Thread.sleep(3000);

    }

}
