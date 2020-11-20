package com.explore;

public class Dollar {


    private int amount = 0;

    public Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int value) {
        return new Dollar(this.amount * value);
    }

    @Override
    public boolean equals(Object obj) {
        Dollar dollar = (Dollar) obj;
        return this.amount == dollar.amount;
    }
}
