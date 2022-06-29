package com.bibvip.futures;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static com.bibvip.configs.DriverConfig.getChromeConfig;
import static com.bibvip.futures.FuturesAuto.doFuturesAuto;

public class ExecuteFutures {

    public static void performFutures() throws Exception {
        //start chrome driver
        WebDriver driverChrome = getChromeConfig();
        JavascriptExecutor j = (JavascriptExecutor) driverChrome;

        //activate - futures auto
        doFuturesAuto(driverChrome, j);

        //Done (Close browsers)
        driverChrome.close();
    }
}
