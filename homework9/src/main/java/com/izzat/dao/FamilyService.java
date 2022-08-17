package com.izzat.dao;

import com.izzat.Family;
import com.izzat.Human;
import com.izzat.abstracts.Pet;
import com.izzat.dao.implement.FamilyCollectionDao;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;

import java.time.LocalDate;
import java.util.*;

public class FamilyService {
    private final FamilyDao dao = new FamilyCollectionDao();

    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public List<Family> displayAllFamilies() {
        return dao.getAllFamilies();
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


    public Family bornChild(Family family) {
        Human child = genderSetter();
        family.addChild(child);
        child.setFamily(family);
        child.setName(randomName(child));
        child.setSurname(family.getFather().getSurname());
        child.setYear(2002);
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
        List<String> nameMan = List.of("Barny", "Bill", "Jeff", "Messi", "Neymar", "Ben", "Tom", "Tim", "Alex", "Max");
        List<String> nameWoman = List.of("Adaline", "Monica", "Alice", "Emmy", "Fiona", "Cindy", "Elena", "Gal", "Natalie", "Scarlet");
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
                int itAge = LocalDate.now().getYear() - it.next().getYear();
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

    public List<Pet> getPets(int index) {
        return dao.getFamilyByIndex(index).getPet().stream().toList();
    }

    public void addPet(Family f, Pet pet) {
        getAllFamilies().forEach(x -> {
            f.setPet(pet);
            dao.saveFamily(x);
        });
    }


}
