package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Pet pet = new Pet("dog",
                "Max",
                2,
                45,
                new String[]{"eating", "sleeping, playing with bone"}
        );

        Human father = new Human("John", "Maxwell", 1973);
        Human mother = new Human("Jane", "Maxwell", 1977);

        Human child = new Human("Mike", "Maxwell", 2002,
                mother, father,
                92,
                pet,
                new String[][]{{"monday, do exercise"}}
        );


        child.greetPet();
        child.describePet();
        pet.respond();

        //Advanced part
        //feeding pet
        Random random = new Random();
        int generatedNumber = random.nextInt(101);
        boolean feedTime;
        if (pet.trickLevel >= generatedNumber) {
            feedTime = true;
        } else {
            feedTime = false;
        }
        child.feedPet(feedTime);
        //End of advanced implementation

        pet.eat();
        System.out.println(child);


    }
}
