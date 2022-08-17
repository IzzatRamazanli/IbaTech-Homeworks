package com.izzat;

import com.izzat.abstracts.Pet;
import com.izzat.dao.FamilyController;
import com.izzat.dao.FamilyService;
import com.izzat.dao.implement.FamilyCollectionDao;
import com.izzat.enums.DayOfWeek;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;
import com.izzat.pets.Dog;
import com.izzat.pets.DomesticCat;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        FamilyController controller = new FamilyController();

        Set<String> habits = new HashSet<>();
        habits.add("eating");
        habits.add("sleeping");

        Pet dogMax = new Dog("Max", 2, 45, habits);
        Pet catCap = new DomesticCat("Cap", 3, 34, habits);

        Man fatherJohn = new Man("John", "Maxwell", 1973, 98);
        Woman motherJane = new Woman("Jane", "Maxwell", 1977, 96);

        Man father = new Man("Father", "Father", 1992, 99);
        Woman mother = new Woman("Mother", "Mother", 1992, 98);

        Family maxwellFamily = controller.createNewFamily(motherJane, fatherJohn);
        Family newFamily = controller.createNewFamily(mother, father);
        controller.addPet(maxwellFamily, dogMax);
        controller.addPet(newFamily, catCap);
        controller.bornChild(maxwellFamily);


        controller.displayAllFamilies().forEach(System.out::println);


    }
}
