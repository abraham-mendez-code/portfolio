package com.pluralsight.finance;

public class BankAccount implements Valuable{

    // class attributes
    private String name;
    private String accountNumber;
    private double balance;

    // constructor
    public BankAccount (String name, String accountNumber, double balance) {

        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    public void deposit(double amount) {

        // get the absolute value of amount
        amount = Math.abs(amount);

        // add amount to the balance
        balance += amount;
    }

    public void withdraw(double amount) {

        // get the absolute value of amount
        amount = Math.abs(amount);

        // only withdraw if balance has sufficient amount
        balance -= (balance - amount >= 0? amount: 0);
    }

    // override
    @Override
    public double getValue() {

        return balance;
    }
}
