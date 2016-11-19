package com.bryan;

public class Main {

    public static void main(String[] args) {
        Restroom myRestroom = new Restroom(50,60, new Furnitures("tub", 1500, "bathing"));
        Bedroom myBedroom = new Bedroom(50,60, new Furnitures("bed", 1000, "sleeping"));
        House myHouse = new House(myRestroom, myBedroom);
        myHouse.makeRestroom();
        myHouse.makeBedroom();

    }
}
