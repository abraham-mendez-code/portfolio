package com.pluralsight.finance;

public class CreditCard implements Valuable, Comparable<CreditCard>{

    // class attributes
    private final String TYPE = "Credit Card";
    private String name;
    private String accountNumber;
    private double balance;

    // constructor
    public CreditCard(String name, String accountNumber, double balance) {

        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

    // getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getTYPE() {
        return TYPE;
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

        return -balance;
    }

    @Override
    public int compareTo(CreditCard c) {

        // this compares by name
        int name = this.getName().compareTo(c.getName());

        // this compares by absolute value of balance
        int balance = Double.compare(Math.abs(this.getValue()), Math.abs(c.getValue()) );

        // this compares by account number
        int accountNumber = this.getAccountNumber().compareTo(c.getAccountNumber());

        // automatically adjust comparison if values match
        return name == 0 ? (balance == 0 ?  accountNumber : balance): name;

    }
}
