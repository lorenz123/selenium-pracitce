package com.bibvip.login;

import com.bibvip.configs.consts.ElementType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibvip.utility.ThinkingTimeUtil.getWebDriverWait;

public class LoginWithGeetest {
    public static void automatedLoginWithGeetest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // Open a new window for each URL.
        String url = "https://www.bibvip.com/en_US/login";
        // Navigate to the page.
        driver.get(url);
        driver.manage().window().maximize();

        WebDriverWait wait = getWebDriverWait(driver);

        String emailSectionPath = "//span[@class='bib-1-cl']";
        String emailPath = "/html/body/div[3]/div/div[2]/section/div[2]/div/div[1]/form/section[1]/div[1]/div[2]/input";
        String passwordPath = "/html/body/div[3]/div/div[2]/section/div[2]/div/div[1]/form/section[2]/div[1]/div[2]/input";
        String loginBtnPath = "login-btn";
        String geetestArrowPath = "/html/body/div[5]/div[1]/div[1]/div[2]/div/div/div[2]/div/div[3]";

        WebElement emailSection = getElementWithPolling(wait, getBy(emailSectionPath, ElementType.X_PATH));
        emailSection.click();

        WebElement email = getElementWithPolling(wait, getBy(emailPath, ElementType.X_PATH));
        email.click();
        email.sendKeys("lianaegon1011@gmail.com");

        WebElement pwd = getElementWithPolling(wait, getBy(passwordPath, ElementType.X_PATH));
        pwd.click();
        pwd.sendKeys("Aaaa1234#");

        WebElement loginBtn = getElementWithPolling(wait, getBy(loginBtnPath, ElementType.ID));
        loginBtn.click();

        Thread.sleep(5000);
        Dimension size = driver.manage().window().getSize();
        System.out.println("size of page - " + size);

        WebElement geetestArrow = getElementWithPolling(wait, getBy(geetestArrowPath, ElementType.X_PATH));
        if(geetestArrow.isDisplayed()){
            System.out.println("Test passed - geetest is appearing");
        }

        int range = 230;
        Random random = new Random();
        int randomNumber = random.nextInt(range - 10) + 10;
        randomNumber = randomNumber - (randomNumber % 10);

        int i = 0;
        while(i < 100) {
            // Move the mouse cursor to the specified position
            Actions actions = new Actions(driver);
            actions.moveToElement(geetestArrow).perform();
            actions.clickAndHold(geetestArrow).moveByOffset(randomNumber, 0).release().build().perform();
            i++;
            Thread.sleep(4000);
        }
        Thread.sleep(2000);

    }
}
