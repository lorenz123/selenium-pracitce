package com.bibvip.futures;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.bibvip.configs.DriverConfig.driverChrome;
import static com.bibvip.consts.ElementType.*;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibvip.variables.FuturesVars.*;

@Slf4j
public class Timeframes {

    //fields of my each values in a timeframe
    public static List<String> allGraphElementsList = new ArrayList<>();


    public static void visitAllTimeframes(WebDriver driverChrome, WebDriverWait wait) throws Exception {
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

        ChartSettings.checkChartTypeOptions(wait);//item 6
        ChartSettings.checkIndicatorsOptions(wait);//item 6
        ChartSettings.checkChartProperties(wait);//item 6

        timeframeExecutor(driverChrome, FULL_SCREEN_GRAPH);

        log.info("Graph Elements are: {}", allGraphElementsList);

        //TODO
        //TODO Make this into a for loop, where first index is always the 0,9,18... on value of the original List


        //if new test are added to this next step, make this to -- driverChrome.switchTo().defaultContent();

    }

    public static void timeframeExecutor(WebDriver driverChrome, String timeframe) throws Exception {
        checkTimeframeValues(driverChrome, timeframe, ACTIVE_TF_GRAPH, 1000);
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


}
