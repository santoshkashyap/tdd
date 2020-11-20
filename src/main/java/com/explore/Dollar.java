package com.explore;

public class Dollar {


    int amount = 0;

    public Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int value) {
        return new Dollar(this.amount * value);
    }


}
