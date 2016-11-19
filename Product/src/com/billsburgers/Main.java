package com.billsburgers;

public class Main {

    private static boolean hasLettuce = true;
    private static boolean hasTomato = true;
    private static boolean hasKechup = true;
    private static boolean hasMustard = true;
    private static boolean hasCheese = true;

    public static void main(String[] args) {
	    Hamburger burger = healthyOrder(true, true);
        burger.addExtras(hasCheese, hasKechup, hasLettuce, hasMustard, hasTomato);
        burger.checkout();
        System.out.println("*************************************");
        Hamburger burger2 = deluxeOrder(true, true);
        burger.addExtras(hasCheese, hasKechup, hasLettuce, hasMustard, hasTomato);
        burger.checkout();
    }

    public static HealthyBurger healthyOrder(boolean hasBrocolli, boolean hasCarrot) {
        return new HealthyBurger(hasBrocolli, hasCarrot);
    }

    public static DeluxeBurger deluxeOrder(boolean hasChips, boolean hasSoda) {
        return new DeluxeBurger(hasSoda, hasChips);

    }
}
