package com.izzat.dao;

import com.izzat.Family;
import com.izzat.Human;
import com.izzat.abstracts.Pet;
import com.izzat.dao.implementation.FamilyCollectionDao;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;
import com.izzat.pets.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {
    private FamilyService service;
    private Man father;
    private Woman mother;
    private Family family;

    @BeforeEach
    void setUp() {
        FamilyDao dao = new FamilyCollectionDao();
        service = new FamilyService(dao);
        father = new Man("Father", "Father", 1992, 99);
        mother = new Woman("Mother", "Mother", 1992, 98);
    }

    @Test
    void creatingNewFamilyTest() {
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }

    @Test
    void deletingFamilyTest() {
        family = service.createNewFamily(mother, father);
        service.deleteFamilyByIndex(0);
        assertEquals(0, service.count());
    }

    @Test
    void bornChildTest() {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void adoptingChildTest() {
        Human child = new Man("Child", "Adopt", 2010, 99);
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        service.adoptChild(child, family);
        assertEquals(2, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void countFamiliesWithMemberNumberTest() {
        Human child = new Man("Child", "Adopt", 2010, 99);
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        service.adoptChild(child, family);
        assertEquals(1, service.countFamiliesWithMemberNumber(4));
    }

    @Test
    void deleteChildOlderThan() {
        Human child = new Man("Child", "Adopt", 2010, 99);
        family = service.createNewFamily(mother, father);
        service.adoptChild(child, family);
        service.deleteAllChildrenOlderThan(10);
        assertEquals(0, service.getFamilyById(0).getChildren().size());
    }

    @Test
    void getFamiliesLessThanFourTest() {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamiliesLessThan(4).size());
    }

    @Test
    void getFamiliesBiggerThanTwoTest() {
        family = service.createNewFamily(mother, father);
        service.bornChild(family);
        assertEquals(1, service.getFamiliesBiggerThan(2).size());
    }

    @Test
    void addingPetToFamilyTest() {
        Set<String> habits = new HashSet<>();
        habits.add("eating");
        habits.add("sleeping");
        Pet dogMax = new Dog("Max", 2, 45, habits);
        family = service.createNewFamily(mother, father);
        service.addPet(family, dogMax);
        assertEquals(1, service.getPets(family).size());
    }

    @Test
    void countingFamiliesTest() {
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }

    @Test
    void countingFamiliesWithSameMembers() {
        Family family1 = service.createNewFamily(mother, father);
        family = service.createNewFamily(mother, father);
        assertEquals(1, service.count());
    }


}