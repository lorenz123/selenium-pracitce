package com.bibvip.futures;

import com.bibvip.jumpers.Jumper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
        void testActivePairPrices() throws InterruptedException {
            ActivePairPrices.checkActivePairPrices(driverChrome);

            assertEquals("BTCUSDT", ActivePairPrices.activePair);
            assertNotEquals("--", ActivePairPrices.activePairPrice);
            assertNotEquals("--", ActivePairPrices.activePairChange);
            log.info("Active Pair: "+ActivePairPrices.activePair+", Price: "+ActivePairPrices.activePairPrice+", Change: "+ActivePairPrices.activePairChange);
        }

        @Test
        @Order(2)
        @DisplayName("Test CHANGES of active pair, it's price and change values")
        void testSecondActivePairPrices() throws IllegalAccessException {
            ActivePairPrices.checkChangesActivePairPrices(driverChrome);

            assertEquals("BTCUSDT", ActivePairPrices.activePair);
            assertNotEquals(ActivePairPrices.secondActivePairPrice, ActivePairPrices.activePairPrice);
            assertNotEquals(ActivePairPrices.secondActivePairChange, ActivePairPrices.activePairChange);

            log.info("Active Pair: "+ActivePairPrices.activePair+", Second Price: "+ActivePairPrices.secondActivePairPrice+", Second Change: "+ActivePairPrices.secondActivePairChange);
        }

        @AfterEach
        @DisplayName("Wait for 5 seconds")
        void afterEach() throws InterruptedException {
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
        void testSymbolsValues() {
            ActivePairPrices.checkSymbolsValues(driverChrome);

            assertNotEquals("--", ActivePairPrices.markPrice);
            log.info("Mark Price value : "+ActivePairPrices.markPrice);
            assertNotEquals("--", ActivePairPrices.indexPrice);
            log.info("Index Price value : "+ActivePairPrices.indexPrice);
            assertNotEquals("--% /", ActivePairPrices.fundingRate);
            log.info("Funding Rate value : "+ActivePairPrices.fundingRate);
            assertNotEquals("--%", ActivePairPrices.estNextRate);
            log.info("Est. Next Rate value : "+ActivePairPrices.estNextRate);
            assertNotEquals("-- BTC", ActivePairPrices.oneDayVolume);
            log.info("24h Volume value : "+ActivePairPrices.oneDayVolume);
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
        void checkDisplay() throws InterruptedException {
            MarketBlock.checkMarketBlockDisplay(driverChrome);

            assertEquals(true, MarketBlock.isMarketBlockDisplayed);
            log.info("Market Block Displayed is: "+MarketBlock.isMarketBlockDisplayed);
        }

        @Test
        @DisplayName("Test of Market Block if Dismissed")
        @Order(2)
        void checkDismiss() {
            MarketBlock.checkMarketBlockDismiss(driverChrome);

            assertEquals(false, MarketBlock.isMarketBlockDismissed);
            log.info("Market Block Displayed is: "+MarketBlock.isMarketBlockDismissed);
        }

        @AfterEach
        @DisplayName("Wait for 3 seconds after each test")
        void afterEach() throws InterruptedException {
            Thread.sleep(3000);
        }

    }

    @Nested
    @Order(4)
    @DisplayName("Test for Chart Setting buttons")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class ChartSettingBtns {

        @Test
        @DisplayName("Test of Chart Types Options")
        @Order(1)
        void checkDisplayChartTypesOptions() throws InterruptedException {
            Timeframes.checkChartTypeOptions(driverChrome);

            assertNotEquals(false, Timeframes.isChartTypesOptions);
            log.info("Chart Types Options is: "+Timeframes.isChartTypesOptions);

        }

        @Test
        @DisplayName("Test of Indicators Options")
        @Order(2)
        void checkDisplayIndicatorsOptions() throws InterruptedException {
            Timeframes.checkIndicatorsOptions(driverChrome);

            assertNotEquals(false, Timeframes.isIndicatorsOptionsAppearing);
            log.info("Indicators Options is: "+Timeframes.isIndicatorsOptionsAppearing);

        }

        @Test
        @DisplayName("Test of Chart Properties")
        @Order(3)
        void checkDisplayChartProperties() throws InterruptedException {
            Timeframes.checkChartProperties(driverChrome);

            assertNotEquals(false, Timeframes.isChartPropertiesAppearing);
            log.info("Chart Properties is: "+Timeframes.isChartPropertiesAppearing);
        }

        @AfterEach
        @DisplayName("Wait for 2 seconds")
        void afterEach() throws InterruptedException {
            Thread.sleep(2000);
        }
    }

    @Nested
    @Order(5)
    @DisplayName("Graph Timeframes Tests")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class GraphTimeframes {

        @Test
        @DisplayName("Test of 1 minute timeframe values")
        @Order(1)
        void checkOneMinuteTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, ONE_MIN_TF);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(0));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(0));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(1));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(1));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(2));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(2));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(3));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(3));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(4));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(4));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(5));
            log.info("Change : "+Timeframes.allGraphElementsList.get(5));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(6));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(6));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(7));
            log.info("MA10 : "+Timeframes.allGraphElementsList.get(7));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(8));
            log.info("MA30 : "+Timeframes.allGraphElementsList.get(8));

        }

        @Test
        @DisplayName("Test of 5 minutes timeframe values")
        @Order(2)
        void checkFiveMinuteTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, FIVE_MIN_TF);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(9));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(9));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(10));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(10));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(11));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(11));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(12));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(12));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(13));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(13));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(14));
            log.info("Change : "+Timeframes.allGraphElementsList.get(14));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(15));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(15));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(16));
            log.info("MA10 : "+Timeframes.allGraphElementsList.get(16));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(17));
            log.info("MA30 : "+Timeframes.allGraphElementsList.get(17));
        }

        @Test
        @DisplayName("Test of 15 minutes timeframe values")
        @Order(3)
        void checkFifteenMinuteTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, FIFTEEN_MIN_TF);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(18));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(18));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(19));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(19));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(20));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(20));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(21));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(21));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(22));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(22));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(23));
            log.info("Change : "+Timeframes.allGraphElementsList.get(23));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(24));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(24));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(25));
            log.info("MA10 : "+Timeframes.allGraphElementsList.get(25));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(26));
            log.info("MA30 : "+Timeframes.allGraphElementsList.get(26));
        }

        @Test
        @DisplayName("Test of 30 minutes timeframe values")
        @Order(4)
        void checkThirtyMinuteTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, THIRTY_MIN_TF);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(27));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(27));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(28));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(28));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(29));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(29));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(30));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(30));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(31));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(31));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(32));
            log.info("Change : "+Timeframes.allGraphElementsList.get(32));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(33));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(33));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(34));
            log.info("MA10 : "+Timeframes.allGraphElementsList.get(34));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(35));
            log.info("MA30 : "+Timeframes.allGraphElementsList.get(35));
        }

        @Test
        @DisplayName("Test of 60 minutes timeframe values")
        @Order(5)
        void checkSixtyMinuteTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, SIXTY_MIN_TF);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(36));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(36));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(37));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(37));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(38));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(38));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(39));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(39));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(40));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(40));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(41));
            log.info("Change : "+Timeframes.allGraphElementsList.get(41));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(42));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(42));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(43));
            log.info("MA10 : "+Timeframes.allGraphElementsList.get(43));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(44));
            log.info("MA30 : "+Timeframes.allGraphElementsList.get(44));
        }

        @Test
        @DisplayName("Test of 4 hours timeframe values")
        @Order(6)
        void checkFourHoursTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, FOUR_HOUR_TF);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(45));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(45));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(46));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(46));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(47));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(47));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(48));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(48));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(49));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(49));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(50));
            log.info("Change : "+Timeframes.allGraphElementsList.get(50));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(51));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(51));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(52));
            log.info("MA10 : "+Timeframes.allGraphElementsList.get(52));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(53));
            log.info("MA30 : "+Timeframes.allGraphElementsList.get(53));
        }

        @Test
        @DisplayName("Test of 1 day timeframe values")
        @Order(7)
        void checkOneDayTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, ONE_DAY_TF);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(54));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(54));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(55));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(55));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(56));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(56));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(57));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(57));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(58));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(58));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(59));
            log.info("Change : "+Timeframes.allGraphElementsList.get(59));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(60));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(60));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(61));
            log.info("MA10 : "+Timeframes.allGraphElementsList.get(61));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(62));
            log.info("MA30 : "+Timeframes.allGraphElementsList.get(62));
        }

        @Test
        @DisplayName("Test of 1 week timeframe values")
        @Order(8)
        void checkOneWeekTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, ONE_WEEK_TF);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(63));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(63));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(64));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(64));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(65));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(65));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(66));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(66));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(67));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(67));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(68));
            log.info("Change : "+Timeframes.allGraphElementsList.get(68));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(69));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(69));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(70));
            log.info("MA10 : "+Timeframes.allGraphElementsList.get(70));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(71));
            log.info("MA30 : "+Timeframes.allGraphElementsList.get(71));
        }

        @Test
        @DisplayName("Test of 1 month timeframe values")
        @Order(9)
        void checkOneMonthTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, ONE_MONTH_TF);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(72));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(72));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(73));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(73));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(74));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(74));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(75));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(75));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(76));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(76));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(77));
            log.info("Change : "+Timeframes.allGraphElementsList.get(77));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(78));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(78));

