package com.bibvip.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class brokenWordsChecker {
    private static final Pattern BROKEN_WORD_PATTERN = Pattern.compile("(.*?)\s*-\s*(.*?)");
    public static void checkAllBrokenWordsInPage(WebDriver driver, String link){

        List<WebElement> textElements = driver.findElements(By.xpath("//*"));

        // Iterate over the text elements and check if any of them contain broken words.
        for (WebElement textElement : textElements) {
            String text = textElement.getText();

            // Match the broken words in the text.
            Matcher matcher = BROKEN_WORD_PATTERN.matcher(text);

            while (matcher.find()) {
                // The word is broken.
                System.out.println("Broken word found: " + matcher.group(1) + " - " + matcher.group(2));
            }


        }
    }

}
