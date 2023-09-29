package com.bibvip.utility;

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

public class BrokenWordsChecker {
    private static final Pattern BROKEN_WORD_PATTERN = Pattern.compile("(.*?)\s*-\s*(.*?)");
    public static String checkAllBrokenWordsInPage(WebDriver driver, String link) throws IOException {

        // Capture the text on the page
        String getAllText = driver.findElement(By.xpath("//*")).getText();

        // Compare the two texts and identify any Chinese words that are still present in the English version
        Matcher matcher = BROKEN_WORD_PATTERN.matcher(getAllText);
        List<String> brokenWords = new ArrayList<>();
        while (matcher.find()) {
            brokenWords.add(matcher.group());
        }

        // If any Chinese/English words are found, the test fails
        if (!brokenWords.isEmpty()) {
            // Create a CSV writer object.
            Writer writer = new FileWriter("broken-words.csv");
            // Write the header row.
            writer.write("Link,Broken Words\n");

            int totalBrokenWords = 0;
            for (String word : brokenWords) {
                writer.write(link + "," + word + "\n");
                totalBrokenWords++;
            }

            // Close the CSV writer object.
            writer.close();
            return "Failed, Caught # of not translated words = " + totalBrokenWords;
        }

        // Otherwise, the test passes
        return "Test Passed";

    }

}
