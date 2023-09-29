package com.bibvip;

import com.bibvip.configs.consts.ElementType;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bibvip.configs.consts.BibEnglishLinks.*;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.utility.LinksRetriever.*;
import static com.bibvip.utility.LocalizationChecker.chineseCheckWordsInPage;
import static com.bibvip.utility.LocalizationChecker.englishCheckWordsInPage;
import static com.bibvip.utility.ThinkingTimeUtil.getElementWithPolling;
import static com.bibvip.utility.ThinkingTimeUtil.getWebDriverWait;
import static com.bibvip.variables.LoginVars.PASSWORD_TEXTFIELD;

@Slf4j
public class SeleniumRunner {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        // Open a new window for each URL.
        String url = "https://www.bibvip.com/en_US/";
        // Navigate to the page.
        driver.get(url);
        // Create a thread pool executor.
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);

// Submit the task to the thread pool executor.
        threadPoolExecutor.submit(() -> {
            try {
                getAllLinksInPage(driver, url, "testlinks");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

// Shutdown the thread pool executor when you are finished.
        threadPoolExecutor.shutdown();

// Wait for all of the tasks to finish executing.
        threadPoolExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

    }

}
