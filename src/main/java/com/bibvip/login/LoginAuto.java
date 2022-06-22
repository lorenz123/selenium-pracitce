package com.bibvip.login;

import com.bibvip.consts.ElementType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.bibvip.jumpers.Jumper.jumpToLogin;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.utility.mobile.MobileGenerator.getRandomMobileNumber;
import static com.bibvip.utility.password.PasswordGenerator.getPasswordGenerator;
import static com.bibvip.validators.LoginFieldsValidator.checkIfNull;
import static com.bibvip.variables.LoginVars.MOBILE_TEXTFIELD;
import static com.bibvip.variables.LoginVars.PASSWORD_TEXTFIELD;

public class LoginAuto {

    public static void doLoginAuto(WebDriver driverChrome){

        //Perform Auto Login using selenium

        jumpToLogin(driverChrome); //reusable jumper to Futures page

        WebElement inputMobile = driverChrome.findElement(getBy(MOBILE_TEXTFIELD, ElementType.CSS_SELECTOR));
        WebElement inputPassword = driverChrome.findElement(getBy(PASSWORD_TEXTFIELD, ElementType.CSS_SELECTOR));

        inputMobile.sendKeys(getRandomMobileNumber());
        inputPassword.sendKeys(getPasswordGenerator());

        //Get value of the generated texts
        String checkMobileNumber = inputMobile.getAttribute("value");
        String checkPassword = inputPassword.getAttribute("value");

        //Validate the generated texts
        checkIfNull(checkMobileNumber, checkPassword);

    }

}
