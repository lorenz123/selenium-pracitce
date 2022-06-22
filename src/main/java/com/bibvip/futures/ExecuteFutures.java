package com.bibvip.futures;

import org.openqa.selenium.WebDriver;

import static com.bibvip.configs.DriverConfig.getChromeConfig;
import static com.bibvip.futures.FuturesAuto.doFuturesAuto;

public class ExecuteFutures {

    public static void performFutures() throws InterruptedException {
        //start chrome driver
        WebDriver driverChrome = getChromeConfig();

        //activate - login auto
        doFuturesAuto(driverChrome);

        //Done (Close browsers)
        //driverChrome.close();
    }
}
