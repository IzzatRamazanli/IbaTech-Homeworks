package org.example;

public class Main {
    public static void main(String[] args) {

        Human mother = new Human("Jane", "Maxwell", 1977);
        Human father = new Human("John", "Maxwell", 1973);

        Pet pet = new Pet("dog", "Max", 2, 45, new String[]{"eating", "sleeping"});

        Human child1 = new Human("Mike", "Maxwell", 2002,
                100,
                new String[][]{{"monday", "go shopping"}}
        );
        Human child2 = new Human("Barny", "Maxwell", 2003,
                100, new String[][]{{"monday", "go to course"}}
        );
        Human child3 = new Human("Chery", "Maxwell", 2005,
                87,
                new String[][]{{"monday", "do exercises"}}
        );


        //creating family
        Family family = new Family(mother, father);

        //set the pet
        family.setPet(pet);

        //adding child1
        family.addChild(child1);
        System.out.println("\n" + family);

        //adding child2 and child3
        family.addChild(child2);
        family.addChild(child3);
        System.out.println(family.countFamily() + "\n" + family);

        //deleting child by index, deleting Mike
        family.deleteChild(0);
        System.out.println(family.countFamily() + "\n" + family);

        //advanced complexity -- deleting with reference, deleting Chery
        family.deleteChild(child3);
        System.out.println(family.countFamily() + "\n" + family);

        //equals method checking
        Family newFamily = new Family(mother, father);
        System.out.println(family.equals(newFamily));

    }
}
