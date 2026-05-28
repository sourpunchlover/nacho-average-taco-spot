package com.pluralsight;

public class ChipsAndSalsa implements MenuItem {
    private String salsaType;

    //constructor
    public ChipsAndSalsa(String salsaType) {
        this.salsaType = salsaType;
    }

    public double getPrice() {
        return 1.50;
    }

    public String toString() {
        String addChips = "Salsa Type: " + salsaType + "\n";
        return addChips;

    }
}
