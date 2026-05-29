package com.pluralsight;

public class PremiumTopping extends Topping {
    private double singlePrice, platePrice, burritoPrice;

    //constructor
    public PremiumTopping(String name, double singlePrice, double platePrice, double burritoPrice) {
        super(name);
        this.singlePrice = singlePrice;
        this.platePrice = platePrice;
        this.burritoPrice = burritoPrice;
    }

    @Override
    public double getPrice(String size) {

        switch (size) {
            case "Single":
                return singlePrice;
            case "3 Taco Plate":
                return platePrice;
            case "Burrito":
                return burritoPrice;
            default:
                System.out.println("Invalid option");
                return 0;
        }

    }

    public String toString(String size) {
        String topping = "Name: " + name + "\n" + "Extra: " + isExtra + "\n" + "Price: $" + String.format("%.2f", getPrice(size));
        return topping;
    }
}
