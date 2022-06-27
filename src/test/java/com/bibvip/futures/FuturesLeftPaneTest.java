package com.bibvip.futures;

import com.bibvip.jumpers.Jumper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;

import static com.bibvip.configs.DriverConfig.getChromeConfig;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FuturesLeftPaneTest {

    Field[] activePairPricesFields = ActivePairPrices.class.getDeclaredFields();
//    Field[] marketBlockFields = MarketBlock.class.getDeclaredFields();
//    Field[] timeframesFields = Timeframes.class.getDeclaredFields(); //TODO not yet set on the Timeframes class

    @BeforeAll
    @DisplayName("Driver runner, Jumper Futures")
    void testRunDriver() {
        WebDriver driverChrome = getChromeConfig();
        JavascriptExecutor j = (JavascriptExecutor) driverChrome;

        Jumper.jumpToFutures(driverChrome);
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Order(1)
    @DisplayName("Active Prices Tests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ActivePrices {

        @Test
        @Order(1)
        @DisplayName("Test active pair, it's price and change values")
        void testActivePairPrices(WebDriver driverChrome) throws IllegalAccessException, InterruptedException {
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
        void testSecondActivePairPrices(WebDriver driverChrome) throws IllegalAccessException {
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

            assertNotEquals("BTCUSDT", activePairStr);
            assertNotEquals(activeSecondPairPriceStr, activePairPriceStr);
            assertNotEquals(activeSecondPairChangeStr, activePairChangeStr);

            log.info("Active Pair: "+activePairStr+", Second Price: "+activeSecondPairPriceStr+", Second Change: "+activeSecondPairChangeStr);
        }

        @AfterEach
        @DisplayName("Wait for 15 seconds")
        void beforeEach() throws InterruptedException {
            Thread.sleep(15000);
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Order(2)
    @DisplayName("Symbols Values Tests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class SymbolsValues {

        @Test
        @DisplayName("Test Symbols Values")
        @Order(1)
        void testSymbolsValues(WebDriver driverChrome) throws IllegalAccessException {
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
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Order(3)
    @DisplayName("Market Block Tests")
    class MarketBlock {

        @BeforeAll
        void automatedTestActivePrices(){
            //automated class that holds the method for Active Prices
        }

        @Test
        @DisplayName("Test 1")
        @Order(1)
        void test1() throws IllegalAccessException {

        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Order(4)
    @DisplayName("Graph Timeframes Tests")
    class GraphTimeframes {

        @BeforeAll
        void automatedTestActivePrices(){
            //automated class that holds the method for Active Prices
        }

        @Test
        @DisplayName("Test 1")
        @Order(1)
        void test1() throws IllegalAccessException {

        }
    }
}