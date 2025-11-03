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
        // deposit logic here
    }

    public void withdraw(double amount) {
        // withdrawal logic here
    }

    // override
    @Override
    public double getValue() {

        return 0;
    }
}
