package com.izzat;

import com.izzat.abstracts.Pet;
import com.izzat.dao.FamilyController;
import com.izzat.dao.FamilyDao;
import com.izzat.dao.FamilyService;
import com.izzat.dao.implementation.FamilyCollectionDao;
import com.izzat.logging.MyLogger;
import com.izzat.model.humans.Man;
import com.izzat.model.humans.Woman;
import com.izzat.model.Family;
import com.izzat.model.Human;
import com.izzat.model.pets.Dog;
import com.izzat.model.pets.DomesticCat;

import java.text.ParseException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class FamilyApplication {

    private static final FamilyController CONTROLLER = configuration();

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
                case "1" -> {
                    fillWithTestData();
                    System.out.println("Data saved successfully!");
                }
                case "2" -> {
                    CONTROLLER.displayAllFamilies();
                    System.out.println("Data displayed successfully!");
                }
                case "3" -> CONTROLLER.getFamiliesBiggerThan(requestNumber()).forEach(System.out::println);
                case "4" -> CONTROLLER.getFamiliesLessThan(requestNumber()).forEach(System.out::println);
                case "5" ->
                        System.out.printf("Result: %d\n", CONTROLLER.countFamiliesWithMemberNumber(requestNumber()));
                case "6" -> creatingFamily();
                case "7" -> deletingFamily();
                case "8" -> editFamily();
                case "9" -> CONTROLLER.deleteAllChildrenOlderThan(requestNumber());
                case "10" -> saveData();
                case "11" -> loadData();
                default -> System.out.println("Command not exist, try again please!");
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
                - 10. Save data to file
                - 11. Load data from file
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
        CONTROLLER.bornChild(maxwellFamily);
        CONTROLLER.bornChild(newFamily);
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
        CONTROLLER.deleteFamilyByReference(getFamilyById());
    }

    private void editFamily() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Available commands:\n- 1. Give birth to a baby\n- 2. Adopt a child\n- 3. Return to main menu");
        System.out.print("\nEnter command to run: ");
        String command = sc.nextLine();
        switch (command) {
            case "1":
                try {
                    CONTROLLER.bornChild(getFamilyById());
                } catch (NullPointerException npe) {
                    System.out.println("Null data");
                } catch (IndexOutOfBoundsException iob) {
                    System.out.println("Family not exist");
                }
                break;
            case "2":
                try {
                    CONTROLLER.adoptChild(adoptChild(), getFamilyById());
                } catch (NullPointerException npe) {
                    System.out.println("Null data");
                    MyLogger.error(npe.getMessage());
                } catch (IndexOutOfBoundsException iob) {
                    System.out.println("Family not exist");
                    MyLogger.error(iob.getMessage());
                }
                break;
            case "3":
                start();
            default:
                System.out.println("Entered command not exist, try again!");
        }
    }

    private Family getFamilyById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Family ID: ");
        int id = sc.nextInt();
        return CONTROLLER.getFamilyById(id);
    }

    private Human adoptChild() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter child's gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter child's name: ");
        String name = sc.nextLine();
        System.out.print("Enter child's surname: ");
        String surname = sc.nextLine();
        System.out.print("Enter child's birthdate (dd/mm/yyyy): ");
        String birthDate = sc.nextLine();
        System.out.print("Enter child's IQ: ");
        int iq = sc.nextInt();
        Human childAdopt = new Human(name, surname, birthDate, iq);
        childAdopt.setGender(gender);
        return childAdopt;
    }

    private int requestNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter: ");
        int num;
        try {
            num = sc.nextInt();
            return num;
        } catch (InputMismatchException e) {
            System.out.println("False input, try again!");
            MyLogger.error(e.getMessage());
            requestNumber();
        }
        return 0;
    }

    public void saveData() {
        CONTROLLER.saveData();
    }

    public void loadData() {
        CONTROLLER.loadData();
    }


    private static FamilyController configuration() {
        FamilyDao dao = new FamilyCollectionDao();
        FamilyService service = new FamilyService(dao);
        return new FamilyController(service);
    }
}
