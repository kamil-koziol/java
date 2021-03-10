package com.kamilkoziol;

import java.util.Objects;

public class Animal {
    private String name;
    private double height;
    private double weight;
    private String sound;

    public Animal(String name, double height, double weight, String sound) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if(height > 0) {
            this.height = height;
        } else {
            throw new Error("Height must be greater than 0");
        }

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", sound='" + sound + '\'' +
                '}';
    }

}
