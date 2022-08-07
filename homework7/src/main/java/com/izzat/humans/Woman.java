package com.izzat.humans;

import com.izzat.Family;
import com.izzat.Human;
import com.izzat.interfaces.HumanCreator;

import java.util.Random;

public final class Woman extends Human implements HumanCreator {
    public Woman() {
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Woman(String name, String surname, int year, int iq) {
        super(name, surname, year, iq);
    }

    @Override
    public void greetPet() {
        System.out.println("Hello from Ms." + this.getSurname());
    }

    public void cookingCake() {
        System.out.println("I'm cooking cake for my guests");
    }


    @Override
    public Human bornChild(Human child, Family family, Human father) {//fix
        child.setFamily(family);
        int averageIq = (family.getFather().getIq() + family.getMother().getIq()) / 2;
        child.getFamily().setMother(this);
        child.getFamily().setFather(father);
        child.setIq(averageIq);
        family.addChild(child);
        return child;
    }
}
