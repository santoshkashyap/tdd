package com.explore;

public class Franc {


    private int amount = 0;

    public Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int value) {
        return new Franc(this.amount * value);
    }

    @Override
    public boolean equals(Object obj) {
        Franc franc = (Franc) obj;
        return this.amount == franc.amount;
    }
}
