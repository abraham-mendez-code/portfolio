package com.pluralsight.finance;

public class BankAccount implements Valuable, Comparable<BankAccount>{

    // class attributes
    private final String TYPE = "Bank Account";
    private String name;
    private String accountNumber;
    private double balance;

    // constructor
    public BankAccount (String name, String accountNumber, double balance) {

        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    // getter methods
    public String getTYPE() {
        return TYPE;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
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

    @Override
    public int compareTo(BankAccount b) {

        // compare by name
        int name = this.getName().compareTo(b.getName());

        // compare by balance
        int balance = Double.compare(this.balance, b.balance);

        // compare by account number
        int accountNumber = this.getAccountNumber().compareTo(b.getAccountNumber());

        return name == 0 ? (balance == 0 ? accountNumber : balance) : name;
    }
}
