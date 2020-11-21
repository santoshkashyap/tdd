package com.explore;

public class Franc extends Money {


    public Franc(int amount) {
        this.amount = amount;
    }

    Money times(int value) {
        return new Franc(this.amount * value);
    }

}
