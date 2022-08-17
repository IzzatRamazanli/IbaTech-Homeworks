package com.izzat.dao;

import com.izzat.Family;
import com.izzat.Human;
import com.izzat.abstracts.Pet;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;

import java.util.List;

public class FamilyController {
    private final FamilyService service = new FamilyService();

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

    public Family adoptChild(Human child, Family family) {
        return service.adoptChild(child, family);
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

    public void addPet(Family f, Pet pet) {
        service.addPet(f, pet);
    }


}
