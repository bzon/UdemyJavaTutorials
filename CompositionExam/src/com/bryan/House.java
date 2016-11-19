package com.bryan;

/**
 * Created by johnbryansazon on 12/11/2016.
 */
public class House {
    private Restroom restroom;
    private Bedroom bedroom;

    public House(Restroom restroom, Bedroom bedroom) {
        this.restroom = restroom;
        this.bedroom = bedroom;
    }

    public void makeRestroom() {
        restroom.addTub();
    }

    public void makeBedroom() {
        bedroom.addBed();
    }

}
