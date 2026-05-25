package com.pluralsight;

public class Drink {
    private String size;

    //constructor

    public Drink(String size) {
        this.size = size;
    }

    public double getPrice() {
        double drinkPrice = 0;
        switch (size) {
            case "small":
                drinkPrice = 2.00;
                break;
            case "medium":
                drinkPrice = 2.50;
                break;
            case "large":
                drinkPrice = 3.00;
                break;
            default:
                System.out.println("Invalid option");
        }
        return drinkPrice;
    }

    public String toString() {
        String drinkOrder = "Size: " + size + "\n";
        return drinkOrder;

    }
}
