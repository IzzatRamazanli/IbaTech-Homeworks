package com.izzat;

import com.izzat.abstracts.Pet;
import com.izzat.enums.DayOfWeek;
import com.izzat.enums.Species;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    Woman mother = new Woman("Jane", "Maxwell", 1977, 98);
    Man father = new Man("John", "Maxwell", 1973, 97);
    Family maxwellFamily = new Family(mother, father);
    Human child1;

    Human[] setChild() {
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
        Woman mother = new Woman("Jane", "Bowman", 1977, 98);
        Man father = new Man("John", "Bowman", 1973, 97);
        Family testFamily = new Family(mother, father);
        assertNotEquals(maxwellFamily, testFamily);
    }

    @Test
    void testEqualityWithChild() {
        setChild();
        Woman mother = new Woman("Jane", "Maxwell", 1977, 98);
        Human father = new Human("John", "Maxwell", 1973, 97);

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
        maxwellFamily.deleteChild(0);
        assertEquals(0, this.maxwellFamily.getChildren().length);
    }

    @Test
    void deletingChildByFalseIndex() {
        setChild();
        maxwellFamily.deleteChild(2);
        assertEquals(1, this.maxwellFamily.getChildren().length);
    }

    @Test
    void deletingChildByReference() {
        setChild();
        maxwellFamily.deleteChild(this.child1);
        assertEquals(0, this.maxwellFamily.getChildren().length);
    }

    @Test
    void deletingChildByFalseReference() {
        setChild();
        Human child2 = new Human("Tom", "Maxwell", 2003, 92,
                new String[][]{{DayOfWeek.MONDAY.name(), "go to course"}}, maxwellFamily
        );
        maxwellFamily.deleteChild(child2);
        assertEquals(1, this.maxwellFamily.getChildren().length);
    }

    @Test
    void testBornChild() {
        mother.bornChild(maxwellFamily, father);
        assertEquals(1, maxwellFamily.getChildren().length);
    }

}