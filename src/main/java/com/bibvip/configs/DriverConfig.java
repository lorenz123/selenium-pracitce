package com.bibvip.configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.surefire.shared.lang3.SystemUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.bibvip.variables.BaseUrl.PROD_BASE_URL;

@Slf4j
public class DriverConfig {

    //TODO use factory method for driver
    //TODO use builder method - capabilities
    public static WebDriver getChromeConfig () throws MalformedURLException {

        boolean windows = SystemUtils.IS_OS_WINDOWS;
        boolean mac = SystemUtils.IS_OS_MAC;
        boolean linux = SystemUtils.IS_OS_LINUX;
        String environmentToTest = PROD_BASE_URL;
        WebDriver driver = null;

        if (windows = true) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(environmentToTest);
            driver.manage().window().maximize();
            log.info("Windows OS Detected - Connection Established!");
            
        } else if (mac = true) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(environmentToTest);
            driver.manage().window().maximize();
            log.info("Macintosh OS Detected - Connection Established!");

        } else if (linux = true) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(environmentToTest);
            driver.manage().window().maximize();
            log.info("Linux OS Detected - Connection Established!");

        } else {
            log.info("OS is not supported - sample");
        }
        return driver;

    }
}
