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


}