package com.izzat.model;

import com.izzat.abstracts.Pet;

import java.io.Serializable;
import java.util.*;

public class Family implements Serializable {
    private static final long serialVersionUID = 1L;
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
        return prettyFormat();
    }

    private String prettyFormat() {
        if (getPet() == null && getChildren().size() == 0) {
            return "family:\n%5s mother: %s%5s father: %s"
                    .formatted("", mother, "", father);
        } else if (getPet() != null && getChildren().size() == 0) {
            return "family:\n%5s mother: %s%5s father: %s\npets: %s"
                    .formatted("", mother, "", father, pet);
        } else if (getPet() == null && getChildren().size() != 0) {
            return "family:\n%5s mother: %s%5s father: %s children: \n%s\n"
                    .formatted("", mother, "", father, getPrettyChildren());
        }
        return "family:\n%5s mother: %s%5s father: %s children: \n%s\n pets: %s"
                .formatted("", mother, "", father, getPrettyChildren(), pet);
    }

    private String getPrettyChildren() {
        final StringBuilder[] format = {new StringBuilder("")};
        getChildren().forEach(x -> {
            format[0] = format[0].append("%10s : {name=%s, surname=%s, birthdate=%s, iq=%d, schedule=%s}\n"
                    .formatted(x.getGender(), x.getName(), x.getSurname(), x.getBirthDate(), x.getIq(), x.getSchedule()));
        });
        return format[0].toString();
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
