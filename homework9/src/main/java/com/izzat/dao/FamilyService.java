package com.izzat.dao;

import com.izzat.Family;
import com.izzat.Human;
import com.izzat.abstracts.Pet;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FamilyService {
    private final FamilyDao dao;

    public FamilyService(FamilyDao dao) {
        this.dao = dao;
    }

    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }

    public void displayAllFamilies() {
        dao.getAllFamilies().forEach(System.out::println);
    }

    public void getFamiliesBiggerThan(int count) {
        getAllFamilies().stream().filter(x -> x.countFamily() > count)
                .toList().forEach(System.out::println);

    }

    public void getFamiliesLessThan(int count) {
        getAllFamilies().stream().filter(x -> x.countFamily() < count)
                .toList().forEach(System.out::println);

    }

    public void countFamiliesWithMemberNumber() {
        //soranin isi
    }

    public void createFamily(Woman mother, Man father) {
        Family nf = new Family(mother, father);
        dao.saveFamily(nf);
    }

    public void deleteFamilyByIndex(int index) {
        if (dao.deleteFamily(index)) System.out.println("Deleted");
        else System.out.println("Family not exist");
    }


    public Family bornChild(Family family, Man father, Woman mother) {
        Human child = genderSetter();
        child.setFamily(family);
        child.setName(randomName(child));
        child.setSurname(father.getSurname());
        child.setYear(2002);
        child.getFamily().setMother(mother);
        child.getFamily().setFather(father);
        family.addChild(child);
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


}
