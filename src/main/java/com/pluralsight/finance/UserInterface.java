package com.pluralsight.finance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    // class attributes
    private Portfolio portfolio;
    private final Scanner scanner = new Scanner(System.in);

    // constructor
    public UserInterface() {
    }

    // init method
    private void init() {
        this.portfolio =new Portfolio("Vacation fund", "Pam and Gary");

        BankAccount account1 = new BankAccount("Pam", "123", 12500);
        Valuable account2 = new BankAccount("Gary", "456", 1500);

        portfolio.add(account1);
        portfolio.add(account2);
    }

    // this method displays the main menu manages operations based on input
    public void mainMenu() {

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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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

    public void processGetAssets() {

        this.portfolio.getAssets();

    }

    // HELPER METHODS

    public void displayAssets(List<Valuable> assets) {

        // create a list for each type of asset
        List<BankAccount> bankAccountList = new ArrayList<>();
        List<CreditCard> creditCardList = new ArrayList<>();
        List<Jewelry> jewelryList = new ArrayList<>();
        List<Gold> goldList = new ArrayList<>();
        List<House> houseList = new ArrayList<>();

        for (Valuable v: assets) {
            if (v instanceof BankAccount b) {
                bankAccountList.add(b);
            }

        }

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
