package org.example;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();
        pet.species = "dog";
        pet.nickName = "Max";
        pet.age = 2;
        pet.trickLevel = 45;
        pet.habits = new String[]{"eating", "sleeping", "playing with bone"};

        Human father = new Human("Jone", "Maxwell", 1973);
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
        pet.eat();
        System.out.println(child);


    }
}