//            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(79));
//            log.info("MA10 : "+Timeframes.allGraphElementsList.get(79));
//
//            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(80));
//            log.info("MA30 : "+Timeframes.allGraphElementsList.get(80));
        }

        @Test
        @DisplayName("Test of full screen timeframe values")
        @Order(10)
        void checkFullScreenTF() throws Exception {
            Timeframes.timeframeExecutor(driverChrome, FULL_SCREEN_GRAPH);

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(81));
            log.info("Active Timeframe : "+Timeframes.allGraphElementsList.get(81));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(82));
            log.info("Open Price : "+Timeframes.allGraphElementsList.get(82));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(83));
            log.info("High Price : "+Timeframes.allGraphElementsList.get(83));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(84));
            log.info("Low Price : "+Timeframes.allGraphElementsList.get(84));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(85));
            log.info("Close Price : "+Timeframes.allGraphElementsList.get(85));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(86));
            log.info("Change : "+Timeframes.allGraphElementsList.get(86));

            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(87));
            log.info("MA5 : "+Timeframes.allGraphElementsList.get(87));

//            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(88));
//            log.info("MA10 : "+Timeframes.allGraphElementsList.get(88));
//
//            assertNotEquals("n/a", Timeframes.allGraphElementsList.get(89));
//            log.info("MA30 : "+Timeframes.allGraphElementsList.get(89));
        }

        @AfterEach
        @DisplayName("Wait for 2 seconds")
        void afterEach() throws InterruptedException {
            Thread.sleep(2000);
        }
    }


}