package com.pluralsight.finance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    // class attributes
    private Portfolio portfolio;
    private final Scanner scanner = new Scanner(System.in);
    private final int colWidth = 15;

    // constructor
    public UserInterface() {
    }

    // init method
    private void init() {
        this.portfolio = new Portfolio("Vacation fund", "Pam and Gary");

        BankAccount account1 = new BankAccount("Pam", "123", 12500);
        Valuable account2 = new BankAccount("Gary", "456", 1500);
        BankAccount account3 = new BankAccount("Gary", "789", 1500);

        portfolio.add(account1);
        portfolio.add(account2);
        portfolio.add(account3);
    }

    // this method displays the main menu manages operations based on input
    public void mainMenu() {

        init();

        String message = """
                ==== Portfolio Manager ===
                1. View assets
                2. View Portfolio value
                3. View most valuable asset
                4. View least valuable asset
                5. Add asset to portfolio
                6. Remove asset from portfolio
                0. Exit
                Enter a command:\s""";

        boolean menuRunning = true;

        while (menuRunning) {

            int command = getAInteger(message);

            switch (command) {
                case 1:
                    processGetAssets();
                    break;
                case 2:
                    processGetValue();
                    break;
                case 3:
                    // processMaxValue();
                    break;
                case 4:
                    break;
                case 5:
                    processAddAsset();
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Exiting application. Goodbye!");
                    menuRunning = false;
                    break;
                default:
                    System.out.println("Invalid command: \"" + command + "\"");
            }

        }

    }

    // this method returns all assets
    public void processGetAssets() {

        displayAssets( this.portfolio.getAssets() );

    }

    // this method prints the total value of the portfolio
    public void processGetValue() {

        System.out.println("Total value: " + portfolio.getValue());

    }

    // this method gets the highest value asset


    // this method prompts users to add new assets to their portfolio
    public void processAddAsset() {

        int type = getAInteger("=== Asset Types ===" +
                "\n1 - Bank Account" +
                "\n2 - Credit Card" +
                "\n3 - Gold" +
                "\n4 - Jewelry" +
                "\n5 - House" +
                "\n - Select an Asset Type: ");

        switch (type) {
            case 1:
                portfolio.add(new BankAccount(getAString("Enter the name for the account: "),
                        getAString("Enter the account number: "),
                        getADouble("Enter initial deposit amount: ")));
                break;
            case 2:
                portfolio.add(new CreditCard(getAString("Enter the name for the account: "),
                        getAString("Enter the account number: "),
                        getADouble("Enter initial deposit amount: ")));
                break;
            case 3:
                portfolio.add(new Gold(getADouble("Enter the market value of the gold: "),
                        getADouble("Enter the weight: ")));
                break;
            case 4:
                portfolio.add(new Jewelry(getADouble("Enter the market value: "),
                        getADouble("Enter the karat")));
                break;
            case 5:
                portfolio.add(new House(getADouble("Enter the market value: "),
                        getAInteger("Enter the year the house was built: "),
                        getAInteger("Enter the square feet: "),
                        getAInteger("Enter the amount of rooms: ") ));
                break;
            default:
                System.out.println("Invalid input");
                processAddAsset();
        }
    }

    // HELPER METHODS

    public void displayAssets(List<Valuable> assets) {

        // create a list for each type of asset
        List<BankAccount> bankAccountList = new ArrayList<>();
        List<CreditCard> creditCardList = new ArrayList<>();
        List<Jewelry> jewelryList = new ArrayList<>();
        List<Gold> goldList = new ArrayList<>();
        List<House> houseList = new ArrayList<>();

        // split the list into different types
        for (Valuable v: assets) {
            if (v instanceof BankAccount b) {
                bankAccountList.add(b);
            }

            if (v instanceof CreditCard c) {
                creditCardList.add(c);
            }

            if (v instanceof Jewelry j) {
                jewelryList.add(j);
            }

            if (v instanceof Gold g) {
                goldList.add(g);
            }

            if (v instanceof House h) {
                houseList.add(h);
            }

        }

        String bankAccounts = "";

        Collections.sort(bankAccountList);

        for (BankAccount b: bankAccountList) {
           bankAccounts += String.format("|%s|%s|%s|\n", center(b.getName(), colWidth),
                   center(b.getAccountNumber(), colWidth),
                   center(b.getValue(), colWidth ) );
        }
        System.out.printf("================= %s's =================\n|%s|%s|%s|\n", bankAccountList.get(0).getTYPE(),
                center("Name", colWidth),
                center("Account Number", colWidth),
                center("Balance", colWidth));

        System.out.println(bankAccounts);
    }

    // methods for getting parsing user input
    private double getADouble(String message) {
        double price;
        // get a valid price
        while (true) {
            try {
                System.out.print(message);
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Only numbers allowed");
            }
        }
        return price;
    }

    private int getAInteger(String message) {
        int odometer;
        while (true) {
            try {
                System.out.print(message);
                odometer = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Only numbers allowed");
            }
        }
        return odometer;
    }

    private String getAString(String message) {

        String output;

        // get a valid model
        while (true) {

            System.out.print(message);
            output = scanner.nextLine().trim();

            if (output.matches("[0-9]+")) {
                System.out.println("No numbers allowed.");
                continue;
            }
            if (output.isBlank()) {
                System.out.println("Cannot be empty.");
                continue;
            }
            break;
        }
        return output;
    }

    // this method returns a centered input string
    private static String center(String text, int width) {
        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        int padStart = padding / 2;
        int padEnd = padding - padStart;
        return " ".repeat(padStart) + text + " ".repeat(padEnd);
    }

    private static String center(int input, int width) {
        String text = String.valueOf(input);
        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        int padStart = padding / 2;
        int padEnd = padding - padStart;
        return " ".repeat(padStart) + text + " ".repeat(padEnd);
    }

    private static String center(double input, int width) {

        String text = String.valueOf(input);

        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        int padStart = padding / 2;
        int padEnd = padding - padStart;
        return " ".repeat(padStart) + text + " ".repeat(padEnd);
    }

}
