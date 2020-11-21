package com.explore;

public class Money {

    protected int amount = 0;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


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
        return this.amount == money.amount && this.currency.equals(money.currency);
    }

    public Money times(int value) {
        return new Money(this.amount * value, this.currency);
    }

    @Override
    public String toString() {
        return "Money{" +
            "amount=" + amount +
            ", currency='" + currency + '\'' +
            '}';
    }
}
