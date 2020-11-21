package com.explore;

public abstract class Money {

    protected int amount = 0;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public abstract Money times(int value);

    public String currency() {
        return this.currency;
    }

    public static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Money rupee(int amount) {
        return new Rupee(amount, "INR");
    }


    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.getClass().equals(obj.getClass())
            && this.amount == money.amount;
    }


}
