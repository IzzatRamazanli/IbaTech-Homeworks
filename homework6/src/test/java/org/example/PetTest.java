package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    private final Pet pet = new Pet(Species.DOG, "Max");

    @Test
    void testEquality() {
        Pet pet1 = new Pet(Species.DOG, "Max");
        assertEquals(pet, pet1);
    }

    @Test
    void testNonEquality(){
        Pet pet1 = new Pet(Species.DOG,"Hermosa");
        assertNotEquals(pet,pet1);
    }

}