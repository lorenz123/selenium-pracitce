package com.bibvip.futures;

import com.bibvip.SeleniumRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LeftPanePricesTest {

    Field[] allFields = LeftPanePrices.class.getDeclaredFields();

    @BeforeAll
    @DisplayName("Run Selenium Automation on Futures Left Pane - Before Unit Test")
    void testRunSelenium() throws InterruptedException {
        ExecuteFutures.performFutures();
    }

    @Test
    @DisplayName("Test of Active Pair")
    void testActivePair() throws IllegalAccessException {
        Field activePair = allFields[1];
        Object activePairStr = activePair.get(String.class);
        assertEquals("BTCUSDT", activePairStr);
        log.info("active pair is: "+activePairStr);
    }

    @Test
    @DisplayName("Test of Active Pair Price")
    void testActivePairPrice() throws IllegalAccessException {
        Field activePairPrice = allFields[2];
        Object activePairPriceStr = activePairPrice.get(String.class);
        assertNotEquals("--", activePairPriceStr);
        log.info("active pair price is: "+activePairPriceStr);
    }

    @Test
    @DisplayName("Test of Active Pair Change")
    void testActivePairChange() throws IllegalAccessException {
        Field activePairChange = allFields[3];
        Object activePairChangeStr = activePairChange.get(String.class);
        assertNotEquals("--", activePairChangeStr);
        log.info("active pair change is: "+activePairChangeStr);
    }

    @Test
    @DisplayName("Test of Active Pair Price if Changing after 15s")
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
    void testSecondActivePairChange() throws IllegalAccessException {
        Field activePairChange = allFields[3];
        Object activePairChangeStr = activePairChange.get(String.class);

        Field secondActivePairChange = allFields[5];
        Object secondActivePairChangeStr = secondActivePairChange.get(String.class);
        assertNotEquals(activePairChangeStr, secondActivePairChangeStr);
        log.info("first pair change: "+activePairChangeStr+" | second = "+secondActivePairChangeStr);
    }



//    Field activePairPrice = allFields[2];
//    Object activePairPriceStr = activePairPrice.get(String.class);
//    assertNotEquals("--", activePairPriceStr);
//
//    Field activePairChange = allFields[3];
//    Object activePairChangeStr = activePairChange.get(String.class);
//    assertNotEquals("--%", activePairChangeStr);
//
//    Field activePairChange = allFields[3];
//    Object activePairChangeStr = activePairChange.get(String.class);
//    assertNotEquals("--%", activePairChangeStr);
//
//    Field activePairChange = allFields[3];
//    Object activePairChangeStr = activePairChange.get(String.class);
//    assertNotEquals("--%", activePairChangeStr);
//
//    Field activePairChange = allFields[3];
//    Object activePairChangeStr = activePairChange.get(String.class);
//    assertNotEquals("--%", activePairChangeStr);

}