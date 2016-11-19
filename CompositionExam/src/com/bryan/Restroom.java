package com.bryan;

/**
 * Created by johnbryansazon on 12/11/2016.
 */
public class Restroom {
    private int width;
    private int length;
    private Furnitures furnitures;

    public Restroom(int width, int length, Furnitures furnitures) {
        this.width = width;
        this.length = length;
        this.furnitures = furnitures;
        System.out.println("Your restroom size (width x length): " + width + "x" + length);
    }

    public void addTub() {
        furnitures.placeFurniture();
    }
    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public Furnitures getFurnitures() {
        return furnitures;
    }
}
