package com.explore;

public class Money {

    protected int amount = 0;

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.getClass().equals(obj.getClass())
            && this.amount == money.amount;
    }


}
