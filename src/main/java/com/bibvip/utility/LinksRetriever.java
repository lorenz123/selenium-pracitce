package com.bibvip.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
This utility class is used for getting all the links in a page.
 */
public class LinksRetriever {

    public static void getAllLinksInPage(WebDriver driver, String url, String filename) throws IOException {

        // Get all the link elements on the page.
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Create a CSV writer object.
        Writer writer = new FileWriter(filename+".csv");

        // Write the header row.
        writer.write("Page - "+url+",Links\n");

        // Iterate through the link elements and write the link text and href to the CSV file.
        for (WebElement link : links) {
            writer.write(url + "," + link.getAttribute("href") + "\n");
        }

        // Close the CSV writer object.
        writer.close();

        // Quit the web driver.
        driver.quit();
    }


}
