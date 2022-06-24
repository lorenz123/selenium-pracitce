package com.bibvip.futures;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
public class MarketBlockTest {

    Field[] allFields = MarketBlock.class.getDeclaredFields();

    @Test
    @DisplayName("Test of Market Block Displayed")
    void testMarketBlockDisplayed() throws IllegalAccessException {
        Field isMarketBlockDisplayed = allFields[1];
        Object isMarketBlockDisplayedStr = isMarketBlockDisplayed.get(String.class);
        assertEquals(true, isMarketBlockDisplayedStr);
        log.info("Market Block Displayed is: "+isMarketBlockDisplayedStr);
    }

    @Test
    @DisplayName("Test of Market Block Dismissed")
    void testMarketBlockDismissed() throws IllegalAccessException {
        Field isMarketBlockDismissed = allFields[2];
        Object isMarketBlockDismissedStr = isMarketBlockDismissed.get(String.class);
        assertEquals(false, isMarketBlockDismissedStr);
        log.info("Market Block Displayed is: "+isMarketBlockDismissedStr);
    }
}