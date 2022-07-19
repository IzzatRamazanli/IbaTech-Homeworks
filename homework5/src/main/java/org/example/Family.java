package org.example;

import java.util.Arrays;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    //Advanced complexity static and non-static initialisation
    static {
        System.out.println(Family.class.getName().substring(12) + " class loaded");
    }

    {
        System.out.println("New object is created: " + this.getClass().getTypeName().substring(12));
    }

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
        return mother.equals(family.mother) && father.equals(family.father);
    }

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.pet = getPet();
        father.setFamily(this);
        mother.setFamily(this);
    }

    public void addChild(Human child) {
        Human[] children = new Human[getChildren().length + 1];
        for (int i = 0; i < getChildren().length; i++) {
            children[i] = getChildren()[i];
        }
        children[children.length - 1] = child;
        setChildren(children);
        child.setFamily(this);
    }

    public void deleteChild(int index) {

        Human[] children = new Human[getChildren().length - 1];
        if (children.length == 0) {
            children = new Human[0];
        } else {
            for (int i = 0, j = 0; i < getChildren().length; i++) {
                if (i == index) continue;
                children[j++] = getChildren()[i];
            }
        }
        setChildren(children);
    }

    public int countFamily() {
        return 2 + getChildren().length;
    }

    //Advanced complexity implementation -- deleting child
    public void deleteChild(Human child) {
        Human[] children = new Human[getChildren().length - 1];
        for (int i = 0, j = 0; i < getChildren().length; i++) {
            if (getChildren()[i].getName().equals(child.getName())) continue;
            children[j++] = getChildren()[i];
        }
        setChildren(children);
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


}
