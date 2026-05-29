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
        summary += "****************************************\n";
        summary += "      NACHO AVERAGE TACO SPOT\n";
        summary += "    1111 Taco Blvd, Marietta, GA\n";
        summary += "         Phone: 678-000-0000\n";
        summary += "****************************************\n";

        if (!tacos.isEmpty()){
            summary += "-------------- TACOS ------------------\n";
            for (int i = tacos.size() - 1; i >= 0; i--) {
                summary += tacos.get(i).toString() + "\n";
            }
        }

        if (!drinks.isEmpty()) {
            summary += "-------------- DRINKS ------------------\n";
            for (int i = drinks.size() - 1; i >= 0; i--) {
                summary += drinks.get(i).toString() + "\n";
            }
        }

        if (!chips.isEmpty()) {
            summary += "-------------- CHIPS & SALSA ------------------\n";
            for (int i = chips.size() - 1; i >= 0; i--) {
                summary += chips.get(i).toString() + "\n";
            }
        }

        summary += "****************************************\n";
        summary += "            Total: $" + String.format("%.2f", getTotal()) + "\n";
        summary += "****************************************\n";
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

    public boolean isValid() {
        return tacos.size() > 0 || drinks.size() > 0 || chips.size() > 0;
    }


}
