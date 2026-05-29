package com.pluralsight;

public class TheHeavyweight extends Taco {

    public TheHeavyweight() {
        super("Burrito", "Flour");
        addTopping(new PremiumTopping("Carne Asada",1.00, 2.00, 3.00 ));
        addTopping(new PremiumTopping("Chorizo", 1.00, 2.00, 3.00));
        addTopping(new PremiumTopping("Cheddar", 0.75, 1.50, 2.25));
        addTopping(new PremiumTopping("Oaxaca", 0.75,1.50,2.25));
        addTopping(new RegularTopping("Guacamole"));
        addTopping(new RegularTopping("Onions"));
        addTopping(new RegularTopping("Cilantro"));
        addTopping(new RegularTopping("Jalapeños"));
        addTopping(new RegularTopping("Extra Hot"));
    }


    public String getDescription() {
        return "TKO guaranteed after the first bite.";
    }

    @Override
    public String toString() {
        return "Signature Taco: The Heavyweight\n" + super.toString();
    }
}
