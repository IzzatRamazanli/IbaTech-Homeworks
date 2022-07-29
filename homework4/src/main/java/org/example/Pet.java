package org.example;

import java.util.Arrays;

public class Pet {
    String species;
    String nickName;
    int age;
    int trickLevel;
    String[] habits;

    //overriding toString
    @Override
    public String toString() {
        return this.species + "{" +
                "nickName='" + nickName + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

    //empty constructor
    public Pet() {

    }

    // constructor with species and nickname
    public Pet(String species, String nickName) {
        this.species = species;
        this.nickName = nickName;
    }

    // constructor with all fields
    public Pet(String species, String nickName, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickName = nickName;
        this.age = age;
        if (trickLevel < 1 || trickLevel > 100) {
            System.out.println("Tricklevel must be between 1-100");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Redefine the tricklevel in 1-100 please: ");
            trickLevel = scanner.nextInt();
            this.trickLevel = trickLevel;
        } else {
            this.trickLevel = trickLevel;
        }
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I am eating.");
    }

    public void respond() {
        System.out.println("Hello, owner. I am " + this.nickName + ". I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }
}
