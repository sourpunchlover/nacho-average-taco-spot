package com.pluralsight;

public class Drink implements MenuItem {
    private String size, flavor;

    //constructor

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public double getPrice() {
        double drinkPrice = 0;
        switch (size) {
            case "Small":
                drinkPrice = 2.00;
                break;
            case "Medium":
                drinkPrice = 2.50;
                break;
            case "Large":
                drinkPrice = 3.00;
                break;
            default:
                System.out.println("Invalid drink option");
        }
        return drinkPrice;
    }

    public String toString() {
        String drinkOrder = "Size: " + size + "\n" + "Flavor: " + flavor + "\n" + "Price: $" + String.format("%.2f", getPrice()) + "\n";
        return drinkOrder;

    }
}
