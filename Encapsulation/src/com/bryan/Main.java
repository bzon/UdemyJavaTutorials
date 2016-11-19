package com.bryan;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(100, true);
        printer.print(100);
        printer.fillUp(50);
        System.out.println("Total toner level = " + printer.getTonerLevel());
        printer.print(5);
        System.out.println("Total pages printed = " + printer.getPagesPrinted());
        System.out.println("Total toner level = " + printer.getTonerLevel());

    }
}
