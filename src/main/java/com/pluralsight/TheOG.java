package com.pluralsight;

public class TheOG extends Taco implements SignatureItem{

    public TheOG() {
        super("Single", "Corn");
        addTopping(new PremiumTopping("Carne Asada", 1.00, 2.00, 3.00));
        addTopping(new PremiumTopping("Oaxaca",0.75, 1.50, 2.25));
        addTopping(new RegularTopping("Pico de gallo"));
        addTopping(new RegularTopping("Cilantro"));
        addTopping(new RegularTopping("Radishes"));
        addTopping(new RegularTopping("Chipotle"));

    }

    @Override
    public String getDescription() {
        return "Simple, classic, no notes.";
    }

    @Override
    public String toString() {
        return "Signature Taco: The OG\n" + super.toString();
    }
}
