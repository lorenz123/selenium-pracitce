package com.bibvip.futures;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bibvip.configs.DriverConfig.getChromeConfig;
import static com.bibvip.futures.FuturesAuto.doFuturesAuto;
import static com.bibvip.utility.ThinkingTimeUtil.getWebDriverWait;

public class ExecuteFutures {

    public static void performFutures() throws Exception {
        //start chrome driver
        WebDriver driverChrome = getChromeConfig();
        JavascriptExecutor j = (JavascriptExecutor) driverChrome;
        WebDriverWait wait = getWebDriverWait(driverChrome);

        //activate - futures auto
        doFuturesAuto(driverChrome, wait);//there should be wait here

        //Done (Close browsers)
        driverChrome.close();
    }
}
