package com.bryan;

/**
 * Created by johnbryansazon on 12/11/2016.
 */
public class Furnitures {
    private String name;
    private double cost;
    private String purpose;

    public Furnitures(String name, double cost, String purpose) {
        this.name = name;
        this.cost = cost;
        this.purpose = purpose;
    }

    public void placeFurniture() {
        System.out.println("Placing " + name + " for " + purpose);
        System.out.println(name + " costed you " + String.format("%.2f", cost));
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getPurpose() {
        return purpose;
    }
}
