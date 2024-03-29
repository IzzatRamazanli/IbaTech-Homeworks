package com.izzat.humans;

import com.izzat.Family;
import com.izzat.Human;
import com.izzat.enums.DayOfWeek;
import com.izzat.interfaces.HumanCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class Woman extends Human implements HumanCreator {
    public Woman() {
        super.setSchedule(super.getSchedule());
    }

    public Woman(String name, String surname, int year, int iq, Map<DayOfWeek, String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
        super.setSchedule(super.getSchedule());
    }

    @Override
    public void greetPet() {
        System.out.println("Hello from Ms." + this.getSurname());
    }

    public void cookingCake() {
        System.out.println("I'm cooking cake for my guests");
    }


    // ADVANCED COMPLEXITY PART -- OVERRIDED FROM HUMANCREATOR INTERFACE
    @Override
    public Human bornChild(Family family, Human father) {
        Human child = genderSetter();
        child.setFamily(family);
        child.setSurname(father.getSurname());
        child.setName(randomName(child));
        child.setYear(2022);
        int averageIq = (family.getFather().getIq() + family.getMother().getIq()) / 2;
        child.getFamily().setMother(this);
        child.getFamily().setFather(father);
        child.setIq(averageIq);
        family.addChild(child);
        return child;
    }

    //PART OF ADVANCED COMPLEXITY
    private Human genderSetter() {
        Random random = new Random();
        List<Human> gender = new ArrayList<>();
        gender.add(new Man());
        gender.add(new Woman());
        int i = random.nextInt(2);
        return gender.get(i);
    }

    //PART OF ADVANCED COMPLEXITY
    private String randomName(Human child) {
        List<String> nameMan = List.of("Barny", "Bill", "Jeff", "Messi", "Neymar", "Ben", "Tom", "Tim", "Alex", "Max");
        List<String> nameWoman = List.of("Adaline", "Monica", "Alice", "Emmy", "Fiona", "Cindy", "Elena", "Gal", "Natalie", "Scarlet");
        Random rd = new Random();
        int i = rd.nextInt(10);
        if (child instanceof Man) return nameMan.get(i);
        else return nameWoman.get(i);
    }


}
