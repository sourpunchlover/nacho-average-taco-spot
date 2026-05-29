package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order order = new Order();

    public void displayHomeScreen() {

        while (true) {
            System.out.println("🌮🌯🥑🌮🌯🥑🌮🌯🥑🌮🌯🥑🌮🌯🥑🌮🌯🥑");
            System.out.println("       NACHO AVERAGE TACO SPOT");
            System.out.println("🌮🌯🥑🌮🌯🥑🌮🌯🥑🌮🌯🥑🌮🌯🥑🌮🌯🥑");
            System.out.println();
            System.out.println("Select an Option: ");
            System.out.println("\t1) New Order");
            System.out.println("\t0) Exit");
            System.out.println("Enter your selection: ");
            String userOption = scanner.nextLine();

            if (userOption.equals("1")) {
                displayOrderScreen();
            } else if (userOption.equals("0")) {
                break;
            } else {
                System.out.println("Invalid user option, please try again.");
            }

        }

    }

    public void displayOrderScreen() {
        //All entries should show the newest entries first
        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("              YOUR ORDER");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Select an Option: ");
            System.out.println("\t1) Add Taco");
            System.out.println("\t2) Add Signature Taco");
            System.out.println("\t3) Add Drink");
            System.out.println("\t4) Add Chips  & Salsa");
            System.out.println("\t5) Checkout");
            System.out.println("\t0) Cancel Order");
            System.out.println("Enter your selection: ");
            String userOption = scanner.nextLine();

            switch (userOption) {
                case "1":
                    displayAddTacoScreen();
                    break;
                case "2":
                    displayAddSignatureTacoScreen();
                    break;
                case "3":
                    displayAddDrinkScreen();
                    break;
                case "4":
                    displayAddChipsAndSalsaScreen();
                    break;
                case "5":
                    displayCheckoutScreen();
                    return;
                case "0":
                    order = new Order(); //cancels order
                    return; //exits whole method
                default:
                    System.out.println("Invalid user option entered. Try again.");
                    System.out.println("\n");
            }
        }

    }

    public void displayAddTacoScreen() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("              YOUR TACO");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        String shell = selectShell();

        String size = selectSize();

        Taco taco = new Taco(size, shell);

        selectPremiumMeatToppings(taco);

        selectPremiumCheeseToppings(taco);

        selectRegularToppings(taco);

        selectSauces(taco);

        selectSides(taco);

        selectCovered(taco);

        order.addTaco(taco);
    }

    public void displayAddSignatureTacoScreen() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("              YOUR TACO");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("Select signature taco: ");
        System.out.println("\t1) The Baja Babe");
        System.out.println("\t2) The Heavyweight");
        System.out.println("\t3) The OG");
        System.out.println("Enter your selection: ");
        String signatureOption = scanner.nextLine();

        Taco taco = null;
        switch (signatureOption) {
            case "1":
                taco = new TheBajaBabe();
                break;
            case "2":
                taco = new TheHeavyweight();
                break;
            case "3":
                taco = new TheOG();
                break;
            default:
                System.out.println("Invalid signature item option entered. Try again.");
                System.out.println("\n");
        }

        if (taco != null) {
            System.out.println(taco.toString());
            System.out.println("Would you like to remove any toppings? (yes/no)");
            String removeOption = scanner.nextLine();

            if (removeOption.equalsIgnoreCase("yes")) {
                while (true) {
                    System.out.println("Enter topping name to remove (or 'done' to finish): ");
                    String toppingName = scanner.nextLine();
                    if (toppingName.equalsIgnoreCase("done")) {
                        break;
                    }
                    taco.removeTopping(toppingName);
                    System.out.println(taco.toString());
                }
            }

            selectPremiumMeatToppings(taco);
            selectPremiumCheeseToppings(taco);
            selectRegularToppings(taco);
            selectSauces(taco);
            selectSides(taco);
            selectCovered(taco);

            order.addTaco(taco);
        }

    }

    private String selectShell() {
        System.out.println("Select shell type: ");
        System.out.println("\t1) Corn");
        System.out.println("\t2) Flour");
        System.out.println("\t3) Hard Shell");
        System.out.println("\t4) Bowl");
        System.out.println("Enter your selection: ");
        String shellChoice = scanner.nextLine();

        switch (shellChoice) {
            case "1":
                return "Corn";
            case "2":
                return "Flour";
            case "3":
                return "Hard Shell";
            case "4":
                return "Bowl";
            default:
                System.out.println("Invalid shell option entered. Try again.");
                System.out.println("\n");
        }
        return "";
    }

    private String selectSize() {
        System.out.println("Select size: ");
        System.out.println("\t1) Single");
        System.out.println("\t2) 3 Taco Plate");
        System.out.println("\t3) Burrito");
        System.out.println("Enter your selection: ");
        String size = scanner.nextLine();

        switch (size) {
            case "1":
                return "Single";
            case "2":
                return "3 Taco Plate";
            case "3":
                return "Burrito";
            default:
                System.out.println("Invalid size option entered. Try again.");
                System.out.println("\n");
        }
        return "";
    }

    private void selectPremiumMeatToppings(Taco taco) {
        boolean firstMeat = true;
        while (true) {
            //meat selection
            System.out.println("Select meat type: ");
            System.out.println("\t1) Carne Asada");
            System.out.println("\t2) Al Pastor");
            System.out.println("\t3) Carnitas");
            System.out.println("\t4) Pollo");
            System.out.println("\t5) Chorizo");
            System.out.println("\t6) Pescado");
            System.out.println("\t0) Done");
            System.out.println("Enter your selection: ");
            String meatType = scanner.nextLine();

            PremiumTopping meat = null;
            switch (meatType) {
                case "1":
                    if (firstMeat) {
                        meat = new PremiumTopping("Carne Asada", 1.00, 2.00, 3.00);
                        firstMeat = false;
                    } else {
                        meat = new PremiumTopping("Carne Asada", 0.50, 1.00, 1.50);
                    }
                    break;
                case "2":
                    if (firstMeat) {
                        meat = new PremiumTopping("Al Pastor", 1.00, 2.00, 3.00);
                        firstMeat = false;
                    } else {
                        meat = new PremiumTopping("Al Pastor", 0.50, 1.00, 1.50);
                    }
                    break;
                case "3":
                    if (firstMeat) {
                        meat = new PremiumTopping("Carnitas", 1.00, 2.00, 3.00);
                        firstMeat = false;
                    } else {
                        meat = new PremiumTopping("Carnitas", 0.50, 1.00, 1.50);
                    }
                    break;
                case "4":
                    if (firstMeat) {
                        meat = new PremiumTopping("Pollo", 1.00, 2.00, 3.00);
                        firstMeat = false;
                    } else {
                        meat = new PremiumTopping("Pollo", 0.50, 1.00, 1.50);
                    }
                    break;
                case "5":
                    if (firstMeat) {
                        meat = new PremiumTopping("Chorizo", 1.00, 2.00, 3.00);
                        firstMeat = false;
                    } else {
                        meat = new PremiumTopping("Chorizo", 0.50, 1.00, 1.50);
                    }
                    break;
                case "6":
                    if (firstMeat) {
                        meat = new PremiumTopping("Pescado", 1.00, 2.00, 3.00);
                        firstMeat = false;
                    } else {
                        meat = new PremiumTopping("Pescado", 0.50, 1.00, 1.50);
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid meat option entered. Try again.");
                    System.out.println("\n");
            }
            if (meat != null) {
                taco.addTopping(meat);
            }

        }
    }

    private void selectPremiumCheeseToppings(Taco taco) {
        boolean firstCheese = true;
        while (true) {
            System.out.println("Select cheese type: ");
            System.out.println("\t1) Queso Fresco");
            System.out.println("\t2) Oaxaca");
            System.out.println("\t3) Cotija");
            System.out.println("\t4) Cheddar");
            System.out.println("\t0) Done");
            System.out.println("Enter your selection: ");
            String cheeseType = scanner.nextLine();

            PremiumTopping cheese = null;
            switch (cheeseType) {
                case "1":
                    if (firstCheese) {
                        cheese = new PremiumTopping("Queso Fresco", 0.75, 1.50, 2.25);
                        firstCheese = false;
                    } else {
                        cheese = new PremiumTopping("Queso Fresco", 0.30, 0.60, 0.90);
                    }
                    break;
                case "2":
                    if (firstCheese) {
                        cheese = new PremiumTopping("Oaxaca", 0.75, 1.50, 2.25);
                        firstCheese = false;
                    } else {
                        cheese = new PremiumTopping("Oaxaca", 0.30, 0.60, 0.90);
                    }
                    break;
                case "3":
                    if (firstCheese) {
                        cheese = new PremiumTopping("Cotija", 0.75, 1.50, 2.25);
                        firstCheese = false;
                    } else {
                        cheese = new PremiumTopping("Cotija", 0.30, 0.60, 0.90);
                    }
                    break;
                case "4":
                    if (firstCheese) {
                        cheese = new PremiumTopping("Cheddar", 0.75, 1.50, 2.25);
                        firstCheese = false;
                    } else {
                        cheese = new PremiumTopping("Cheddar", 0.30, 0.60, 0.90);
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid cheese option entered. Try again.");
                    System.out.println("\n");


            }
            if (cheese != null) {
                taco.addTopping(cheese);
            }

        }
    }

    private void selectRegularToppings(Taco taco) {
        while (true) {
            System.out.println("Select toppings: ");
            System.out.println("\t1) Lettuce");
            System.out.println("\t2) Cilantro");
            System.out.println("\t3) Onions");
            System.out.println("\t4) Tomatoes");
            System.out.println("\t5) Jalapeños");
            System.out.println("\t6) Radishes");
            System.out.println("\t7) Pico de gallo");
            System.out.println("\t8) Guacamole");
            System.out.println("\t9) Corn");
            System.out.println("\t0) Done");
            System.out.println("Enter your selection: ");
            String userOption = scanner.nextLine();

            switch (userOption) {
                case "1":
                    taco.addTopping(new RegularTopping("Lettuce"));
                    break;
                case "2":
                    taco.addTopping(new RegularTopping("Cilantro"));
                    break;
                case "3":
                    taco.addTopping(new RegularTopping("Onions"));
                    break;
                case "4":
                    taco.addTopping(new RegularTopping("Tomatoes"));
                    break;
                case "5":
                    taco.addTopping(new RegularTopping("Jalapeños"));
                    break;
                case "6":
                    taco.addTopping(new RegularTopping("Radishes"));
                    break;
                case "7":
                    taco.addTopping(new RegularTopping("Pico de gallo"));
                    break;
                case "8":
                    taco.addTopping(new RegularTopping("Guacamole"));
                    break;
                case "9":
                    taco.addTopping(new RegularTopping("Corn"));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid topping option entered. Try again.");
                    System.out.println("\n");
            }
        }

    }

    private void selectSauces(Taco taco) {
        while (true) {
            System.out.println("Select sauces: ");
            System.out.println("\t1) Salsa Verde");
            System.out.println("\t2) Salsa Roja");
            System.out.println("\t3) Chipotle");
            System.out.println("\t4) Habanero");
            System.out.println("\t5) Mild");
            System.out.println("\t6) Extra Hot");
            System.out.println("\t7) Mango Heat");
            System.out.println("\t0) Done");
            System.out.println("Enter your selection: ");
            String sauceOption = scanner.nextLine();

            switch (sauceOption) {
                case "1":
                    taco.addTopping(new RegularTopping("Salsa Verde"));
                    break;
                case "2":
                    taco.addTopping(new RegularTopping("Salsa Roja"));
                    break;
                case "3":
                    taco.addTopping(new RegularTopping("Chipotle"));
                    break;
                case "4":
                    taco.addTopping(new RegularTopping("Habanero"));
                    break;
                case "5":
                    taco.addTopping(new RegularTopping("Mild"));
                    break;
                case "6":
                    taco.addTopping(new RegularTopping("Extra Hot"));
                    break;
                case "7":
                    taco.addTopping(new RegularTopping("Mango Heat"));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid sauce option entered. Try again.");
                    System.out.println("\n");
            }
        }

    }

    private void selectSides(Taco taco) {
        while (true) {
            System.out.println("Select sides: ");
            System.out.println("\t1) Lime Wedges");
            System.out.println("\t2) Crema");
            System.out.println("\t0) Done");
            System.out.println("Enter your selection: ");
            String sidesOption = scanner.nextLine();

            switch (sidesOption) {
                case "1":
                    taco.addTopping(new RegularTopping("Lime Wedges"));
                    break;
                case "2":
                    taco.addTopping(new RegularTopping("Crema"));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid side option entered. Try again.");
                    System.out.println("\n");
            }
        }
    }

    private void selectCovered(Taco taco) {
        System.out.println("Would you like the taco/burrito covered in salsa and queso?");
        System.out.println("\t1) Yes");
        System.out.println("\t2) No");
        System.out.println("Enter your selection: ");
        String coveredOption = scanner.nextLine();

        if (coveredOption.equals("1")) {
            taco.setCovered();
        }
    }


    public void displayAddDrinkScreen() {
        //size options
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("              YOUR DRINK");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("Select size: ");
        System.out.println("\t1) Small");
        System.out.println("\t2) Medium");
        System.out.println("\t3) Large");
        System.out.println("Enter your selection: ");
        String sizeOption = scanner.nextLine();

        String size = "";
        switch (sizeOption) {
            case "1":
                size = "Small";
                break;
            case "2":
                size = "Medium";
                break;
            case "3":
                size = "Large";
                break;
            default:
                System.out.println("Invalid size option entered. Try again.");
                System.out.println("\n");
        }

        //flavor options
        System.out.println("Select drink: ");
        System.out.println("\t1) Coke");
        System.out.println("\t2) Sprite");
        System.out.println("\t3) Bottle Water");
        System.out.println("\t4) Topo Chico");
        System.out.println("Enter your selection: ");
        String flavorOption = scanner.nextLine();

        String flavor = "";
        switch (flavorOption) {
            case "1":
                flavor = "Coke";
                break;
            case "2":
                flavor = "Sprite";
                break;
            case "3":
                flavor = "Bottle Water";
                break;
            case "4":
                flavor = "Topo Chico";
                break;
            default:
                System.out.println("Invalid flavor option entered. Try again.");
                System.out.println("\n");
        }
        Drink drink = new Drink(size, flavor);
        order.addDrink(drink);
    }

    public void displayAddChipsAndSalsaScreen() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("              YOUR CHIPS AND SALSA");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("Select salsa: ");
        System.out.println("\t1) Smoky Señorita \uD83D\uDD25 Rich chipotle and roasted garlic salsa with a deep, slow-building smokiness. The fan favorite.");
        System.out.println("\t2) Fuego Fresco \uD83D\uDD25\uD83D\uDE05 Bright, fiery salsa with fresh habanero, charred tomato, and a squeeze of lime. Hot but balanced.");
        System.out.println("\t3) Mean Green \uD83D\uDD25\uD83D\uDD25\uD83E\uDD27 Punchy tomatillo-serrano salsa with cilantro and a sharp, herbaceous kick. Not for the faint of heart.");
        System.out.println("\t4) Mango Heat \uD83D\uDD25\uD83D\uDD25\uD83D\uDD25\uD83E\uDD75 Sweet mango meets scorpion pepper in this fruity, deceptively spicy salsa. Looks innocent, isn't.");
        System.out.println("Enter your selection: ");
        String salsaOption = scanner.nextLine();

        String salsa = "";
        switch (salsaOption) {
            case "1":
                salsa = "Smokey Señorita";
                break;
            case "2":
                salsa = "Fuego Fresco";
                break;
            case "3":
                salsa = "Mean Green";
                break;
            case "4":
                salsa = "Mango Heat";
                break;
            default:
                System.out.println("Invalid salsa option entered. Try again.");
                System.out.println("\n");
        }
        ChipsAndSalsa chips = new ChipsAndSalsa(salsa);
        order.addChips(chips);
    }


    public void displayCheckoutScreen() {
        if (!order.isValid()) {
            System.out.println("Invalid order! You must purchase chips and salsa or a drink.");
            return;
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("              ORDER SUMMARY");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println(order.getOrderSummary());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("              CONFIRM ORDER?");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("Select option: ");
        System.out.println("\t1) Confirm");
        System.out.println("\t2) Add more items");
        System.out.println("\t0) Cancel");
        System.out.println("Enter your selection: ");
        String checkoutOption = scanner.nextLine();

        switch (checkoutOption) {
            case "1":
                Receipt receipt = new Receipt();
                receipt.saveOrderReceipt(order);
                System.out.println("****************************************");
                System.out.println("   Thank you for choosing Nacho Average");
                System.out.println("         Taco Spot! See you soon!");
                System.out.println("****************************************");
                order = new Order();
                return;
            case "2":
                displayOrderScreen();
                break;
            case "0":
                order = new Order();
                break;
            default:
                System.out.println("Invalid checkout option entered. Try again.");
                System.out.println("\n");
        }
    }


}