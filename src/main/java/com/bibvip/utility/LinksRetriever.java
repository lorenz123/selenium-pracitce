package com.bibvip.utility;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
This utility class is used for getting all the links in a page.
 */
public class LinksRetriever {

    public static void getAllLinksInPage(WebDriver driver, String url, String filename) throws IOException {

        // Get all the link elements on the page.
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Create a CSV writer object.
        FileWriter writer = new FileWriter(filename+".csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        // Write the header row.
        bufferedWriter.write("Page - "+url+",Links,Status,Response Code\n");
        bufferedWriter.flush();

        // Iterate through the link elements and write the link text and href to the CSV file.
        for (WebElement link : links) {
            String href = link.getAttribute("href");
            String httpCheck = "";
            if(href == null){
                httpCheck = "Link is null";
            } else {
                httpCheck = href.substring(0, 4);
            }

            String status = "";
            int responseCode = 0;
            if(httpCheck.startsWith("http")){
                // Send a HTTP GET request to the URL specified in the href attribute
                URL liveURL = new URL(href);
                HttpURLConnection connection = (HttpURLConnection) liveURL.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                // Get the HTTP response code
                responseCode = connection.getResponseCode();

                // Check the HTTP response code to determine the status of the link

                if (responseCode == 200) {
                    status = "The link is OK.";
                } else {
                    status = "The link is broken.";
                }

                connection.disconnect();
                bufferedWriter.write(url + "," + href + "," + status + "," + responseCode + "\n");
                bufferedWriter.flush();
            }
            else {
                status = "Not a valid link";
                bufferedWriter.write(url + "," + href + "," + status + "," + responseCode + "\n");
                bufferedWriter.flush();
            }

        }

        // Close the CSV writer object.
        bufferedWriter.close();

        // Quit the web driver.
        driver.quit();
    }

}
