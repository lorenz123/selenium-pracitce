package com.bibvip.utility;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Slf4j
public class LocalizationChecker {

    private static final Pattern CHINESE_WORD_PATTERN = Pattern.compile("[\\u4e00-\\u9fa5]+");
    private static final Pattern ENGLISH_WORD_PATTERN = Pattern.compile("[a-zA-Z]+");

    /**
    Used to check English words in A Chinese website
     **/
    public static String englishCheckWordsInPage(WebDriver driver, String link) throws IOException {
        // Capture the text on the page
        String getAllText = driver.findElement(By.xpath("//*")).getText();

        // Compare the two texts and identify any Chinese words that are still present in the English version
        Matcher matcher = ENGLISH_WORD_PATTERN.matcher(getAllText);
        List<String> checkWords = new ArrayList<>();
        while (matcher.find()) {
            checkWords.add(matcher.group());
        }

        // If any Chinese/English words are found, the test fails
        if (!checkWords.isEmpty()) {
            // Create a CSV writer object.
            Writer writer = new FileWriter("not-translated-words.csv");
            // Write the header row.
            writer.write("Link,Not Translated Words\n");

            int totalNotTranslatedWords = 0;
            for (String word : checkWords) {
                writer.write(link + "," + word + "\n");
                totalNotTranslatedWords++;
            }

            // Close the CSV writer object.
            writer.close();
            return "Failed, Caught # of not translated words = " + totalNotTranslatedWords;
        }

        // Otherwise, the test passes
        return "Test Passed";
    }

    /**
     Used to check Chinese words in A English website
     **/
    public static String chineseCheckWordsInPage(WebDriver driver, String link) throws IOException {
        // Capture the text on the page
        String getAllText = driver.findElement(By.xpath("//*")).getText();

        // Compare the two texts and identify any Chinese words that are still present in the English version
        Matcher matcher = CHINESE_WORD_PATTERN.matcher(getAllText);
        List<String> checkWords = new ArrayList<>();
        while (matcher.find()) {
            checkWords.add(matcher.group());
        }

        // If any Chinese/English words are found, the test fails
        if (!checkWords.isEmpty()) {
            // Create a CSV writer object.
            Writer writer = new FileWriter("chinese-not-translated-words.csv");
            // Write the header row.
            writer.write("Link,Not Translated Words\n");

            int totalNotTranslatedWords = 0;
            for (String word : checkWords) {
                writer.write(link + "," + word + "\n");
                totalNotTranslatedWords++;
            }

            // Close the CSV writer object.
            writer.close();
            return "Failed, Caught # of not translated words = " + totalNotTranslatedWords;
        }

        // Otherwise, the test passes
        return "Test Passed";
    }
}
