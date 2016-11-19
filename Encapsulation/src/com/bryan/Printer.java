package com.bryan;

/**
 * Created by johnbryansazon on 13/11/2016.
 */
public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplex;

    public Printer(int tonerLevel, boolean isDuplex) {
        this.tonerLevel = tonerLevel;
        this.isDuplex = isDuplex;
        this.pagesPrinted = 0;
    }

    public int fillUp(int amount) {
        if (amount < 1) {
            System.out.println("Invalid amount");
        } else {
            this.tonerLevel =+ amount;
            System.out.println("Fillup done!");
        }
        return this.tonerLevel;
    }

    public int print(int pages){
        System.out.println("Printing set to " + pages + " pages..");
        if (this.tonerLevel == 0) {
            System.out.println("No more toner for printing");
        } else {
            if (this.isDuplex) {
                this.pagesPrinted = (this.pagesPrinted + pages) / 2;
            } else {
                this.pagesPrinted = this.pagesPrinted + pages;
            }
            this.tonerLevel = this.tonerLevel - pages;
            System.out.println("Printing completed.");
        }
        return this.pagesPrinted;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
    public int getTonerLevel() {
        return tonerLevel;
    }
}
