package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order order = new Order();

    public void displayHomeScreen() {

        while (true) {
            System.out.println("Select an Option: ");
            System.out.println("\t1) New Order");
            System.out.println("\t0) Exit");
            String userOption = scanner.nextLine();

            if (userOption.equals("1")) {
                displayOrderScreen();
            } else if (userOption.equals("0")) {
                break;
            } else {
                System.out.println("Invalid option, please try again.");
            }

        }

    }
    public void displayOrderScreen() {
        //All entries should show the newest entries first
        while (true) {
            System.out.println("Select an Option: ");
            System.out.println("\t1) Add Taco");
            System.out.println("\t2) Add Drink");
            System.out.println("\t3) Add Chips  & Salsa");
            System.out.println("\t4) Checkout");
            System.out.println("\t0) Cancel Order");
            System.out.println("Enter your selection: ");
            String userOption = scanner.nextLine();

            switch (userOption) {
                case "1":
                    //addTaco();
                    break;
                case "2":
                    //addDrink
                    break;
                case "3":
                    //addChips();
                    break;
                case "4":
                    //displayCheckoutScreen();
                    break;
                case "0":
                    //cancelOrder();
                    order = new Order();
                    break;
                default:
                    System.out.println("Invalid option entered. Try again.");
                    System.out.println("\n");
            }
        }

    }
    public void displayAddTacoScreen() {
        System.out.println("Select shell type: ");
        System.out.println("\t1) Corn");
        System.out.println("\t2) Flour");
        System.out.println("\t3) Hard Shell");
        System.out.println("\t4) Bowl");
        System.out.println("Enter your selection: ");
        String shellChoice = scanner.nextLine();

        String shell = "";
        switch (shellChoice) {
            case "1":
                shell = "Corn";
                break;
            case "2":
                shell = "Flour";
                break;
            case "3":
                shell = "Hard Shell";
                break;
            case "4":
                shell = "Bowl";
                break;
            default: System.out.println("Invalid option entered. Try again.");
                System.out.println("\n");
        }
    }
    private String selectShell() {
        System.out.println("Select shell type: ");
        System.out.println("\t1) Corn");
        System.out.println("\t2) Flour");
        System.out.println("\t3) Hard Shell");
        System.out.println("\t4) Bowl");
        System.out.println("Enter your selection: ");
        String shellChoice = scanner.nextLine();

        switch (shellChoice) {
            case "1":
                return "Corn";
            case "2":
               return "Flour";
            case "3":
                return "Hard Shell";
            case "4":
                return "Bowl";
            default: System.out.println("Invalid option entered. Try again.");
                System.out.println("\n");
        } return "";
    }
    private String selectSize() {
        System.out.println("Select size: ");
        System.out.println("\t1) Single");
        System.out.println("\t2) 3 Taco Plate");
        System.out.println("\t3) Burrito");
        System.out.println("Enter your selection: ");
        String size = scanner.nextLine();

        switch (size) {
            case "1":
                return "Single";
            case "2":
                return "3 Taco Plate";
            case "3":
                return "Burrito";
            default: System.out.println("Invalid option entered. Try again.");
                System.out.println("\n");
        } return "";
    }
    public void displayAddDrinkScreen() {}
    public void displayAddChipsAndSalsaScreen() {}
    public void displayCheckoutScreen


}