package com.izzat.pets;

import com.izzat.abstracts.Pet;
import com.izzat.enums.Species;
import com.izzat.interfaces.Foul;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat() {
        super.setSpecies(Species.DOMESTICCAT);
    }

    public DomesticCat(String nickName, int age, int trickLevel, String[] habits) {
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.DOMESTICCAT);
    }


    @Override
    public void respond() {
        System.out.println(this.getNickName() + " responded");
    }

    @Override
    public void foul() {
        System.out.println(this.getNickName() + " fouled");
    }
}
