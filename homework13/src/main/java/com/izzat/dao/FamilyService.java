package com.izzat.dao;

import com.izzat.logging.MyLogger;
import com.izzat.model.Family;
import com.izzat.model.Human;
import com.izzat.abstracts.Pet;
import com.izzat.model.humans.Man;
import com.izzat.model.humans.Woman;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;

public class FamilyService {
    private final FamilyDao dao;

    public FamilyService(FamilyDao dao) {
        this.dao = dao;
    }

    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public void displayAllFamilies() {
        int[] count = {1};
        getAllFamilies().stream()
                .map(x -> (count[0]++) + "." + x)
                .forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return getAllFamilies().stream()
                .filter(x -> x.countFamily() > count)
                .toList();
    }

    public List<Family> getFamiliesLessThan(int count) {
        return getAllFamilies().stream()
                .filter(x -> x.countFamily() < count)
                .toList();
    }

    public int countFamiliesWithMemberNumber(int number) {
        int[] count = {0};
        getAllFamilies().forEach(x -> {
            if (x.countFamily() == number) {
                count[0]++;
            }
        });
        return count[0];
    }

    public Family createNewFamily(Woman mother, Man father) {
        Family family = new Family(mother, father);
        dao.saveFamily(family);
        return family;
    }

    public void deleteFamilyByIndex(int index) {
        if (dao.deleteFamily(index)) System.out.println("Deleted");
        else System.out.println("Family not exist");
    }

    public void deleteFamilyByReference(Family f) {
        if (dao.deleteFamily(f)) System.out.println("Deleted");
        else System.out.println("Family not exist");
    }

    public void saveData() {
        dao.save();
    }

    public void loadData() {
        try {
            dao.load();
        } catch (FileNotFoundException fne) {
            System.out.println("File not found");
            MyLogger.error("File not found");
        }

    }


    public Family bornChild(Family family) throws ParseException {
        Random ry = new Random();
        int y = ry.nextInt(20) + 1;
        Human child = genderSetter();
        family.addChild(child);
        child.setFamily(family);
        child.setName(randomName(child));
        child.setSurname(family.getFather().getSurname());
        if (family.getChildren().size() == 1 && family.getFather().getSurname().equals("Maxwell")) {
            child.setBirthDate("28/05/2002");
        } else {
            if (y >= 10) {
                child.setBirthDate("14/06/20" + y);
            } else {
                child.setBirthDate("14/06/200" + y);
            }
        }
        int averageIq = (family.getFather().getIq() + family.getMother().getIq()) / 2;
        child.setIq(averageIq);
        dao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Human child, Family family) {
        family.addChild(child);
        child.setFamily(family);
        dao.saveFamily(family);
        return family;
    }

    //implemented for define gender of child
    private Human genderSetter() {
        Random random = new Random();
        List<Human> gender = new ArrayList<>();
        gender.add(new Man());
        gender.add(new Woman());
        int i = random.nextInt(2);
        return gender.get(i);
    }

    //implemented for generate random name belong to gender
    private String randomName(Human child) {
        List<String> nameMan = List.of("Barny", "Bill", "Jeff", "Messi", "Neymar", "Ben", "Tom", "Toby", "Alex", "Max");
        List<String> nameWoman = List.of("Adaline", "Monica", "Alice", "Emmy", "Fiona", "Armas", "Elena", "Gal", "Natalie", "Scarlet");
        Random rd = new Random();
        int i = rd.nextInt(10);
        if (child instanceof Man) return nameMan.get(i);
        else return nameWoman.get(i);
    }

    public void deleteAllChildrenOlderThan(int age) {
        getAllFamilies().forEach(x -> {
            List<Human> list = x.getChildren();
            Iterator<Human> it = list.iterator();
            while (it.hasNext()) {
                int itAge = it.next().getAge();
                if (itAge > age) it.remove();
            }
            dao.saveFamily(x);
        });
    }

    public int count() {
        return getAllFamilies().size();
    }

    public Family getFamilyById(int id) {
        return dao.getFamilyByIndex(id);
    }

    public List<Pet> getPets(Family family) {
        List<Pet> pets = new ArrayList<>();
        getAllFamilies().forEach(x -> {
            if (x.equals(family)) {
                pets.addAll(family.getPet());
            }
        });
        return pets;
    }

    public void addPet(Family f, Pet pet) {
        getAllFamilies().forEach(x -> {
            f.setPet(pet);
            dao.saveFamily(x);
        });
    }


}
