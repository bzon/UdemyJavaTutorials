package com.bryan;

import java.util.ArrayList;


/* Create a program that implements a simple mobile phone with the following capabilities.
 Able to store, modify, remove and query contact names.
 You will want to create a separate class for Contacts (name and phone number).
 Create a master class (MobilePhone) that holds the ArrayList of Contacts
 The MobilePhone class has the functionality listed above.
 Add a menu of options that are available.
 Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
 and search/find contact.
 When adding or updating be sure to check if the contact already exists (use name)
 Be sure not to expose the inner workings of the Arraylist to MobilePhone
 e.g. no ints, no .get(i) etc
 MobilePhone should do everything with Contact objects only.
 */

/**
 * Created by johnbryansazon on 18/11/2016.
 */

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts; // Initialize an array of objects using the Contact Class

    public MobilePhone() {
        //this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    // Print the values of name and number from myContacts[object index]
    public void printContacts() {
        System.out.println("Printing contacts..");
        for (int i=0; i < myContacts.size(); i ++) {
            System.out.println("Object: " + this.myContacts.get(i) + " index: " + (i+1) + ". " +
                        this.myContacts.get(i).getName() + " -> " +
                        this.myContacts.get(i).getPhoneNumber());
        }
    }

    // Create a new object from Contact Class and add it to myContact array list
    public boolean addNewContact(Contact contact) {
        System.out.println("MobilePhone.addNewcontact is called!");
        if(findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        System.out.println("New contact added.");
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + " has been replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + " was not found.");
            return false;
        }
        this.myContacts.remove(contact);
        System.out.println(contact.getName() + " has been removed.");
        return true;

    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String contactName) {
        for (int i=0;i<this.myContacts.size();i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            System.out.println("Phone number: " + this.myContacts.get(position).getPhoneNumber());
            return this.myContacts.get(position);
        }

        return null;
    }

}

