package com.explore;

public interface Expression {

    Money reduce(Bank bank, String to);

    Expression plus(Expression newMoney);
}
