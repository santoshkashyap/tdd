package com.explore;

public class Money implements Expression {

    protected int amount;
    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    public String currency() {
        return this.currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money rupee(int amount) {
        return new Money(amount, "INR");
    }

    @Override
    public Expression plus(Expression newMoney) {
        return new Sum(this, newMoney);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount && this.currency.equals(money.currency);
    }

    @Override
    public Expression times(int value) {
        return new Money(this.amount * value, this.currency);
    }

    @Override
    public String toString() {
        return "Money{" +
            "amount=" + amount +
            ", currency='" + currency + '\'' +
            '}';
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(this.amount / bank.rate(this.currency, to), to);
    }
}
