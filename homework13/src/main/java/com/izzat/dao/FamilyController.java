package com.izzat.dao;

import com.izzat.model.Family;
import com.izzat.model.Human;
import com.izzat.abstracts.Pet;
import com.izzat.exception.FamilyOverflowException;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;

import java.text.ParseException;
import java.util.List;

public class FamilyController {
    private final FamilyService service;

    public FamilyController(FamilyService service) {
        this.service = service;
    }

    public List<Family> getAllFamilies() {
        return service.getAllFamilies();
    }

    public void displayAllFamilies() {
        service.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return service.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count) {
        return service.getFamiliesLessThan(count);
    }

    public int countFamiliesWithMemberNumber(int number) {
        return service.countFamiliesWithMemberNumber(number);
    }

    public Family createNewFamily(Woman mother, Man father) {
        return service.createNewFamily(mother, father);
    }

    public void deleteFamilyByIndex(int index) {
        service.deleteFamilyByIndex(index);
    }

    public void deleteFamilyByReference(Family f) {
        service.deleteFamilyByReference(f);
    }

    public void saveData() {
        service.saveData();
    }

    public void loadData() {
        service.loadData();
    }

    public Family bornChild(Family family) throws ParseException {
        if (family.countFamily() <= 5) return service.bornChild(family);
        else throw new FamilyOverflowException("Family size is large");
    }

    public Family adoptChild(Human child, Family family) {
        if (family.countFamily() <= 5) return service.adoptChild(child, family);
        else throw new FamilyOverflowException("Family size is large");
    }

    public void deleteAllChildrenOlderThan(int age) {
        service.deleteAllChildrenOlderThan(age);
    }

    public int count() {
        return service.count();
    }

    public Family getFamilyById(int id) {
        return service.getFamilyById(id);
    }

    public List<Pet> getPets(Family f) {
        return service.getPets(f);
    }

    public void addPet(Family f, Pet pet) {
        service.addPet(f, pet);
    }


}
