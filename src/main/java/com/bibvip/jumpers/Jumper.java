package com.bibvip.jumpers;

import com.bibvip.consts.ElementType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.variables.HomeVars.*;

public class Jumper {

    public static void jumpToLogin(WebDriver driverChrome) {
        WebElement clickLogin = driverChrome.findElement(getBy(LOGIN_BUTTON, ElementType.CSS_SELECTOR));
        clickLogin.click();
    }

    public static void jumpToFutures(WebDriver driverChrome) {

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
