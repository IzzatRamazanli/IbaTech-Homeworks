package org.example;

public class Main {
    public static void main(String[] args) {

        Human mother = new Human("Jane", "Maxwell", 1977);
        Human father = new Human("John", "Maxwell", 1973);

        Pet pet = new Pet("dog", "Max", 2, 45, new String[]{"eating", "sleeping"});

        Human child1 = new Human("Mike", "Maxwell",
                2002,
                100,
                new String[][]{{"monday", "go shopping"}}
        );

        Human child2 = new Human("Barny", "Maxwell", 2003,
                100, new String[][]{{"monday", "go to course"}}
        );


        //creating family
        Family family = new Family(mother, father);

        //set the pet
        family.setPet(pet);

        //adding child1
        family.addChild(child1);
        System.out.println("\n" + family);

        //adding child2
        family.addChild(child2);
        System.out.println("\n" + family);

        //counting members of family
        System.out.println("\n" + family.countFamily());

        //deleting child by index
        family.deleteChild(0);
        System.out.println("\n" + family);


    }
}