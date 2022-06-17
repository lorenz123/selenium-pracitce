package com.bibvip.variables;

import com.bibvip.consts.ElementType;
import org.openqa.selenium.By;

public interface BrowserDrivers {
    String CHROME_DRIVER = "webdriver.chrome.driver";
    String FIREFOX_DRIVER = "webdriver.gecko.driver";
    String EDGE_DRIVER = "webdriver.edge.driver";
    String SAFARI_DRIVER = "webdriver.safari.driver";
    String IE_DRIVER = "webdriver.ie.driver";

    static String getJarLocation(String driver) {
        String path;
        switch (driver){
            case CHROME_DRIVER:
                path = "C:\\selenium jar files\\Browser WebDrivers\\chromedriver_win32-version102\\chromedriver.exe";
                return path;
            case FIREFOX_DRIVER:
                path = "C:\\selenium jar files\\Browser WebDrivers\\geckodriver-v0.31.0-win64\\geckodriver.exe";
                return path;
            case EDGE_DRIVER:
                path = "C:\\selenium jar files\\Browser WebDrivers\\edgedriver_win64\\msedgedriver.exe";
                return path;
            case SAFARI_DRIVER:
                path = "C:\\selenium jar files\\Browser WebDrivers\\chromedriver_win32-version102\\chromedriver.exe"; //still do not have this (download this)
                return path;
            case IE_DRIVER:
                path = "C:\\selenium jar files\\Browser WebDrivers\\IEDriverServer_x64_4.2.0\\chromedriver.exe";
                return path;
            default:
                throw new IllegalArgumentException();

        }
    }

}
