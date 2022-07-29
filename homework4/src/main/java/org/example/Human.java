package org.example;


public class Human {
    String name;
    String surname;
    int year;
    Human mother;
    Human father;
    int iq;
    Pet pet;
    String[][] schedule;


    //overriding toString
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", mother=" + mother.name + " " + mother.surname +
                ", father=" + father.name + " " + father.surname +
                ", iq=" + iq +
                ", pet=" + pet +
                '}';
    }

    public Human() {
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
    }
    
    public Human(String name, String surname, int year, Human mother, Human father, int iq, Pet pet, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
        if (iq < 1 || iq > 100) {
            System.out.println("IQ must be between 1-100");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Redefine IQ in 1-100 please: ");
            iq = scanner.nextInt();
            this.iq = iq;
        }else{
            this.iq = iq;
        }
        this.pet = pet;
        this.schedule = schedule;
    }

    public void greetPet() {
        System.out.println("Hello," + pet.nickName);
    }

    public void describePet() {
        String slyLevel = "";
        if (pet.trickLevel >= 50) {
            slyLevel = "he is very sly";
        } else {
            slyLevel = "almost not sly";
        }
        System.out.println("I have a " + pet.species + ", he is " + pet.age + " years old, " + slyLevel);
    }

    public void feedPet(boolean feedTime) {
        if (feedTime) {
            System.out.println("Hm... I will feed " + pet.nickName);
        } else {
            System.out.println("I think " + pet.nickName + " is not hungry.");
        }
    }
}
