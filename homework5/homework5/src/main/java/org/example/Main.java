package org.example;

public class Main {
    public static void main(String[] args) {

        Human mother = new Human("Jane", "Maxwell", 1977);
        Human father = new Human("John", "Maxwell", 1973);

        Pet pet = new Pet("dog", "Max", 2, 45, new String[]{"eating", "sleeping"});


        //creating maxwellFamily
        Family maxwellFamily = new Family(mother, father);

        Human child1 = new Human("Mike", "Maxwell", 2002,
                100,
                new String[][]{{"monday", "go shopping"}}, maxwellFamily
        );
        Human child2 = new Human("Barny", "Maxwell", 2003,
                100, new String[][]{{"monday", "go to course"}}, maxwellFamily
        );
        Human child3 = new Human("Chery", "Maxwell", 2005,
                87,
                new String[][]{{"monday", "do exercises"}}, maxwellFamily
        );

        //set the pet
        maxwellFamily.setPet(pet);

        //adding child1, child2 and child3
        maxwellFamily.addChild(child1);
        maxwellFamily.addChild(child2);
        maxwellFamily.addChild(child3);

        //deleting child by index -- Barny deleted
        maxwellFamily.deleteChild(1);
        System.out.println(maxwellFamily + " " + maxwellFamily.countFamily());

        //advanced complexity -- deleting child by reference itself -- Chery deleted
        maxwellFamily.deleteChild(child3);
        System.out.println(maxwellFamily + " " + maxwellFamily.countFamily());

        //checking equals method
        Family testFamily = new Family(mother, father);
        System.out.println(testFamily.equals(testFamily));

        System.out.println(child1.getFamily());


    }
}