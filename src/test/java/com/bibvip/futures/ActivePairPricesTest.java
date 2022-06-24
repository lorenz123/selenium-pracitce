package com.bibvip.futures;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActivePairPricesTest {

    Field[] allFields = ActivePairPrices.class.getDeclaredFields();

    @BeforeAll
    @DisplayName("Run Selenium Automation on Futures Left Pane - Before Unit Test")
    void testRunSelenium() throws InterruptedException {
        ExecuteFutures.performFutures();
    }

    @Test
    @DisplayName("Test of Active Pair")
    @Order(1)
    void testActivePair() throws IllegalAccessException {
        Field activePair = allFields[1];
        Object activePairStr = activePair.get(String.class);
        assertEquals("BTCUSDT", activePairStr);
        log.info("active pair is: "+activePairStr);
    }

    @Test
    @DisplayName("Test of Active Pair Price")
    @Order (2)
    void testActivePairPrice() throws IllegalAccessException {
        Field activePairPrice = allFields[2];
        Object activePairPriceStr = activePairPrice.get(String.class);
        assertNotEquals("--", activePairPriceStr);
        log.info("active pair price is: "+activePairPriceStr);
    }

    @Test
    @DisplayName("Test of Active Pair Change")
    @Order (3)
    void testActivePairChange() throws IllegalAccessException {
        Field activePairChange = allFields[3];
        Object activePairChangeStr = activePairChange.get(String.class);
        assertNotEquals("--", activePairChangeStr);
        log.info("active pair change is: "+activePairChangeStr);
    }

    @Test
    @DisplayName("Test of Active Pair Price if Changing after 15s")
    @Order (4)
    void testSecondActivePairPrice() throws IllegalAccessException {
        Field activePairPrice = allFields[2];
        Object activePairPriceStr = activePairPrice.get(String.class);

        Field secondActivePairPrice = allFields[4];
        Object secondActivePairPriceStr = secondActivePairPrice.get(String.class);
        assertNotEquals(activePairPriceStr, secondActivePairPriceStr);
        log.info("first pair price: "+activePairPriceStr+" | second = "+secondActivePairPriceStr);
    }

    @Test
    @DisplayName("Test of Active Pair Change if Changing after 15s")
    @Order (5)
    void testSecondActivePairChange() throws IllegalAccessException {
        Field activePairChange = allFields[3];
        Object activePairChangeStr = activePairChange.get(String.class);

        Field secondActivePairChange = allFields[5];
        Object secondActivePairChangeStr = secondActivePairChange.get(String.class);
        assertNotEquals(activePairChangeStr, secondActivePairChangeStr);
        log.info("first pair change: "+activePairChangeStr+" | second = "+secondActivePairChangeStr);
    }

    @Test
    @DisplayName("Test of Mark Price if it has value!")
    @Order (6)
    void testMarkPrice() throws IllegalAccessException {
        Field markPrice = allFields[6];
        Object markPriceStr = markPrice.get(String.class);
        assertNotEquals("--", markPriceStr);
        log.info("Mark Price value : "+markPriceStr);
    }

    @Test
    @DisplayName("Test of Index Price if it has value!")
    @Order (7)
    void testIndexPrice() throws IllegalAccessException {
        Field indexPrice = allFields[7];
        Object indexPriceStr = indexPrice.get(String.class);
        assertNotEquals("--", indexPriceStr);
        log.info("Index Price value : "+indexPriceStr);
    }

    @Test
    @DisplayName("Test of Funding Rate if it has value!")
    @Order (8)
    void testFundingRate() throws IllegalAccessException {
        Field fundingRate = allFields[8];
        Object fundingRateStr = fundingRate.get(String.class);
        assertNotEquals("--% /", fundingRateStr);
        log.info("Funding Rate value : "+fundingRateStr);
    }

    @Test
    @DisplayName("Test of Est. Next Rate if it has value!")
    @Order (9)
    void testEstNextRate() throws IllegalAccessException {
        Field estNextRate = allFields[9];
        Object estNextRateStr = estNextRate.get(String.class);
        assertNotEquals("--%", estNextRateStr);
        log.info("Est. Next Rate value : "+estNextRateStr);
    }

    @Test
    @DisplayName("Test of 24h Volume if it has value!")
    @Order (10)
    void testCont() throws IllegalAccessException {
        Field cont = allFields[10];
        Object contStr = cont.get(String.class);
        assertNotEquals("-- Cont.", contStr);
        log.info("24h Volume value : "+contStr);
    }


}