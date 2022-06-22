package com.bibvip.futures;

import com.bibvip.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

import static com.bibvip.jumpers.Jumper.jumpToFutures;
import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.variables.FuturesVars.*;
import static com.bibvip.variables.LoginVars.PASSWORD_TEXTFIELD;

@Slf4j
public class FuturesAuto {

    public static void doFuturesAuto(WebDriver driverChrome) throws InterruptedException {
        //Perform Auto Futures using selenium

        jumpToFutures(driverChrome); //reusable jumper to Futures page

        WebElement activePair = driverChrome.findElement(getBy(ACTIVE_PAIR_LASTPRICE_CHANGE, ElementType.CSS_SELECTOR));
        String convertActivePairToText = activePair.getText();
        String[] seperateActivePairValues = convertActivePairToText.split("\\n| "); //regex operation OR (|) was used to seperate line break and white space to create an array

        log.info("First value :" + seperateActivePairValues[0]); //Check if default is BTCUSDT
        log.info("First value :" + seperateActivePairValues[1]); //Check if Last Price is present and != 0
        log.info("First value :" + seperateActivePairValues[2]); //Check if Change is present and != 0


        if(!seperateActivePairValues[0].equals("BTCUSDT")) {
            log.error("Incorrect Default Futures Pair! BTCUSDT should be the default futures pair.");
        } else if (seperateActivePairValues[1].equals("--")) {
            log.error("Last Price of Active Pair is not displayed!");
        } else if (seperateActivePairValues[2].equals("--%")) {
            log.error("Change of Active Pair is not displayed!");
        } else {
            log.info("First Item - No errors");
        }


        JavascriptExecutor j = (JavascriptExecutor) driverChrome;
        j.executeScript ("document.querySelector('"+SHOW_PAIRS_DROPDOWN_BUTTON+"').click();"); //javascript executeScript was used because click() of selenium is not working on dropdown buttons
        log.info("Market Block was displayed after clicking dropdown button");

        boolean isMarketBlock = driverChrome.findElement(getBy(MARKET_BLOCK, ElementType.CSS_SELECTOR)).isDisplayed();
        log.info("Market Block displayed? " + String.valueOf(isMarketBlock));

        // wait time added
        Thread.sleep(15000);

        j.executeScript ("document.querySelector('"+SHOW_PAIRS_DROPDOWN_BUTTON+"').click();"); //javascript executeScript was used because click() of selenium is not working on dropdown buttons
        log.info("Market Block was dismissed after clicking dropdown button");

        boolean isMarketBlockAgain = driverChrome.findElement(getBy(MARKET_BLOCK, ElementType.CSS_SELECTOR)).isDisplayed();
        log.info("Market Block displayed? " + String.valueOf(isMarketBlockAgain));

        //check lastprice and change after 10 seconds has passed, it should change
        WebElement checkActivePair2ndTime = driverChrome.findElement(getBy(ACTIVE_PAIR_LASTPRICE_CHANGE, ElementType.CSS_SELECTOR));
        String convertActivePairToText2 = checkActivePair2ndTime.getText();
        String[] seperateActivePairValues2 = convertActivePairToText2.split("\\n| "); //regex operation OR (|) was used to seperate line break and white space to create an array

        log.info("Value after 15s:" + seperateActivePairValues2[1]); //Check if Last Price is present and != 0
        log.info("Value after 15s:" + seperateActivePairValues2[2]); //Check if Change is present and != 0

        if (seperateActivePairValues[1] == seperateActivePairValues2[1]) {
            log.info("Last Price did not change after 15seconds");
        } else if (seperateActivePairValues[2] == seperateActivePairValues2[2]) {
            log.info("Change did not change after 15seconds");
        } else {
            log.info("Last Price and Change has changed after 15seconds");
        }

        WebElement symbolsValues = driverChrome.findElement(getBy(SYMBOLS_BLOCK, ElementType.CSS_SELECTOR));
        String convertSymbolsValues = symbolsValues.getText();
        String[] seperateSymbolsValues = convertSymbolsValues.split("\\n");

        //remover of empty strings, note that by splitting some data are empty
        String[] removedNullAndEmptyStrings = Arrays.stream(seperateSymbolsValues)
                .filter(value ->
                        value != null && value.length() > 0
                )
                .toArray(size -> new String[size]);

        //-- , --%, --% /
        for(int i = 0; i < removedNullAndEmptyStrings.length; i++){

            if(removedNullAndEmptyStrings[i].contains("--")) {
                log.error(removedNullAndEmptyStrings[i] + " - Mark, Index, 24h Volume, Cont - Some symbols does not returns a value, it only shows \"--\"");
            } else if (removedNullAndEmptyStrings[i].equals("--%")) {
                log.error(removedNullAndEmptyStrings[i] + " - The Est. Next Rate does not have value, it only shows \"--%\"");
            } else if (removedNullAndEmptyStrings[i].equals("--% /")) {
                log.error(removedNullAndEmptyStrings[i] + " - The Funding rate does not have value, it only shows \"--% /\"");
            } else {
                log.info(removedNullAndEmptyStrings[i] + " - have a value!");
            }

        }

        // wait time added
        Thread.sleep(3000);

        //timeframes
        j.executeScript ("document.querySelector('"+ONE_MIN_TF+"').click();");
        //TODO get value of the graph per minute (upper-left of screen)
        WebElement oneMinuteGraph = driverChrome.findElement(getBy(ONE_MIN_TF, ElementType.CSS_SELECTOR));
        log.info("One Minute Graph (Minutes): "+oneMinuteGraph.getText());
        Thread.sleep(3000);

//        j.executeScript ("document.querySelector('"+FIVE_MIN_TF+"').click();");
//        j.executeScript ("document.querySelector('"+FIFTEEN_MIN_TF+"').click();");
//        j.executeScript ("document.querySelector('"+THIRTY_MIN_TF+"').click();");
//        j.executeScript ("document.querySelector('"+SIXTY_MIN_TF+"').click();");
//        j.executeScript ("document.querySelector('"+FOUR_HOUR_TF+"').click();");
//        j.executeScript ("document.querySelector('"+ONE_DAY_TF+"').click();");
//        j.executeScript ("document.querySelector('"+ONE_WEEK_TF+"').click();");

//        WebElement oneMinuteTF = driverChrome.findElement(getBy(ONE_MIN_TF, ElementType.CSS_SELECTOR));
//        WebElement fiveMinuteTF = driverChrome.findElement(getBy(FIVE_MIN_TF, ElementType.CSS_SELECTOR));
//        WebElement fifteenMinuteTF = driverChrome.findElement(getBy(FIFTEEN_MIN_TF, ElementType.CSS_SELECTOR));
//        WebElement thirtyMinuteTF = driverChrome.findElement(getBy(THIRTY_MIN_TF, ElementType.CSS_SELECTOR));
//        WebElement sixtyMinuteTF = driverChrome.findElement(getBy(SIXTY_MIN_TF, ElementType.CSS_SELECTOR));
//        WebElement fourHourTF = driverChrome.findElement(getBy(FOUR_HOUR_TF, ElementType.CSS_SELECTOR));
//        WebElement oneDayTF = driverChrome.findElement(getBy(ONE_DAY_TF, ElementType.CSS_SELECTOR));
//        WebElement oneWeekTF = driverChrome.findElement(getBy(ONE_WEEK_TF, ElementType.CSS_SELECTOR));

//        oneMinuteTF.click(); // wait time added
//        WebElement oneMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String checkOneMinuteGraph = oneMinuteGraph.getText();
//        log.info("One Minute Graph (Minutes): "+checkOneMinuteGraph);
//        Thread.sleep(3000);

////        fiveMinuteTF.click(); // wait time added
//        WebElement fiveMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String checkFiveMinuteGraph = fiveMinuteGraph.getText();
//        log.info("Five Minute Graph (Minutes): "+checkFiveMinuteGraph);
//        Thread.sleep(3000);
//
////        fifteenMinuteTF.click(); // wait time added
//        WebElement fifteenMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String checkFifteenMinuteGraph = fifteenMinuteGraph.getText();
//        log.info("Fifteen Minute Graph (Minutes): "+checkFifteenMinuteGraph);
//        Thread.sleep(3000);
//
////        thirtyMinuteTF.click(); // wait time added
//        WebElement thirtyMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String checkThirtyMinuteGraph = thirtyMinuteGraph.getText();
//        log.info("Thirty Minute Graph (Minutes): "+checkThirtyMinuteGraph);
//        Thread.sleep(3000);
//
////        sixtyMinuteTF.click(); // wait time added
//        WebElement sixtyMinuteGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String checkSixtyMinuteGraph = sixtyMinuteGraph.getText();
//        log.info("One Minute Graph (Minutes): "+checkSixtyMinuteGraph);
//        Thread.sleep(3000);
//
////        fourHourTF.click(); // wait time added
//        WebElement fourHourGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String checkFourHourGraph = fourHourGraph.getText();
//        log.info("Four Hour Graph (Minutes): "+checkFourHourGraph);
//        Thread.sleep(3000);
//
////        oneDayTF.click(); // wait time added
//        WebElement oneDayGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String checkOneDayGraph = oneDayGraph.getText();
//        log.info("One Day Graph (Minutes): "+checkOneDayGraph);
//        Thread.sleep(3000);
//
////        oneWeekTF.click(); // wait time added
//        WebElement oneWeekGraph = driverChrome.findElement(getBy(ACTIVE_TF_GRAPH, ElementType.CSS_SELECTOR));
//        String checkOneWeekGraph = oneWeekGraph.getText();
//        log.info("One Week Graph (Minutes): "+checkOneWeekGraph);
//        Thread.sleep(3000);


    }


    //get lastprice and change price of all should not be 0
    public static void getLastPriceChange(WebDriver driverChrome) {


    }

}
