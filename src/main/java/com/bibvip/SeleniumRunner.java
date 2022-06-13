package com.bibvip;

import com.bibvip.credential.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumRunner {

    public static void runTheSelenium(Credentials credentials){
        //fields
        String chromeLocation = "C:\\selenium-4.2.1\\Browser WebDrivers\\chromedriver_win32\\\\chromedriver.exe";
        String prodBaseUrl = "https://www.bibvip.com/en_US";

        //Browser Driver objects
        System.setProperty("webdriver.chrome.driver",chromeLocation);
        WebDriver driverChrome = new ChromeDriver();

        // Chrome test
        driverChrome.get(prodBaseUrl);

        WebElement cClickLogin = driverChrome.findElement(By.cssSelector(".menu2:nth-child(1) > .link"));
        cClickLogin.click();

        WebElement cInputMobile = driverChrome.findElement(By.cssSelector(".input-line-content:nth-child(3) .b-1-cl"));
        WebElement cInputPassword = driverChrome.findElement(By.cssSelector(".input-line-content:nth-child(4) .b-1-cl"));

        cInputMobile.sendKeys(credentials.getMobileNumber());
        cInputPassword.sendKeys(credentials.getPassword());

        //fetch textbox new value
        String checkMobileNumber = cInputMobile.getAttribute("value");
        String checkPassword = cInputPassword.getAttribute("value");

        //Check whether both fields are empty or not
        if (checkMobileNumber != null && checkPassword != null){
            System.out.println("Test Passed! All fields are filled.");
        } else {
            System.out.println("Test Failed! Fields was not filled.");
        }

        //Done (Close browsers)
        driverChrome.close();
    }

}
