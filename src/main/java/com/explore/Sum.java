package com.explore;

public class Sum implements Expression {

    final Expression augmend;
    final Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augmend.reduce(bank, to).amount + addmend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression newMoney) {
        return new Sum(this, newMoney);
    }

    @Override
    public Expression times(int value) {
        return new Sum(augmend.times(value), addmend.times(value));
    }

}
