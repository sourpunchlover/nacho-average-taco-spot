package com.pluralsight;

import java.util.ArrayList;

public class Order {
    private ArrayList<Taco> tacos;
    private ArrayList<Drink> drinks;
    private ArrayList<ChipsAndSalsa> chips;

    //constructor
    public Order() {// no parameters b/c order is starting from 0
        this.tacos = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }
    public double getTotal () {
        return tacos.stream()
                .mapToDouble(taco-> taco.getPrice())
                .sum() +
        drinks.stream()
                .mapToDouble(drink-> drink.getPrice())
                .sum() +
        chips.stream()
                .mapToDouble(chips-> chips.getPrice())
                .sum();
    }
    public String getOrderSummary () {
        String summary = "";
        for(Taco t: tacos) {
            summary += t.toString() + "\n";
        }
        for(Drink d: drinks) {
            summary += d.toString() + "\n";
        }
        for(ChipsAndSalsa c: chips) {
            summary += c.toString() + "\n";
        }
        summary += "Total: $" + String.format("%.2f", getTotal());
        return summary;
    }
    public void addTaco (Taco taco){
        this.tacos.add(taco);
    }
    public void addDrink (Drink drink){
        this.drinks.add(drink);
    }
    public void addChips (ChipsAndSalsa chips){
        this.chips.add(chips);
    }

}
