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
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyFamilyApp {

    private static final FamilyController CONTROLLER = configuration();
    //private Scanner IN = new Scanner(System.in);
//    private static final Man fatherJohn;
//    private static final Woman motherJane;
//    private static final Man father;
//    private static final Woman mother;
//
//    static {
//        try {
//            fatherJohn = new Man("John", "Maxwell", "12/12/1985", 98);
//            motherJane = new Woman("Jane", "Maxwell", "04/07/1995", 96);
//            father = new Man("Father", "Father", "10/12/1983", 99);
//            mother = new Woman("Mother", "Mother", "15/02/1993", 98);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public boolean start() throws ParseException {
        commands();
        System.out.print("Enter command ro run: ");
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        if (command.equalsIgnoreCase("exit")) {
            System.out.println("Application closed...");
            return false;
        } else {
            switch (command) {
                case "1":
                    fillWithTestData();
                    System.out.println("Data saved successfully!");
                    break;
                case "2":
                    CONTROLLER.displayAllFamilies();
                    System.out.println("Data displayed successfully!");
                    break;
                case "3":
                    System.out.print("Enter number: ");
                    int bigger = in.nextInt();
                    CONTROLLER.getFamiliesBiggerThan(bigger).forEach(System.out::println);
                    break;
                case "4":
                    System.out.print("Enter number: ");
                    int less = in.nextInt();
                    CONTROLLER.getFamiliesLessThan(less).forEach(System.out::println);
                    break;
                case "5":
                    System.out.print("Enter number: ");
                    int members = in.nextInt();
                    System.out.printf("Result: %d\n", CONTROLLER.countFamiliesWithMemberNumber(members));
                    break;
                case "6":
                    creatingFamily();
                    break;
                case "7":
                    deletingFamily();
                    break;
                default:
                    System.out.println("Command not exist, try again please!");

            }
        }
        return true;
    }

    private void commands() {
        System.out.println("""
                \n- 1. Fill with test data (create several families and save them in the database)
                - 2. Display the entire list of families (displays a list of all families with indexation starting with 1)
                - 3. Display a list of families where the number of people is greater than the specified number
                - 4. Display a list of families where the number of people is less than the specified number
                - 5. Calculate the number of families where the number of members is
                - 6. Create a new family
                - 7. Delete a family by its index in the general list
                - 8. Edit a family by its index in the general list
                  - 1. Give birth to a baby
                  - 2. Adopt a child
                  - 3. Return to main menu \s
                - 9. Remove all children over the age of majority
                - Exit
                """

        );
    }

    private void fillWithTestData() throws ParseException {
        Man fatherJohn = new Man("John", "Maxwell", "12/12/1985", 98);
        Woman motherJane = new Woman("Jane", "Maxwell", "04/07/1995", 96);

        Man father = new Man("Father", "Father", "10/12/1983", 99);
        Woman mother = new Woman("Mother", "Mother", "15/02/1993", 98);

        Family maxwellFamily = CONTROLLER.createNewFamily(motherJane, fatherJohn);
        Family newFamily = CONTROLLER.createNewFamily(mother, father);

        Set<String> habits = new HashSet<>();
        habits.add("eating");
        habits.add("sleeping");

        Pet dogMax = new Dog("Max", 2, 45, habits);
        Pet catCap = new DomesticCat("Cap", 3, 34, habits);
        CONTROLLER.addPet(maxwellFamily, dogMax);
        CONTROLLER.addPet(newFamily, catCap);
    }

    private Family creatingFamily() throws ParseException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter mother's name: ");
        String mName = sc.nextLine();
        System.out.print("Enter mother's surname: ");
        String mSurname = sc.nextLine();
        System.out.print("Enter mother's birth year : ");
        String mBirthYear = sc.nextLine();
        System.out.print("Enter mother's birth month : ");
        String mBirthMonth = sc.nextLine();
        System.out.print("Enter mother's birthday : ");
        String mBirthDay = sc.nextLine();
        String mBirthDate = mBirthDay + "/" + mBirthMonth + "/" + mBirthYear;
        System.out.print("Enter mother's iq : ");
        int mIq = sc.nextInt();
        Woman mother = new Woman(mName, mSurname, mBirthDate, mIq);

        sc = new Scanner(System.in);
        System.out.print("Enter father's name: ");
        String fName = sc.nextLine();
        System.out.print("Enter father's surname: ");
        String fSurname = sc.nextLine();
        System.out.print("Enter father's birth year : ");
        String fBirthYear = sc.nextLine();
        System.out.print("Enter father's birth month : ");
        String fBirthMonth = sc.nextLine();
        System.out.print("Enter father's birthday : ");
        String fBirthDay = sc.nextLine();
        String fBirthDate = fBirthDay + "/" + fBirthMonth + "/" + fBirthYear;
        System.out.print("Enter father's iq : ");
        int fIq = sc.nextInt();
        Man father = new Man(fName, fSurname, fBirthDate, fIq);

        Family f = CONTROLLER.createNewFamily(mother, father);
        return f;

    }

    private void deletingFamily() {
        System.out.println("Family count in database:" + CONTROLLER.count());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID for deletion: ");
        int index = sc.nextInt();
        try {
            CONTROLLER.deleteFamilyByIndex(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Entered ID doesn't exist in database!");
            deletingFamily();
        }

    }


    private static FamilyController configuration() {
        FamilyDao dao = new FamilyCollectionDao();
        FamilyService service = new FamilyService(dao);
        return new FamilyController(service);
    }
}
