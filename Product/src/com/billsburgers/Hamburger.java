package com.billsburgers;

/**
 * Created by johnbryansazon on 14/11/2016.
 */

public class Hamburger {
    private String meatType;
    private String rollType;
    private double price = 5.00;
    private boolean hasLettuce = false;
    private boolean hasTomato = false;
    private boolean hasKechup = false;
    private boolean hasMustard = false;
    private boolean hasCheese = false;
    private int totalAdditions;
    private boolean validCheckout = true;

    public Hamburger(String meatType, String rollType, double price) {
        this.meatType = meatType;
        this.rollType = rollType;
        this.price = price;
    }

    public void checkout() {
        if (isValidCheckout()) {
            System.out.println("Total price = " + String.format("%.2f", this.price));
        } else {
            System.out.println("Too many additions.");
        }

    }

    public void addExtras(boolean hasCheese, boolean hasKechup, boolean hasLettuce, boolean hasMustard, boolean hasTomato) {
        if (hasCheese) {
            System.out.println("Cheese added + $1.00");
            this.price = this.price + 1.00;
            this.totalAdditions += 1;
        }
        if (hasKechup) {
            System.out.println("Kechup added - no cost");
            this.totalAdditions += 1;
        }
        if (hasMustard) {
            System.out.println("Mustard added - no cost");
            this.totalAdditions += 1;
        }
        if (hasTomato) {
            System.out.println("Tomatoes added + $0.50");
            this.price = this.price + 0.50;
            this.totalAdditions += 1;
        }
        System.out.println("Total additions = " + this.totalAdditions);
        this.totalAdditions = 0;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setTotalAdditions(int totalAdditions) {
        this.totalAdditions = totalAdditions;
    }

    public int getTotalAdditions() {
        return totalAdditions;
    }

    public boolean isValidCheckout() {
        return validCheckout;
    }

    public void setValidCheckout(boolean validCheckout) {
        this.validCheckout = validCheckout;
    }
}

class HealthyBurger extends Hamburger {
    private boolean hasCarrot = false;
    private boolean hasBrocolli = false;

    public HealthyBurger(boolean hasBrocolli, boolean hasCarrot) {
        super("Lean Beef Patty","Brown Rye",10.00);
        this.hasCarrot = hasCarrot;
        this.hasBrocolli = hasBrocolli;
        System.out.println("Healthy burger ordered + $10.00");
    }

    @Override
    public void addExtras(boolean hasCheese, boolean hasKechup, boolean hasLettuce, boolean hasMustard, boolean hasTomato) {
        if (this.hasBrocolli) {
            System.out.println("Brocollis added + $1.00");
            this.setPrice(1.00 + this.getPrice());
            this.setTotalAdditions(this.getTotalAdditions() + 1);
        }
        if (this.hasCarrot) {
            System.out.println("Carrots added + $0.50");
            this.setPrice(0.50 + this.getPrice());
            this.setTotalAdditions(this.getTotalAdditions() + 1);
        }
        if (this.getTotalAdditions() > 6) {
            this.setValidCheckout(false);
        }
        super.addExtras(hasCheese, hasKechup, hasLettuce, hasMustard, hasTomato);
    }
}

class DeluxeBurger extends Hamburger {
    private boolean hasSoda = false;
    private boolean hasChips = false;

    public DeluxeBurger(boolean hasSoda, boolean hasChips) {
        super("Fat meat", "Classic Bun", 10.00);
        this.hasSoda = hasSoda;
        this.hasChips = hasChips;
        System.out.println("Deluxe burger ordered + $10.00");
    }

    @Override
    public void addExtras(boolean hasCheese, boolean hasKechup, boolean hasLettuce, boolean hasMustard, boolean hasTomato) {
        if (hasSoda) {
            System.out.println("Soda added + $5.50");
            this.setPrice(5.50 + this.getPrice());
            this.setTotalAdditions(this.getTotalAdditions() + 1);
        }
        if (hasChips) {
            System.out.println("Chip added + $5.50");
            this.setPrice(3.50 + this.getPrice());
            this.setTotalAdditions(this.getTotalAdditions() + 1);
        }
        if (this.getTotalAdditions() > 2) {
            this.setValidCheckout(false);
        }
        super.addExtras(hasCheese, hasKechup, hasLettuce, hasMustard, hasTomato);
    }
}