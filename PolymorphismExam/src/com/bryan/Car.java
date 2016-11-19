package com.bryan;

/**
 * Created by johnbryansazon on 13/11/2016.
 */
class Ferrari extends Car {
    public Ferrari() {
        super(8,4);
    }

    @Override
    public boolean startEngine() {
        System.out.println("Ferrari");
        return super.startEngine();
    }

    @Override
    public int accelerate(int speed) {
        System.out.println("Ferrari acceleration is 3x faster!");
        return super.accelerate(speed * 3);
    }
}

class Bugatti extends Car {
    public Bugatti() {
        super(10,2);
    }

    @Override
    public boolean startEngine() {
        System.out.println(getClass().getSimpleName());
        return super.startEngine();
    }

    @Override
    public int accelerate(int speed) {
        System.out.println(getClass().getSimpleName() + " acceleration is 2x faster!");
        return super.accelerate(speed * 2);
    }
}

public class Car {
    private boolean hasEngine;
    private int cylinders;
    private int wheels;
    private int doors;
    private int speed = 0;
    private boolean carStarted = false;

    public Car(int cylinders, int doors) {
        this.hasEngine = true;
        this.wheels = 4;
        System.out.println("A car with " + cylinders + " cylinders and " + doors + " doors.");
    }

    // A method that starts the car engine.
    public boolean startEngine() {
        this.carStarted = true;
        System.out.println("Car has started the engine.");
        return this.carStarted;
    }

    // A method that accelerates the car speed
    public int accelerate(int speed) {
        if (this.carStarted == false) {
            System.out.println("Car is not started. Can't accelerate.");
            return -1;
        } else {
            this.speed = this.speed + speed;
            System.out.println("Car is now accelerating with " + speed + " speed.");
            return this.speed;
        }
    }

    // A method that decreases the car total speed
    public void brake() {
        System.out.println("Hit brake pedal!");
        if (this.speed >= 10) {
            this.speed = this.speed - 10;
        } else {
            this.speed = 0;
        }
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getDoors() {
        return doors;
    }

    public int getSpeed() {
        return speed;
    }
}
