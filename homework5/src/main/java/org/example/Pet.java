package org.example;

import java.util.Arrays;

public class Pet {
    private String species;
    private String nickName;
    private int age;
    private int trickLevel;
    private String[] habits;

    //Advanced complexity static and non-static initialisation
    static {
        System.out.println(Pet.class.getName().substring(12) + " class loaded");
    }

    {
        System.out.println("New object is created: " + this.getClass().getTypeName().substring(12));
    }

    //overriding toString
    @Override
    public String toString() {
        return this.getSpecies() + "{" +
                "nickName='" + getNickName() + '\'' +
                ", age=" + getAge() +
                ", trickLevel=" + getTrickLevel() +
                ", habits=" + Arrays.toString(getHabits()) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Pet)) return false;

        Pet pet = (Pet) obj;
        return this.nickName.equals(pet.nickName) &&
                this.species.equals(pet.species) &&
                this.age == pet.age &&
                this.trickLevel == pet.trickLevel;
    }


    //empty constructor
    public Pet() {

    }

    // constructor with species and nickname
    public Pet(String species, String nickName) {
        this.setSpecies(species);
        this.setNickName(nickName);
    }

    // constructor with all fields
    public Pet(String species, String nickName, int age, int trickLevel, String[] habits) {
        this.setSpecies(species);
        this.setNickName(nickName);
        this.setAge(age);
        this.setTrickLevel(trickLevel);
        this.setHabits(habits);
    }

    public void eat() {
        System.out.println("I am eating.");
    }

    public void respond() {
        System.out.println("Hello, owner. I am " + this.getNickName() + ". I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }
}
