package com.izzat.abstracts;

import com.izzat.enums.Species;

import java.io.Serializable;
import java.util.*;

public abstract class Pet implements Serializable {
    private static final long serialVersionID = 1L;
    private Species species;
    private String nickName;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    //empty constructor
    public Pet() {

    }

    // constructor with species and nickname
    public Pet(String nickName) {
        this.setSpecies(Species.UNKNOWN);
        this.setNickName(nickName);
    }

    // constructor with all fields
    public Pet(String nickName, int age, int trickLevel, Set<String> habits) {
        this.setSpecies(Species.UNKNOWN);
        this.setNickName(nickName);
        this.setAge(age);

        if (trickLevel < 1 || trickLevel > 100) {
            System.out.println("Tricklevel must be between 1-100");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Redefine tricklevel in 1-100 please: ");
            trickLevel = scanner.nextInt();
            this.setTrickLevel(trickLevel);
        } else {
            this.setTrickLevel(trickLevel);
        }
        this.setHabits(habits);
    }

    public void eat() {
        System.out.println("I am eating.");
    }

    public abstract void respond();

    public Species getSpecies() {
        return Species.valueOf(species.name());
    }

    public void setSpecies(Species species) {
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

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    //overriding toString


    @Override
    public String toString() {
        return species.name() + "{" +
                "species=" + species +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habits +
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

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this.nickName + " object collected by Garbage Collector");
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpecies(), getNickName(), getAge(), getTrickLevel());
    }
}
