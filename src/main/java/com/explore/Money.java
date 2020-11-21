package com.explore;

public abstract class Money {

    protected int amount = 0;

    public abstract Money times(int value);

    public static Money dollar(int amount) {
        return new Dollar(amount);
    }

    public static Money franc(int amount) {
        return new Franc(amount);
    }


    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.getClass().equals(obj.getClass())
            && this.amount == money.amount;
    }


}
