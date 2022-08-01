package org.example;

public class Main {
    public static void main(String[] args) {

        Pet dog = new Pet(Species.DOG, "Max", 2, 45, new String[]{"eating", "sleeping"});
        Human mother = new Human("Jane", "Maxwell", 1977);
        Human father = new Human("John", "Maxwell", 1973);

        Family maxwellFamily = new Family(mother, father);

        Human child1 = new Human("Mike", "Maxwell", 2003, 92,
                new String[][]{{DayOfWeek.MONDAY.name(), "go to course"}}, maxwellFamily);

        maxwellFamily.addChild(child1);
        maxwellFamily.setPet(dog);

        System.out.println(maxwellFamily);

        System.out.println(" -- -- -- -- -- -- -- -- --");

        //humanGarbageCollector();

    }

    public static void humanGarbageCollector() {
        for (int i = 0; i < 1000000; i++) {
            Human human = new Human();
        }
    }


}