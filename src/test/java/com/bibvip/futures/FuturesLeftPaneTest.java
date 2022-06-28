package com.bibvip.futures;

import com.bibvip.jumpers.Jumper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.ArrayList;

import static com.bibvip.configs.DriverConfig.getChromeConfig;
import static com.bibvip.variables.FuturesVars.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class FuturesLeftPaneTest {

//    ArrayList<String> activePairPricesFields = new ArrayList();
    Field[] activePairPricesFields = ActivePairPrices.class.getDeclaredFields();
    Field[] marketBlockFields = MarketBlock.class.getDeclaredFields();
    Field[] timeframesFields = Timeframes.class.getDeclaredFields();
    WebDriver driverChrome;
    JavascriptExecutor j;

    @BeforeAll
    @DisplayName("Driver runner, Jumper Futures")
    void testRunDriver() throws MalformedURLException {
        driverChrome = getChromeConfig();
        Jumper.jumpToFutures(driverChrome);
    }

    @Nested
    @Order(1)
    @DisplayName("Active Prices Tests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ActivePrices {

        @Test
        @Order(1)
        @DisplayName("Test active pair, it's price and change values")
        void testActivePairPrices() throws IllegalAccessException, InterruptedException {
            ActivePairPrices.checkActivePairPrices(driverChrome);
            Field activePair = activePairPricesFields[1];
            Field activePairPrice = activePairPricesFields[2];
            Field activePairChange = activePairPricesFields[3];

            Object activePairStr = activePair.get(String.class);
            Object activePairPriceStr = activePairPrice.get(String.class);
            Object activePairChangeStr = activePairChange.get(String.class);

            assertEquals("BTCUSDT", activePairStr);
            assertNotEquals("--", activePairPriceStr);
            assertNotEquals("--", activePairChangeStr);

            log.info("Active Pair: "+activePairStr+", Price: "+activePairPriceStr+", Change: "+activePairChangeStr);
        }

        @Test
        @Order(2)
        @DisplayName("Test CHANGES of active pair, it's price and change values")
        void testSecondActivePairPrices() throws IllegalAccessException {
            ActivePairPrices.checkChangesActivePairPrices(driverChrome);
            Field activePair = activePairPricesFields[1];
            Field activePairPrice = activePairPricesFields[2];
            Field activePairChange = activePairPricesFields[3];
            Field activeSecondPairPrice = activePairPricesFields[4];
            Field activeSecondPairChange = activePairPricesFields[5];

            Object activePairStr = activePair.get(String.class);
            Object activePairPriceStr = activePairPrice.get(String.class);
            Object activePairChangeStr = activePairChange.get(String.class);
            Object activeSecondPairPriceStr = activeSecondPairPrice.get(String.class);
            Object activeSecondPairChangeStr = activeSecondPairChange.get(String.class);

            assertEquals("BTCUSDT", activePairStr);
            assertNotEquals(activeSecondPairPriceStr, activePairPriceStr);
            assertNotEquals(activeSecondPairChangeStr, activePairChangeStr);

            log.info("Active Pair: "+activePairStr+", Second Price: "+activeSecondPairPriceStr+", Second Change: "+activeSecondPairChangeStr);
        }

        @AfterEach
        @DisplayName("Wait for 5 seconds")
        void beforeEach() throws InterruptedException {
            Thread.sleep(5000);
        }
    }

    @Nested
    @Order(2)
    @DisplayName("Symbols Values Tests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SymbolsValues {

        @Test
        @DisplayName("Test Symbols Values")
        @Order(1)
        void testSymbolsValues() throws IllegalAccessException {
            ActivePairPrices.checkSymbolsValues(driverChrome);
            Field markPrice = activePairPricesFields[6];
            Field indexPrice = activePairPricesFields[7];
            Field fundingRate = activePairPricesFields[8];
            Field estNextRate = activePairPricesFields[9];
            Field volume = activePairPricesFields[10];

            Object markPriceStr = markPrice.get(String.class);
            Object indexPriceStr = indexPrice.get(String.class);
            Object fundingRateStr = fundingRate.get(String.class);
            Object estNextRateStr = estNextRate.get(String.class);
            Object volumeStr = volume.get(String.class);


            assertNotEquals("--", markPriceStr);
            log.info("Mark Price value : "+markPriceStr);

            assertNotEquals("--", indexPriceStr);
            log.info("Index Price value : "+indexPriceStr);

            assertNotEquals("--% /", fundingRateStr);
            log.info("Funding Rate value : "+fundingRateStr);

            assertNotEquals("--%", estNextRateStr);
            log.info("Est. Next Rate value : "+estNextRateStr);

            assertNotEquals("-- BTC", volumeStr);
            log.info("24h Volume value : "+volumeStr);
        }
    }

    @Nested
    @Order(3)
    @DisplayName("Market Block Tests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class MarketBlockDisplays {

        @Test
        @DisplayName("Test of Market Block if Displayed")
        @Order(1)
        void checkDisplay() throws InterruptedException, IllegalAccessException {
            MarketBlock.checkMarketBlockDisplay(driverChrome);
            Field isMarketBlockDisplayed = marketBlockFields[1];
            Object isMarketBlockDisplayedStr = isMarketBlockDisplayed.get(String.class);
            assertEquals(true, isMarketBlockDisplayedStr);
            log.info("Market Block Displayed is: "+isMarketBlockDisplayedStr);
        }

        @Test
        @DisplayName("Test of Market Block if Dismissed")
        @Order(2)
        void checkDismiss() throws InterruptedException, IllegalAccessException {
            MarketBlock.checkMarketBlockDismiss(driverChrome);
            Field isMarketBlockDismissed = marketBlockFields[2];
            Object isMarketBlockDismissedStr = isMarketBlockDismissed.get(String.class);
            assertEquals(false, isMarketBlockDismissedStr);
            log.info("Market Block Displayed is: "+isMarketBlockDismissedStr);
        }

        @AfterEach
        @DisplayName("Wait for 3 seconds after each test")
        void beforeEach() throws InterruptedException {
            Thread.sleep(3000);
        }

    }

    @Nested
    @Order(4)
    @DisplayName("Graph Timeframes Tests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class GraphTimeframes {

        @Test
        @DisplayName("Test of 1 minute timeframe values")
        @Order(1)
        void checkOneMinuteTF() throws InterruptedException, IllegalAccessException {

//            Field oneMin = timeframesFields[1];
//            Object oneMinStr = oneMin.get(String.class);
//            Timeframes.timeframeExecutor(driverChrome, (String) oneMinStr);

//            Field timeframeValues = timeframesFields[11];
//            Object activeTFStr = timeframeValues.get(String.class);


//            log.info("Active Time frame selected: "+activeTFStr);
//            assertNotEquals("n/a", activeTFStr);


        }

        @Test
        @DisplayName("Test of 5 minutes timeframe values")
        @Order(2)
        void checkFiveMinuteTF() throws IllegalAccessException, InterruptedException {
            Field fiveMin = timeframesFields[2];
            Object fiveMinStr = fiveMin.get(String.class);
            Timeframes.timeframeExecutor(driverChrome, (String) fiveMinStr);
            assertNotEquals("n/a", fiveMinStr);
            log.info("Time frame selected: "+fiveMinStr);
        }
//
//        @Test
//        @DisplayName("Test of 15 minutes timeframe values")
//        @Order(3)
//        void checkFifteenMinuteTF() throws IllegalAccessException, InterruptedException {
//            Field fifteenMin = timeframesFields[3];
//            Object fifteenMinStr = fifteenMin.get(String.class);
//            Timeframes.timeframeExecutor(driverChrome, (String) fifteenMinStr);
//            assertNotEquals("n/a", fifteenMinStr);
//            log.info("Time frame selected: "+fifteenMinStr);
//        }
//
//        @Test
//        @DisplayName("Test of 30 minutes timeframe values")
//        @Order(4)
//        void checkThirtyMinuteTF() throws IllegalAccessException, InterruptedException {
//            Field thirtyMin = timeframesFields[4];
//            Object thirtyMinStr = thirtyMin.get(String.class);
//            Timeframes.timeframeExecutor(driverChrome, (String) thirtyMinStr);
//            assertNotEquals("n/a", thirtyMinStr);
//            log.info("Time frame selected: "+thirtyMinStr);
//        }
//
//        @Test
//        @DisplayName("Test of 60 minutes timeframe values")
//        @Order(5)
//        void checkSixtyMinuteTF() throws IllegalAccessException, InterruptedException {
//            Field sixtyMin = timeframesFields[5];
//            Object sixtyMinStr = sixtyMin.get(String.class);
//            Timeframes.timeframeExecutor(driverChrome, (String) sixtyMinStr);
//            assertNotEquals("n/a", sixtyMinStr);
//            log.info("Time frame selected: "+sixtyMinStr);
//        }
//
//        @Test
//        @DisplayName("Test of 4 hours timeframe values")
//        @Order(6)
//        void checkFourHoursTF() throws IllegalAccessException, InterruptedException {
//            Field fourHour = timeframesFields[6];
//            Object fourHourStr = fourHour.get(String.class);
//            Timeframes.timeframeExecutor(driverChrome, (String) fourHourStr);
//            assertNotEquals("n/a", fourHourStr);
//            log.info("Time frame selected: "+fourHourStr);
//        }
//
//        @Test
//        @DisplayName("Test of 1 day timeframe values")
//        @Order(7)
//        void checkOneDayTF() throws IllegalAccessException, InterruptedException {
//            Field oneDay = timeframesFields[7];
//            Object oneDayStr = oneDay.get(String.class);
//            Timeframes.timeframeExecutor(driverChrome, (String) oneDayStr);
//            assertNotEquals("n/a", oneDayStr);
//            log.info("Time frame selected: "+oneDayStr);
//        }
//
//        @Test
//        @DisplayName("Test of 1 week timeframe values")
//        @Order(8)
//        void checkOneWeekTF() throws IllegalAccessException, InterruptedException {
//            Field oneWeek = timeframesFields[8];
//            Object oneWeekStr = oneWeek.get(String.class);
//            Timeframes.timeframeExecutor(driverChrome, (String) oneWeekStr);
//            assertNotEquals("n/a", oneWeekStr);
//            log.info("Time frame selected: "+oneWeekStr);
//        }
//
//        @Test
//        @DisplayName("Test of 1 month timeframe values")
//        @Order(9)
//        void checkOneMonthTF() throws IllegalAccessException, InterruptedException  {
//            Field oneMonth = timeframesFields[9];
//            Object oneMonthStr = oneMonth.get(String.class);
//            Timeframes.timeframeExecutor(driverChrome, (String) oneMonthStr);
//            assertNotEquals("n/a", oneMonthStr);
//            log.info("Time frame selected: "+oneMonthStr);
//        }
//
//        @Test
//        @DisplayName("Test of full screen timeframe values")
//        @Order(10)
//        void checkFullScreenTF() throws InterruptedException, IllegalAccessException {
//            Field fullScreen = timeframesFields[10];
//            Object fullScreenStr = fullScreen.get(String.class);
//            Timeframes.timeframeExecutor(driverChrome, (String) fullScreenStr);
//
//
//            assertNotEquals("n/a", fullScreenStr);
//            log.info("Full screen selected?: "+fullScreenStr);
//        }

        @AfterEach
        @DisplayName("Wait for 2 seconds")
        void beforeEach() throws InterruptedException {
            Thread.sleep(2000);
        }
    }
}