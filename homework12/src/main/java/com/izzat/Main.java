package com.izzat;

import com.izzat.abstracts.Pet;
import com.izzat.dao.FamilyController;
import com.izzat.dao.FamilyDao;
import com.izzat.dao.FamilyService;
import com.izzat.dao.implementation.FamilyCollectionDao;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;
import com.izzat.pets.Dog;
import com.izzat.pets.DomesticCat;

import java.text.ParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        FamilyController controller = config();

        Set<String> habits = new HashSet<>();
        habits.add("eating");
        habits.add("sleeping");

        Pet dogMax = new Dog("Max", 2, 45, habits);
        Pet catCap = new DomesticCat("Cap", 3, 34, habits);

        Man fatherJohn = new Man("John", "Maxwell", "12/12/1985", 98);
        Woman motherJane = new Woman("Jane", "Maxwell", "04/07/1995", 96);

        Man father = new Man("Father", "Father","10/12/1983" , 99);
        Woman mother = new Woman("Mother", "Mother", "15/02/1993", 98);

        Human childAdopt = new Man("Child", "Adopt", "11/04/2015", 99);

        Family maxwellFamily = controller.createNewFamily(motherJane, fatherJohn);
        Family newFamily = controller.createNewFamily(mother, father);

        controller.addPet(maxwellFamily, dogMax);
        controller.addPet(newFamily, catCap);
        controller.bornChild(maxwellFamily);
        controller.bornChild(maxwellFamily);
        controller.bornChild(newFamily);
        controller.bornChild(newFamily);
        controller.displayAllFamilies();

        controller.adoptChild(childAdopt, maxwellFamily);

        System.out.println("Describing age of father John");
        fatherJohn.describeAge();

        System.out.println("\ncount families with 5 member: " + controller.countFamiliesWithMemberNumber(5));

        System.out.println("\nbigger than 3");
        controller.getFamiliesBiggerThan(3).forEach(System.out::println);

        System.out.println("\nless than 3");
        controller.getFamiliesLessThan(4).forEach(System.out::println);

        System.out.println("\npets of maxwell family");
        controller.getPets(maxwellFamily).forEach(System.out::println);

        System.out.println("\ndeleting children older than 15");
        controller.deleteAllChildrenOlderThan(15);

        System.out.println("\nget family by id :\n" + controller.getFamilyById(0));

        System.out.println("\ndelete family by index");
        controller.deleteFamilyByIndex(1);

        System.out.println("\ndisplaying all families from database");
        controller.displayAllFamilies();
        System.out.println(controller.count());
    }

    private static FamilyController config() {
        FamilyDao dao = new FamilyCollectionDao();
        FamilyService service = new FamilyService(dao);
        return new FamilyController(service);
    }
}
