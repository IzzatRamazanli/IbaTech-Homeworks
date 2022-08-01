package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private final Human human = new Human("Judy", "Maxwell", 1978);

    @Test
    void testEquality() {
        Human human1 = new Human("Judy", "Maxwell", 1978);
        assertEquals(human, human1);
    }

    @Test
    void testNonEquality() {
        Human human1 = new Human("July", "Maxwell", 1978);
        assertNotEquals(human, human1);
    }

}