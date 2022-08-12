package com.izzat;

import com.izzat.enums.DayOfWeek;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    private Family maxwellFamily;
    private Human child1;
    private Woman mother;
    private Man father;

    @BeforeEach
    void set() {
        mother = new Woman("Jane", "Maxwell", 1977, 98);
        father = new Man("John", "Maxwell", 1973, 97);
        maxwellFamily = new Family(mother, father);
    }

    List<Human> setChild() {
        child1 = mother.bornChild(maxwellFamily, father);
        return maxwellFamily.getChildren();
    }


    @Test
    void testEqualityWithoutChild() {
        Woman mother = new Woman("Jane", "Maxwell", 1977, 98);
        Man father = new Man("John", "Maxwell", 1973, 97);
        Family testFamily = new Family(mother, father);
        assertEquals(maxwellFamily, testFamily);

    }

    @Test
    void testNonEqualityWithoutChild() {
        Woman mother = new Woman("Jane", "Bowman", 1977, 94);
        Man father = new Man("John", "Bowman", 1973, 99);
        Family testFamily = new Family(mother, father);
        assertNotEquals(maxwellFamily, testFamily);
    }

    @Test
    void testEqualityWithChild() {
        setChild();
        Woman mother = new Woman("Jane", "Maxwell", 1977, 98);
        Man father = new Man("John", "Maxwell", 1973, 97);

        Family testFamily = new Family(mother, father);
        testFamily.addChild(child1);
        assertEquals(maxwellFamily, testFamily);
    }

    @Test
    void testNonEqualityWithChild() {
        setChild();
        Woman mother = new Woman("Jane", "Maxwell", 1977, 98);
        Man father = new Man("John", "Maxwell", 1973, 97);

        Family testFamily = new Family(mother, father);
        mother.bornChild(testFamily, father);
        assertNotEquals(maxwellFamily, testFamily);
    }

    @Test
    void testCountOfFamilyMembers() {
        setChild();
        assertEquals(3, maxwellFamily.countFamily());
    }

    @Test
    void testDeletingChildByIndex() {
        setChild();
        maxwellFamily.deleteChildByIndex(0);
        assertEquals(0, this.maxwellFamily.getChildren().size());
    }

    @Test
    void deletingChildByFalseIndex() {
        setChild();
        maxwellFamily.deleteChildByIndex(2);
        assertEquals(1, this.maxwellFamily.getChildren().size());
    }

    @Test
    void deletingChildByReference() {
        setChild();
        maxwellFamily.deleteChildByReference(this.child1);
        assertEquals(0, this.maxwellFamily.getChildren().size());
    }

    @Test
    void deletingChildByFalseReference() {
        setChild();
        Human child2 = new Human("Name", "Surname", 2002, 98);
        maxwellFamily.deleteChildByReference(child2);
        assertEquals(1, this.maxwellFamily.getChildren().size());
    }

    @Test
    void testBornChild() {
        setChild();
        assertEquals(1, maxwellFamily.getChildren().size());
    }
}