package izzat;

import com.izzat.model.Family;
import com.izzat.model.Human;
import com.izzat.humans.Man;
import com.izzat.humans.Woman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class FamilyTest {
    private Family maxwellFamily;
    private Human child1;
    private Woman mother;
    private Man father;

    @BeforeEach
    void set() throws ParseException {
        mother = new Woman("Jane", "Maxwell", "12/05/1985", 98);
        father = new Man("John", "Maxwell", "22/05/1987", 97);
        maxwellFamily = new Family(mother, father);
    }

    List<Human> setChild() throws ParseException {
        child1 = mother.bornChild(maxwellFamily, father);
        return maxwellFamily.getChildren();
    }


    @Test
    void testEqualityWithoutChild() throws ParseException {
        Woman mother = new Woman("Jane", "Maxwell", "12/05/1985", 98);
        Man father = new Man("John", "Maxwell", "22/05/1987", 97);
        Family testFamily = new Family(mother, father);
        assertEquals(maxwellFamily, testFamily);

    }

    @Test
    void testNonEqualityWithoutChild() throws ParseException {
        Woman mother = new Woman("Jane", "Bowman", "12/05/1977", 94);
        Man father = new Man("John", "Bowman", "12/05/1973", 99);
        Family testFamily = new Family(mother, father);
        assertNotEquals(maxwellFamily, testFamily);
    }

    @Test
    void testEqualityWithChild() throws ParseException {
        setChild();
        Woman mother = new Woman("Jane", "Maxwell", "12/05/1985", 98);
        Man father = new Man("John", "Maxwell", "22/05/1987", 97);

        Family testFamily = new Family(mother, father);
        testFamily.addChild(child1);
        assertEquals(maxwellFamily, testFamily);
    }

    @Test
    void testNonEqualityWithChild() throws ParseException {
        setChild();
        Woman mother = new Woman("Jane", "Maxwell", "12/05/1977", 98);
        Man father = new Man("John", "Maxwell", "22/05/1973", 97);

        Family testFamily = new Family(mother, father);
        mother.bornChild(testFamily, father);
        assertNotEquals(maxwellFamily, testFamily);
    }

    @Test
    void testCountOfFamilyMembers() throws ParseException {
        setChild();
        assertEquals(3, maxwellFamily.countFamily());
    }

    @Test
    void testDeletingChildByIndex() throws ParseException {
        setChild();
        maxwellFamily.deleteChildByIndex(0);
        assertEquals(0, this.maxwellFamily.getChildren().size());
    }

    @Test
    void deletingChildByFalseIndex() throws ParseException {
        setChild();
        maxwellFamily.deleteChildByIndex(2);
        assertEquals(1, this.maxwellFamily.getChildren().size());
    }

    @Test
    void deletingChildByReference() throws ParseException {
        setChild();
        maxwellFamily.deleteChildByReference(this.child1);
        assertEquals(0, this.maxwellFamily.getChildren().size());
    }

    @Test
    void deletingChildByFalseReference() throws ParseException {
        setChild();
        Human child2 = new Human("Name", "Surname", "12/05/2002", 98);
        maxwellFamily.deleteChildByReference(child2);
        assertEquals(1, this.maxwellFamily.getChildren().size());
    }

    @Test
    void testBornChild() throws ParseException {
        setChild();
        assertEquals(1, maxwellFamily.getChildren().size());
    }
}