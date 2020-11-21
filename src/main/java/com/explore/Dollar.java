package com.explore;

public class Dollar extends Money {


    public Dollar(int amount, String currency) {
        super(amount, currency);
    }


    public Money times(int value) {
        return Money.dollar(this.amount * value);
    }


}
