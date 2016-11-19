package com.bryan;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static Bank myBank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Branch branch = Branch.createBranch("Johannesburg");
        myBank.addBranch(branch);
        Branch newBranch = Branch.createBranch("Cape Town");
        myBank.addBranch(newBranch);
        // Create customer objects and add it to Customer list
        myBank.addCustomerToBranch(branch, Customer.createCustomer("Bryan", +50_000.00));
        myBank.addCustomerToBranch(branch, Customer.createCustomer("Desy", +20_000.00));
        myBank.addCustomerToBranch(newBranch, Customer.createCustomer("Sazon", +35_000.00));
        // Create transaction from a customer
        myBank.addTransactionToCustomer(branch, 10_000.00, "Bryan");

        myBank.printBranches();
        myBank.printCustomersFromBranches("Johannesburg", true);
        myBank.printCustomersFromBranches("Cape Town", true);

    }

}
