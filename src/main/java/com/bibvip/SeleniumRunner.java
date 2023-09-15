package com.bibvip;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bibvip.configs.consts.BibEnglishLinks.*;
import static com.bibvip.utility.LinksRetriever.getAllLinksInPage;
import static com.bibvip.utility.LocalizationChecker.chineseCheckWordsInPage;
import static com.bibvip.utility.LocalizationChecker.englishCheckWordsInPage;

@Slf4j
public class SeleniumRunner {



    //TODO - get all the links of bibvip
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open a new window for each URL.
        String url = "https://www.bibvip.com/en_US/";
        // Navigate to the page.
        driver.get(url);
        driver.manage().window().maximize();

//        getAllLinksInPage(driver, url, "lanceburat");

//        System.out.println(chineseCheckWordsInPage(driver,  ENGLISH_HOME));
//        Thread.sleep(10);
//
//        ((JavascriptExecutor) driver).executeScript("window.open('https://www.google.com');");
//        System.out.println(englishCheckWordsInPage(driver,  "https://www.google.com"));

    }

}
