package com.kamilkoziol;

public class FlyingAnimal extends Animal {

    private double flyingSpeed;

    public FlyingAnimal(String name, double height, double weight, String sound, double flyingSpeed) {
        super(name, height, weight, sound);
        this.flyingSpeed = flyingSpeed;
    }

    public double getFlyingSpeed() {
        return flyingSpeed;
    }

    public void setFlyingSpeed(double flyingSpeed) {
        this.flyingSpeed = flyingSpeed;
    }
}
