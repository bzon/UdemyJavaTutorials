package com.bryan;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        while(!quit) {
            printInstructions();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    System.out.println("Quitting the application.");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Repeat again.");
                    printInstructions();
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - to print the grocery list.");
        System.out.println("\t 2 - to add an item to the grocery list.");
        System.out.println("\t 3 - to modify an item in the grocery list.");
        System.out.println("\t 4 - to remove an item from the grocery list.");
        System.out.println("\t 5 - to search for an item in the grocery list.");
        System.out.println("\t 6 - to quit the application.");
    }

    public static void addItem() {
        System.out.println("Please enter a grocery items and press Q to exit: ");
        String newItem = scanner.nextLine();;
        groceryList.addGroceryItem(newItem);
    }

    public static void modifyItem() {
        System.out.print("Current item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter new item: ");
        String newItemName = scanner.nextLine();
        groceryList.modifyGroceryItem(itemName, newItemName);
    }

    public static void removeItem() {
        System.out.print("Enter item name: ");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem() {
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.findItem(searchItem) >= 0) {
            System.out.println("Found " + searchItem + " in the grocery list.");
        } else {
            System.out.println(searchItem + " was not found in the grocery list.");
        }
    }
}
