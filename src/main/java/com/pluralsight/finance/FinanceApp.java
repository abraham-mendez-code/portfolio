package com.pluralsight.finance;

public class FinanceApp {

    public static void main(String[] args) {

        /*

        BankAccount account1 = new BankAccount("Pam", "123", 12500);
        Valuable account2 = new BankAccount("Gary", "456", 1500);

       // account1.deposit(100);
       // account2.deposit(100);

        Portfolio portfolio = new Portfolio("College Fund", "Gary and Pam");

        portfolio.add(account1);
        portfolio.add(account2);

        System.out.println(portfolio.getValue());

        System.out.println(portfolio.getMostValuable().getValue());

        System.out.println(portfolio.getLeastValuable().getValue());

        */

        UserInterface ui = new UserInterface();

        ui.mainMenu();

    }
}
