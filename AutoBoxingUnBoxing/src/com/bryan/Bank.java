package com.bryan;

import java.util.ArrayList;

/**
 * Created by johnbryansazon on 19/11/2016.
 */

public class Bank {
    private String bankName;
    private ArrayList<Branch> branchesList;

    public Bank() {
        this.bankName = "Bryan's Bank";
        this.branchesList = new ArrayList<Branch>();
    }

    public void printBranches() {
        System.out.println("Branches available: ");
        for (int i=0; i < branchesList.size(); i++) {
            int customerListSize = branchesList.get(i).getCustomersList().size();
            System.out.println("Branch name: " + branchesList.get(i).getBranchName() + ", # of customers: " + customerListSize);
        }
    }

    public void printCustomersFromBranches(String branch, boolean showTransactions) {
        int index = queryBranch(branch);
        if ( index >=0) {
            System.out.println("Listing all customers from " + branch + " branch.");
            for (int i=0; i <branchesList.get(index).getCustomersList().size(); i++) {
                String name = branchesList.get(index).getCustomersList().get(i).getName();
                System.out.println((i+1) + ". " + name);
                if (showTransactions) {
                    System.out.println("\t Transactions: ");
                    for (int x=0; x < branchesList.get(index).getCustomersList().get(i).getTransactionsList().size(); x++) {
                        System.out.println("\t " + (x+1) + ". " + branchesList.get(index).getCustomersList().get(i).getTransactionsList().get(x));
                    }
                }
            }
        } else {
            return;
        }
    }

    public boolean addBranch(Branch branch) {
        if(findBranch(branch) >= 0) {
            System.out.println("Branch already exists.");
            return false;
        }
        branchesList.add(branch);
        return true;
    }

    public boolean addCustomerToBranch(Branch branch, Customer customer) {
        int index = findCustomer(branch, customer.getName());
        if (index < 0) {
            branch.addCustomer(customer);
            return true;
        }
        System.out.println("Customer already exists.");
        return false;
    }

    public boolean addTransactionToCustomer(Branch branch, Double transaction, String customerName) {
        int index = findCustomer(branch, customerName);
        if (index >= 0) {
            branch.getCustomersList().get(index).addTransaction(transaction);
            return true;
        }

        return false;
    }

    public int findCustomer(Branch branch, String customer) {
        int index = findBranch(branch);
        if (index >= 0) {
            int getSize = branchesList.get(index).getCustomersList().size();
            for (int i=0; i < getSize; i++) {
                boolean nameIsFound = branchesList.get(index).getCustomersList().get(i).getName().equals(customer);
                if (nameIsFound) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int queryBranch(String branch) {
        for (int i=0; i < branchesList.size(); i++) {
            if (branchesList.get(i).getBranchName().equals(branch)) {
                return i;
            }
        }
        System.out.println(branch + " branch does not exists.");
        return -1;
    }

    private int findBranch(Branch branch) {
        return branchesList.indexOf(branch);
    }

}
