package com.pluralsight.finance;

public class CreditCard implements Valuable{

    // class attributes
    private String name;
    private String accountNumber;
    private double balance;

    // constructor
    public CreditCard(String name, String accountNumber, double balance) {

        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    public void charge(double amount) {

        // get the absolute value of amount
        amount = Math.abs(amount);

        // add the charge to the balance
        balance += amount;

    }

    public void pay(double amount) {

        // get the absolute value of amount
        amount = Math.abs(amount);

        // subtract the payment from the balance if there is sufficient debt to pay
        balance -= (balance - amount >= 0? amount:0);
    }

    // override
    @Override
    public double getValue() {

        return balance;
    }
}
