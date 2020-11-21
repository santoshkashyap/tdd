package com.explore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplicationDollar() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testEqualityDollar() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(10));
    }

    @Test
    void testMultiplicationRupee() {
        Money five = Money.rupee(5);
        assertEquals(Money.rupee(10), five.times(2));
        assertEquals(Money.rupee(15), five.times(3));
    }

    @Test
    void testEqualityRupee() {
        assertEquals(Money.rupee(5), Money.rupee(5));
        assertNotEquals(Money.rupee(5), Money.rupee(10));
    }

    @Test
    void testInEquality() {
        assertNotEquals(Money.dollar(5), Money.rupee(5));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(5).currency());
        assertEquals("INR", Money.rupee(5).currency());
    }
}
