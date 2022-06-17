package com.bibvip.configs;

import com.bibvip.variables.BrowserDrivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.bibvip.variables.BaseUrl.PROD_BASE_URL;
import static com.bibvip.variables.BrowserDrivers.CHROME_DRIVER;

public class DriverConfig {

    static String environmentToTest = PROD_BASE_URL;
    static String driverOfBrowserToTest = CHROME_DRIVER;

    public static WebDriver getChromeConfig () {

        String jarLocation = BrowserDrivers.getJarLocation(driverOfBrowserToTest); //will get the jar location depending on the selected driver

        System.setProperty(driverOfBrowserToTest, jarLocation);
        WebDriver driverChrome = new ChromeDriver();
        driverChrome.get(environmentToTest);

        return driverChrome;
    }
}
