package com.bibvip.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This utility class is used to wait for the selected element to be loaded first before another action is initiate/start
 * @author lorenz
 */
public class ThinkingTimeUtil {
    public static final Integer WAITING_TIME = 40;

    public static final Integer POLLING_TIME = 1;
    public static WebElement getElementWithPolling(WebDriverWait wait, By webElementBy) {
        wait.pollingEvery(Duration.ofSeconds(POLLING_TIME));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(webElementBy));
//        WebElement elementJavascript = wait.until(ExpectedConditions.element(webElementBy));
        return element;
    }

    public static WebDriverWait getWebDriverWait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME));
        return wait;
    }
}
