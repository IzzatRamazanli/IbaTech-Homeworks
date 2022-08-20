package com.izzat;

import com.izzat.abstracts.Pet;

import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pet = new HashSet<>();
        father.setFamily(this);
        mother.setFamily(this);
    }

    public void addChild(Human child) {
        if (child != null) {
            children.add(child);
            setChildren(children);
            child.setFamily(this);
        }
    }

    public void deleteChildByIndex(int index) {

        if (index < getChildren().size()) {
            for (int i = 0; i < getChildren().size(); i++) {
                if (i == index) getChildren().remove(i);
            }
        }

    }

    public void deleteChildByReference(Human child) {

        Iterator<Human> it = children.iterator();
        while (it.hasNext()) {
            if (it.next().equals(child)) it.remove();
        }
    }

    public int countFamily() {
        return 2 + getChildren().size();
    }

    public void describePet() {
        String slyLevel = "";
        if (getPetFromSet().getTrickLevel() >= 50) {
            slyLevel = "he is very sly";
        } else {
            slyLevel = "almost not sly";
        }
        System.out.println("I have a " + getPetFromSet().getSpecies() + ", he is " + getPetFromSet().getAge() + " years old, " + slyLevel);
    }

    public void greetPet() {
        System.out.println("Hello," + getPetFromSet().getNickName());
    }

    public void feedPet(boolean feedTime) {
        if (feedTime) {
            System.out.println("Hm... I will feed " + getPetFromSet().getNickName());
        } else {
            System.out.println("I think " + getPetFromSet().getNickName() + " is not hungry.");
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

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Pet p) {
        this.pet.add(p);
    }

    private Pet getPetFromSet() {
        Pet p;
        Iterator<Pet> it = pet.iterator();
        p = it.next();
        return p;
    }

    @Override
    public String toString() {
        if (getPet() == null && getChildren().size() == 0) {

            return "Family{mother=%s %s,father=%s %s}"
                    .formatted(mother.getName(), mother.getSurname(), father.getName(), father.getSurname());
        } else if (getPet() != null && getChildren().size() == 0) {

            return "Family{mother=%s %s,father=%s %s,\npet=%s}"
                    .formatted(mother.getName(), mother.getSurname(), father.getName(), father.getSurname(), pet);
        } else if (getPet() == null && getChildren().size() != 0) {

            return "Family{mother=%s %s,father=%s %s,\nchildren=%s}"
                    .formatted(mother.getName(), mother.getSurname(), father.getName(), father.getSurname(), children);
        }
        return "Family{mother=%s %s,father=%s %s,\nchildren=%s,\npet=%s}"
                .formatted(mother.getName(), mother.getSurname(), father.getName(), father.getSurname(), children, pet);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Family)) return false;
        if (obj == this) return true;

        Family family = (Family) obj;
        return mother.equals(family.mother) && father.equals(family.father) &&
                children.equals(family.getChildren());
    }
    @Override
    protected void finalize() {
        System.out.println(this + " object collected by Garbage Collector");
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMother(), getFather(), getChildren());
    }
}
