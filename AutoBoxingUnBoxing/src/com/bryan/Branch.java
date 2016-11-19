package com.bryan;

import java.util.ArrayList;

/**
 * Created by johnbryansazon on 19/11/2016.
 */


public class Branch {
    private String branchName;
    private ArrayList<Customer> customersList;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customersList = new ArrayList<Customer>();
    }

    public static Branch createBranch(String name) {
        return new Branch(name);
    }

    public void addCustomer(Customer customer) {
        customersList.add(customer);
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }
}

