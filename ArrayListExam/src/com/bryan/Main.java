package com.bryan;

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

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printInstructions();
        while(!quit) {
            System.out.println("Enter action: (0 to show available actions)");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    shutDown();
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Contact name: ");
        String name = scanner.nextLine();
        System.out.println("Phone number: ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if (!mobilePhone.addNewContact(newContact)) {
            System.out.println(name + "not added in contacts.");
        }
    }

    private static void removeContact() {
        Contact existingContactRecord = queryContact();
        if (existingContactRecord == null) {
            return;
        }
        mobilePhone.removeContact(existingContactRecord);
    }

    private static Contact queryContact() {
        System.out.println("Search contact name.");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return null;
        }
        return existingContactRecord;
    }

    private static void updateContact() {
        Contact existingContactRecord = queryContact();
        if (existingContactRecord == null) {
            return;
        }
        System.out.println("Enter new name.");
        String newName = scanner.nextLine();
        System.out.println("Enter new phone number.");
        String newNumber = scanner.nextLine();
        Contact newContactRecord = Contact.createContact(newName, newNumber);
        mobilePhone.updateContact(existingContactRecord, newContactRecord);

    }

    private static void startPhone() {
        System.out.println("Starting phone...");
    }

    private static void printInstructions() {
        System.out.println("\nPress: ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - to print the contact list.");
        System.out.println("\t 2 - to add an item to the contact list.");
        System.out.println("\t 3 - to modify an item in the contact list.");
        System.out.println("\t 4 - to remove an item from the contact list.");
        System.out.println("\t 5 - to search for an item in the contact list.");
        System.out.println("\t 6 - to quit the application.");
    }

    private static void shutDown() {
        System.out.println("Shutting down mobile phone...");
    }

}
