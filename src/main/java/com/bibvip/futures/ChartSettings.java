package com.bibvip.futures;

import com.bibvip.configs.DriverConfig;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibvip.configs.DriverConfig.driverChrome;
import static com.bibvip.consts.ElementType.ID;
import static com.bibvip.consts.ElementType.TAG_NAME;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.utility.ThinkingTimeUtil.getElementWithPolling;

@Slf4j
public class ChartSettings {

    public static String isChartTypesOptions;
    public static String isIndicatorsOptionsAppearing;
    public static String isChartPropertiesAppearing;

    public static void checkChartTypeOptions(WebDriverWait wait) throws InterruptedException {
        //item 6
        WebElement iframe2 = getElementWithPolling(wait, getBy("iframe", TAG_NAME)); //Solution to my problem <3
       driverChrome.switchTo().frame(iframe2);
        WebElement chartTypesBtn = getElementWithPolling(wait, getBy("header-toolbar-chart-styles", ID));
        chartTypesBtn.click();
        isChartTypesOptions = String.valueOf(chartTypesBtn.isDisplayed());
        log.info("Chart Types options appeared? " + isChartTypesOptions);

        driverChrome.switchTo().defaultContent();

    }

    public static void checkIndicatorsOptions(WebDriverWait wait) throws InterruptedException {
        //item 6
        WebElement iframe2 = getElementWithPolling(wait, getBy("iframe", TAG_NAME)); //Solution to my problem <3
        driverChrome.switchTo().frame(iframe2);
        WebElement indicatorsBtn = getElementWithPolling(wait, getBy("header-toolbar-indicators", ID));
        indicatorsBtn.click();
        isIndicatorsOptionsAppearing = String.valueOf(indicatorsBtn.isDisplayed());
        log.info("Indicators options appeared? " + isIndicatorsOptionsAppearing);

        driverChrome.switchTo().defaultContent();
    }

    public static void checkChartProperties(WebDriverWait wait) throws InterruptedException {
        //item 6
        WebElement iframe2 = getElementWithPolling(wait, getBy("iframe", TAG_NAME)); //Solution to my problem <3
        driverChrome.switchTo().frame(iframe2);
        WebElement chartProperties = getElementWithPolling(wait, getBy("header-toolbar-properties", ID));
        chartProperties.click();
        isChartPropertiesAppearing = String.valueOf(chartProperties.isDisplayed());
        log.info("Chart Properties options appeared? " + isChartPropertiesAppearing);

        driverChrome.switchTo().defaultContent();

    }
}
