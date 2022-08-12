package com.izzat;

import com.izzat.abstracts.Pet;
import com.izzat.enums.DayOfWeek;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;
import com.izzat.pets.Dog;
import com.izzat.pets.DomesticCat;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<String> habits = new HashSet<>();
        habits.add("eating");
        habits.add("sleeping");


        Pet dogMax = new Dog("Max", 2, 45, habits);
        Pet catCap = new DomesticCat("Cap", 3, 34, habits);
        Set<Pet> petSet = new HashSet<>();
        petSet.add(dogMax);
        petSet.add(catCap);

        Man fatherJohn = new Man("John", "Maxwell", 1973, 98);

        Map<DayOfWeek, String> scheduleMan = new HashMap<>();
        scheduleMan.put(DayOfWeek.MONDAY, "repair car");
        fatherJohn.setSchedule(scheduleMan);

        Woman motherJane = new Woman("Jane", "Maxwell", 1977, 96);
        Map<DayOfWeek, String> scheduleWoman = new HashMap<>();
        scheduleWoman.put(DayOfWeek.MONDAY, "do shopping");
        motherJane.setSchedule(scheduleWoman);

        Family maxwellFamily = new Family(motherJane, fatherJohn);

        maxwellFamily.setPet(petSet);

        //advanced complexity implemented
        Human child = motherJane.bornChild(maxwellFamily, fatherJohn);
        //maxwellFamily.deleteChildByReference(child);

        System.out.println(maxwellFamily);


    }
}
