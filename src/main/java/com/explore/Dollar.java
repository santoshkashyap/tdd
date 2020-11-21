package com.explore;

public class Dollar extends Money {

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Money times(int value) {
        return new Dollar(this.amount * value);
    }


}
