package com.izzat.pets;

import com.izzat.abstracts.Pet;
import com.izzat.enums.Species;
import com.izzat.interfaces.Foul;

import java.util.HashSet;
import java.util.Set;

public class RoboCat extends Pet implements Foul {

    public RoboCat() {
        super.setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickName, int age, int trickLevel, Set<String> habits) {
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.println(this.getNickName() + " greeting owner");
    }

    @Override
    public void foul() {
        System.out.println(this.getNickName() + " fouled");
    }
}
