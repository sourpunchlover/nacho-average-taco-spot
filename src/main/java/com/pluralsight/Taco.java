package com.pluralsight;

import java.util.ArrayList;

public class Taco {
    private String size, shell;
    private boolean isCovered;
    private ArrayList<Topping> toppings;

    //constructor
    public Taco(String size, String shell) {
        this.size = size;
        this.shell = shell;
        this.isCovered = false;
        this.toppings = new ArrayList<>();
    }

    //methods
    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public boolean isCovered() {
        return this.isCovered;
    }

    public void setCovered() {
        this.isCovered = true;
    }

    public double getPrice() {
        double startPrice = 0;
        switch (size) {
            case "single":
                startPrice = 3.50;
                break;
            case "3 taco plate":
                startPrice = 9.00;
                break;
            case "burrito":
                startPrice = 8.50;
                break;
            default:
                System.out.println("Invalid option");
        }
        startPrice += toppings.stream()
                .mapToDouble(topping->topping.getPrice(size))
                .sum();
        return startPrice;
    }
    public String toString() {
        String tacoOrder = "Size: " + size + "\n" + "Shell: " + shell + "\n" + "Covered: " + isCovered + "\n" + "Toppings: \n";
        for(Topping t: toppings) {
            tacoOrder += t.toString() + "\n";
        }
        return tacoOrder;
    }

}
