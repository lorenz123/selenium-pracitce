package com.bibvip.jumpers;

import com.bibvip.consts.ElementType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.variables.HomeVars.FUTURES_BUTTON;
import static com.bibvip.variables.HomeVars.LOGIN_BUTTON;

public class Jumper {

    public static void jumpToLogin(WebDriver driverChrome) {
        WebElement clickLogin = driverChrome.findElement(getBy(LOGIN_BUTTON, ElementType.CSS_SELECTOR));
        clickLogin.click();
    }

    public static void jumpToFutures(WebDriver driverChrome) {
        WebElement clickLogin = driverChrome.findElement(getBy(FUTURES_BUTTON, ElementType.CSS_SELECTOR));
        clickLogin.click();
    }
}
