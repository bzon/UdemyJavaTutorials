package com.bryan;

import java.util.ArrayList;

/**
 * Created by johnbryansazon on 19/11/2016.
 */

public class Customer {
    private String name;
    private ArrayList<Double> transactionsList = new ArrayList<Double>();

    public Customer(String name, Double transaction) {
        this.name = name;
        this.transactionsList.add(transaction);
    }

    public static Customer createCustomer(String name, double initialTransaction) {
        return new Customer(name, initialTransaction);
    }

    public void addTransaction(double amount) {
        this.transactionsList.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactionsList() {
        return transactionsList;
    }

}
