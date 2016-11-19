package com.bryan;

public class Main {

    public static void main(String[] args) {

        Car myCar = select();
        myCar.startEngine();
        myCar.accelerate(15);

    }

    public static Car select() {
        return new Bugatti();
    }
}
