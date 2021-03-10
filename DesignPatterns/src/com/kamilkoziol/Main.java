package com.kamilkoziol;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Animal donkey = new Animal("Donkey", 20, 10, "Yoink!");
	    FlyingAnimal bird = new FlyingAnimal("Ptak", 1, 5, "Nirl!", 12);
	    Sroka sroka = new Sroka("Srokosz");

        ArrayList<Animal> animals = new ArrayList<Animal>();

        animals.add(donkey);
        animals.add(bird);
        animals.add(sroka);

        for(Animal a: animals) {
            if(a instanceof FlyingAnimal) {
                FlyingAnimal flyingAnimal = (FlyingAnimal) a;
                System.out.println(a.getSound());
            }
        }
    }
}
