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
    Human child1 = new Human("Mike", "Maxwell", 2003, 92,
            new String[][]{{DayOfWeek.MONDAY.name(), "go to course"}}, maxwellFamily
    );

    Human[] setChild() {
        maxwellFamily.addChild(child1);
        return maxwellFamily.getChildren();
    }


    @Test
    void testEqualityWithoutChild() {
        Human mother = new Human("Jane", "Maxwell", 1977);
        Human father = new Human("John", "Maxwell", 1973);
        Family testFamily = new Family(mother, father);
        assertEquals(maxwellFamily, testFamily);

    }

    @Test
    void testNonEqualityWithoutChild() {
        Woman mother = new Woman("Jane", "Bowman", 1977,98);
        Man father = new Man("John", "Bowman", 1973,97);
        Family testFamily = new Family(mother, father);
        assertNotEquals(maxwellFamily, testFamily);
    }

    @Test
    void testEqualityWithChild() {
        setChild();
        Human mother = new Human("Jane", "Maxwell", 1977);
        Human father = new Human("John", "Maxwell", 1973);

        Family testFamily = new Family(mother, father);
        Human childTest = new Human("Mike", "Maxwell", 2003, 92,
                new String[][]{{DayOfWeek.MONDAY.name(), "go to course"}}, testFamily
        );
        testFamily.addChild(childTest);
        assertEquals(maxwellFamily, testFamily);
    }

    @Test
    void testNonEqualityWithChild() {
        setChild();
        Human mother = new Human("Jane", "Maxwell", 1977);
        Human father = new Human("John", "Maxwell", 1973);

        Family testFamily = new Family(mother, father);
        Human childTest = new Human("Barny", "Maxwell", 2003, 92,
                new String[][]{{DayOfWeek.MONDAY.name(), "go to course"}}, testFamily
        );
        testFamily.addChild(childTest);
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

}