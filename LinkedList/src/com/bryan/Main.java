package com.bryan;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<String>();
        addInOrder(cities, "Sydney");
        addInOrder(cities, "Melbourne");
        addInOrder(cities, "Brisbane");
        addInOrder(cities, "Perth");
        addInOrder(cities, "Canberra");
        addInOrder(cities, "Darwin");
        printList(cities);

        visit(cities);
    }

    public static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("========================");
    }

    private static boolean addInOrder(LinkedList linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included as a destination.");
                return false;
            } else if (comparison > 0) {
                // new city should appear before this one
                //  Brisbane --> Adelaine
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if(comparison < 0) {
                // move to the next city

            }
        }

        // This will run if the iterator has no next
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = false;
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the intenerary.");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Vacation is over");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward) {
                        if(listIterator.hasNext()) {
                            System.out.println("running listIterator.next();");
                            listIterator.next();
                        }
                        System.out.println("set goingForward = true");
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        System.out.println("set goingForward = false");
                        goingForward = false;
                    }

                    System.out.println("goingForward = " + goingForward);
                    break;

                case 2:
                    if (goingForward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("running listIterator.previous();");
                            listIterator.previous();
                        }
                        System.out.println("set goingForward = false");
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are now at the start of the list");
                        System.out.println("set goingForward = true");
                        goingForward = true;
                    }

                    System.out.println("goingForward = " + goingForward);
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress: ");
        System.out.println("0 - to quiet\n" +
                                   "1 - go to next city.\n" +
                        "2 - go to previous city.\n" +
                        "3 - print menu.");
    }
}
