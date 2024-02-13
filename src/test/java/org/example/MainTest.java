package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    int[] prices = {10, 15, 20};

    @Test
    void nothingIsAvailable() {
        int money = 5;
        int result = Main.countMore(prices, money);
        Assertions.assertEquals(prices.length, result);
    }

    @Test
    void everythingIsAvailable() {
        int money = 25;
        int result = Main.countMore(prices, money);
        Assertions.assertEquals(0, result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "11, 2",
            "16, 1",
            "19, 1",
    })
    public void countMore(int money, int notAvailable) {
        int result = Main.countMore(prices, money);
        Assertions.assertEquals(notAvailable, result);
    }

}