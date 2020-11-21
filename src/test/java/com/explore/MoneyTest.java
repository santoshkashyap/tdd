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

    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augmend);
        assertEquals(five, sum.addmend);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("INR", "USD", 70);
        Money result = bank.reduce(Money.rupee(140), "USD");
        assertEquals(Money.dollar(2), result);
    }

    @Test
    void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
        assertEquals(1, new Bank().rate("INR", "INR"));
    }

    @Test
    void testAdditionMixedCurrencies() {
        Expression usd = Money.dollar(5);
        Expression inr = Money.rupee(140);
        Bank bank = new Bank();
        bank.addRate("INR", "USD", 70);
        Money result = bank.reduce(usd.plus(inr), "USD");
        assertEquals(Money.dollar(7), result);

    }

    @Test
    void testSumPlusMoney() {
        Expression usd = Money.dollar(5);
        Expression inr = Money.rupee(140);
        Bank bank = new Bank();
        bank.addRate("INR", "USD", 70);
        Expression sum = new Sum(usd, inr).plus(usd);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(12), result);
    }

    @Test
    void testSumTimes() {
        Expression usd = Money.dollar(5);
        Expression inr = Money.rupee(140);
        Bank bank = new Bank();
        bank.addRate("INR", "USD", 70);
        Expression sum = new Sum(usd, inr).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(14), result);
    }

}
