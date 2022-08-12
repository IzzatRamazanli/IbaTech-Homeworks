package com.izzat.abstracts;

import com.izzat.pets.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    private Pet pet;
    private String[] habits;

    @BeforeEach
    void set() {
        habits = new String[]{"eating", "sleeping"};
        pet = new Dog("Max", 2, 45, habits);
    }

    @Test
    void testEquality() {
        Pet pet1 = new Dog("Max", 2, 45, habits);
        assertEquals(pet, pet1);
    }

    @Test
    void testNonEquality() {
        Pet pet1 = new Dog("Hermosa", 2, 45, habits);
        assertNotEquals(pet, pet1);
    }
}