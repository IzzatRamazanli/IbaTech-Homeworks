package com.izzat;

import com.izzat.abstracts.Pet;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;
import com.izzat.pets.Dog;

public class Main {

    public static void main(String[] args) {

        Pet dogMax = new Dog("Max", 2, 45, new String[]{"eating", "playing with bone"});
        dogMax.respond();

        Man fatherJohn = new Man("John", "Maxwell", 1973, 98);

        Woman motherJane = new Woman("Jane", "Maxwell", 1977, 96);

        Family maxwellFamily = new Family(motherJane, fatherJohn);

        maxwellFamily.setPet(dogMax);

        Human childBarny = new Human("Barny", "Maxwell", 2002);

        //advanced complexity implemented
        motherJane.bornChild(childBarny, maxwellFamily, fatherJohn);

        System.out.println(maxwellFamily);


    }
}
