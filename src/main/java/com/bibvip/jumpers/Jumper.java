package com.bibvip.jumpers;

import com.bibvip.configs.consts.ElementType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibvip.variables.HomeVars.*;

public class Jumper {

    public static void jumpToLogin(WebDriverWait wait) {
        WebElement clickLogin = getElementWithPolling(wait, getBy(LOGIN_BUTTON, ElementType.CSS_SELECTOR));
        clickLogin.click();
    }

    public static void jumpToFutures(WebDriver driverChrome) throws MalformedURLException {

        // Locating the Main Menu (Parent element)
        WebElement futuresMenu = driverChrome.findElement(getBy(DERIVATIVES_MENU_BTN, ElementType.X_PATH));
        //Instantiating Actions class
        Actions actions = new Actions(driverChrome);

        //Hovering on main menu
        actions.moveToElement(futuresMenu);

        // Locating the element from Sub Menu
        WebElement subMenu = driverChrome.findElement(getBy(FUTURES_SUBMENU_BTN, ElementType.X_PATH));

        //To mouseover on sub menu
        actions.moveToElement(subMenu);

        //build()- used to compile all the actions into a single step
        actions.click().build().perform();
    }
}
