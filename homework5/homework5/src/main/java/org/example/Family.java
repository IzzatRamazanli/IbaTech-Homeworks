package org.example;

import java.util.Arrays;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    @Override
    public String toString() {
        if (getPet() == null && getChildren().length == 0) {
            return "Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    '}';
        } else if (getPet() != null && getChildren().length == 0) {
            return "Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    ", pet=" + pet +
                    '}';
        } else if (getPet() == null && getChildren().length != 0) {
            return "Family{" +
                    "mother=" + mother.getName() + " " + mother.getSurname() +
                    ", father=" + father.getName() + " " + father.getSurname() +
                    ", children=" + Arrays.toString(children) +
                    '}';
        }
        return "Family{" +
                "mother=" + mother.getName() + " " + mother.getSurname() +
                ", father=" + father.getName() + " " + father.getSurname() +
                ", children=" + Arrays.toString(children) +
                ", pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Family)) return false;
        if (obj == this) return true;

        Family family = (Family) obj;
        return mother.equals(family.mother) && father.equals(family.father) && children.equals(children);
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.pet = getPet();
        Family family = new Family();
        father.setFamily(family);
        mother.setFamily(family);
    }

    public Family() {
        this.children = new Human[0];
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child) {
        Human[] children = new Human[getChildren().length + 1];
        for (int i = 0; i < getChildren().length; i++) {
            children[i] = getChildren()[i];
        }
        children[children.length - 1] = child;
        setChildren(children);
    }

    public void deleteChild(int index) {
        Human[] children = new Human[getChildren().length - 1];
        for (int i = 0, j = 0; i < getChildren().length; i++) {
            if (i == index) continue;
            children[j++] = getChildren()[i];
        }
        setChildren(children);
    }

    public int countFamily() {
        return 2 + getChildren().length;
    }


    public void describePet() {
        String slyLevel = "";
        if (getPet().getTrickLevel() >= 50) {
            slyLevel = "he is very sly";
        } else {
            slyLevel = "almost not sly";
        }
        System.out.println("I have a " + getPet().getSpecies() + ", he is " + getPet().getAge() + " years old, " + slyLevel);
    }

    public void greetPet() {
        System.out.println("Hello," + getPet().getNickName());
    }

    public void feedPet(boolean feedTime) {
        if (feedTime) {
            System.out.println("Hm... I will feed " + getPet().getNickName());
        } else {
            System.out.println("I think " + getPet().getNickName() + " is not hungry.");
        }
    }
}
