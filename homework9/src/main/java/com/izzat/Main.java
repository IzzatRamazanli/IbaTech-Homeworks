package com.izzat;

import com.izzat.abstracts.Pet;
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

        Set<String> habits = new HashSet<>();
        habits.add("eating");
        habits.add("sleeping");

        FamilyCollectionDao dao = new FamilyCollectionDao();

        Pet dogMax = new Dog("Max", 2, 45, habits);
        Pet catCap = new DomesticCat("Cap", 3, 34, habits);

        Man fatherJohn = new Man("John", "Maxwell", 1973, 98);

        Woman motherJane = new Woman("Jane", "Maxwell", 1977, 96);

        Family maxwellFamily;

        FamilyService service = new FamilyService(dao);
        System.out.println("Service");
        maxwellFamily = service.createNewFamily(motherJane, fatherJohn);
        service.addPet(0, dogMax);
        service.bornChild(maxwellFamily);
        System.out.println(service.countFamiliesWithMemberNumber(1));
        System.out.println(service.count());
        service.displayAllFamilies().forEach(System.out::println);



    }
}
