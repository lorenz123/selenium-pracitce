package com.bibvip.login;

import com.bibvip.configs.consts.ElementType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.bibvip.jumpers.Jumper.jumpToLogin;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibvip.utility.MobileGenerator.getRandomMobileNumber;
import static com.bibvip.utility.PasswordGenerator.getPasswordGenerator;
import static com.bibvip.validators.LoginFieldsValidator.checkIfNull;
import static com.bibvip.variables.LoginVars.MOBILE_TEXTFIELD;
import static com.bibvip.variables.LoginVars.PASSWORD_TEXTFIELD;

public class LoginAuto {
    public static final Integer WAITING_TIME = 40;
    public static final Integer POLLING_TIME = 1;

    public static void doLoginAuto(WebDriverWait wait){

//        Perform Auto Login using selenium


        jumpToLogin(wait); //reusable jumper to Futures page

        //with separated method
        WebElement inputMobile = getElementWithPolling(wait, getBy(MOBILE_TEXTFIELD, ElementType.CSS_SELECTOR));

        //without seperation
        WebDriver driver = null;
        WebElement inputMobile2 = new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIME)).pollingEvery(Duration.ofSeconds(POLLING_TIME)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MOBILE_TEXTFIELD)));

        WebElement inputPassword = getElementWithPolling(wait, getBy(PASSWORD_TEXTFIELD, ElementType.CSS_SELECTOR));

        inputMobile.sendKeys(getRandomMobileNumber());
        inputPassword.sendKeys(getPasswordGenerator());

        //Get value of the generated texts
        String checkMobileNumber = inputMobile.getAttribute("value");
        String checkPassword = inputPassword.getAttribute("value");

        //Validate the generated texts
        checkIfNull(checkMobileNumber, checkPassword);

    }

}
