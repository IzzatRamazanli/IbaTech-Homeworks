package com.izzat.pets;

import com.izzat.abstracts.Pet;
import com.izzat.enums.Species;
import com.izzat.interfaces.Foul;

public class Dog extends Pet implements Foul {

    public Dog() {
        super.setSpecies(Species.DOG);
    }

    public Dog(String nickName, int age, int trickLevel, String[] habits) {
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.DOG);
    }

    @Override
    public void foul() {
        System.out.println(this.getNickName() + " fouled");
    }

    @Override
    public void respond() {
        System.out.println(this.getNickName() + " greeting owner");
    }
}
