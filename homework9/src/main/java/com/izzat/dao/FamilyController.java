package com.izzat.dao;

import com.izzat.Family;
import com.izzat.abstracts.Pet;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;

import java.util.List;

public class FamilyController {
    private final FamilyService service;

    public FamilyController(FamilyService service) {
        this.service = service;
    }

    public List<Family> getAllFamilies() {
        return service.getAllFamilies();
    }

    public List<Family> displayAllFamilies() {
        return service.displayAllFamilies();
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

    public Family bornChild(Family family) {
        return service.bornChild(family);
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

    public List<Pet> getPets(int index) {
        return service.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        service.addPet(index, pet);
    }


}
