package com.pluralsight;

public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }

    public String toString(String size) {
        String topping = "Name: " + name + "\n" + "Price: " + getPrice(size);
        return topping;
    }

}
