package com.bibvip.futures;


import com.bibvip.consts.ElementType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

import static com.bibvip.utility.AppUtil.getBy;
import static com.bibvip.variables.FuturesVars.ACTIVE_PAIR_LASTPRICE_CHANGE;
import static com.bibvip.variables.FuturesVars.SYMBOLS_BLOCK;

@Slf4j
public class ActivePairPrices {

    //fields of item 1
    public static String activePair;
    public static String activePairPrice;
    public static String activePairChange;

    //fields of item 3
    public static String secondActivePairPrice;
    public static String secondActivePairChange;

    //fields of item 4
    public static String markPrice; //[1]
    public static String indexPrice;//[3]
    public static String fundingRate;//[5]
    public static String estNextRate;//[7]
    public static String oneDayVolume;//[9]

    //item 1,3,4
    public static void checkActivePairPrices(WebDriver driverChrome) throws InterruptedException {
        //item 1
        //get elements
        WebElement fetchActivePair = driverChrome.findElement(getBy(ACTIVE_PAIR_LASTPRICE_CHANGE, ElementType.CSS_SELECTOR));
        String convertActivePairToText = fetchActivePair.getText();
        String[] seperateActivePairValues = convertActivePairToText.split("\\n| "); //regex operation OR (|) was used to seperate line break and white space to create an array

        //data checking area
        activePair = seperateActivePairValues[0]; //Check if default is BTCUSDT
        activePairPrice = seperateActivePairValues[1]; //Check if Last Price is present and != 0
        activePairChange = seperateActivePairValues[2]; //Check if Change is present and != 0

        //validation area
        if(!activePair.equals("BTCUSDT")) {
            log.error("Incorrect Default Futures Pair! BTCUSDT should be the default futures pair.");
        } else if (activePairPrice.equals("--")) {
            log.error("Last Price of Active Pair is not displayed!");
        } else if (activePairChange.equals("--%")) {
            log.error("Change of Active Pair is not displayed!");
        } else {
            log.info("Active Pair is "+activePair+" with price of "+activePairPrice+" and Change of "+activePairChange);
        }
        Thread.sleep(15000);

    }

    public static void checkChangesActivePairPrices(WebDriver driverChrome) {
        //item 3
        //get elements
        WebElement checkActivePair2ndTime = driverChrome.findElement(getBy(ACTIVE_PAIR_LASTPRICE_CHANGE, ElementType.CSS_SELECTOR));
        String convertActivePairToText2 = checkActivePair2ndTime.getText();
        String[] seperateActivePairValues2 = convertActivePairToText2.split("\\n| "); //regex operation OR (|) was used to seperate line break and white space to create an array

        //data checking area
        secondActivePairPrice = seperateActivePairValues2[1]; //Check if Last Price is present and != 0
        secondActivePairChange = seperateActivePairValues2[2]; //Check if Change is present and != 0

        //validation area
        if (activePairPrice == secondActivePairPrice) {
            log.info("Last Price did not change after 15seconds");
        } else if (activePairChange == secondActivePairChange) {
            log.info("Change did not change after 15seconds");
        } else {
            log.info("Last Price and Change has changed after 15seconds");
        }
    }

    public static void checkSymbolsValues(WebDriver driverChrome){
        //item 4
        //get elements
        WebElement symbolsValues = driverChrome.findElement(getBy(SYMBOLS_BLOCK, ElementType.CSS_SELECTOR));
        String convertSymbolsValues = symbolsValues.getText();

        //split elements into an array
        String[] seperateSymbolsValues = convertSymbolsValues.split("\\n");
        String[] removedNullAndEmptyStrings = Arrays.stream(seperateSymbolsValues)
                .filter(value ->
                        value != null && value.length() > 0
                )
                .toArray(size -> new String[size]);

        markPrice = removedNullAndEmptyStrings[1];
        indexPrice = removedNullAndEmptyStrings[3];
        fundingRate = removedNullAndEmptyStrings[5];
        estNextRate = removedNullAndEmptyStrings[7];
        oneDayVolume = removedNullAndEmptyStrings[9];

        //validation area (improve this by selecting only the selected fields for the error)
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
    }

}
