package com.bryan;

/**
 * Created by johnbryansazon on 18/11/2016.
 */

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Just to show that we can initialized the contstructor using a public method that can be called from the Main Class
    public static Contact createContact(String name, String phoneNumber) {
        System.out.println("Contact.createContact is called!");
        return new Contact(name, phoneNumber);
    }
}
