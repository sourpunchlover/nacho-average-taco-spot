package com.pluralsight;

public class TheBajaBabe extends Taco {

    public TheBajaBabe() {
        super("Single", "Flour");
        addTopping(new PremiumTopping("Pescado", 1.00, 2.00, 3.00));
        addTopping(new PremiumTopping("Queso Fresco",0.75, 1.50, 2.25));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Jalapeños"));
        addTopping(new RegularTopping("Mango Heat"));
    }


    public String getDescription() {
        return "Sweet heat meets fresh fish.";
    }

    @Override
    public String toString() {
        return "Signature Taco: The Baja Babe\n" + super.toString();
    }
}
