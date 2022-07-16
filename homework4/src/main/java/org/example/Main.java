package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int generatedNumber = random.nextInt(101);

        Pet pet = new Pet();
        pet.species = "dog";
        pet.nickName = "Max";
        pet.age = 2;
        pet.trickLevel = 45;
        pet.habits = new String[]{"eating", "sleeping", "playing with bone"};

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

        //feeding pet
        boolean feedTime;
        if (pet.trickLevel >= generatedNumber) {
            feedTime = true;
        } else {
            feedTime = false;
        }
        child.feedPet(feedTime);

        pet.eat();

        System.out.println(child);


    }
}
