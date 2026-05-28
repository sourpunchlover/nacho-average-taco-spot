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
        String drinkOrder = "Size: " + size + "\n" + "Flavor: " + flavor + "\n";
        return drinkOrder;

    }
}
