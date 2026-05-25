package com.pluralsight;

public abstract class Topping {
    protected String name;
    protected boolean isExtra;

    //constructor
    public Topping(String name) {
        this.name = name;
        this.isExtra = false;
    }
    public abstract double getPrice(String size);

    public String getName() {
        return name;
    }
}
