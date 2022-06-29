package com.bibvip.configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.surefire.shared.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;

import static com.bibvip.variables.BaseUrl.PROD_BASE_URL;

@Slf4j
public class DriverConfig {

    public static boolean windows = SystemUtils.IS_OS_WINDOWS;
    public static boolean mac = SystemUtils.IS_OS_MAC;
    public static boolean linux = SystemUtils.IS_OS_LINUX;
    public static String environmentToTest = PROD_BASE_URL;
    public static WebDriver driverChrome = null;

    //TODO use factory method for driver
    //TODO use builder method - capabilities
    public static WebDriver getChromeConfig () throws MalformedURLException {



        if (windows = true) {
            WebDriverManager.chromedriver().setup();
            driverChrome = new ChromeDriver();
            driverChrome.get(environmentToTest);
            driverChrome.manage().window().maximize();
            log.info("Windows OS Detected - Connection Established!");
            
        } else if (mac = true) {
            WebDriverManager.chromedriver().setup();
            driverChrome = new ChromeDriver();
            driverChrome.get(environmentToTest);
            driverChrome.manage().window().maximize();
            log.info("Macintosh OS Detected - Connection Established!");

        } else if (linux = true) {
            WebDriverManager.chromedriver().setup();
            driverChrome = new ChromeDriver();
            driverChrome.get(environmentToTest);
            driverChrome.manage().window().maximize();
            log.info("Linux OS Detected - Connection Established!");

        } else {
            log.info("OS is not supported - sample");
        }
        return driverChrome;

    }
}
