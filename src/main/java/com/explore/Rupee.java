package com.explore;

public class Rupee extends Money {

    public Rupee(int amount, String currency) {
        super(amount, currency);
    }

    public Money times(int value) {
        return Money.rupee(this.amount * value);
    }

}
