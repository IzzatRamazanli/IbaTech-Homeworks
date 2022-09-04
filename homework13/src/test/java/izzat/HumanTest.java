package izzat;

import com.izzat.Human;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HumanTest {
    private final Human human = new Human("Judy", "Maxwell", "12/05/1977");

    HumanTest() throws ParseException {
    }

    @Test
    void testEquality() throws ParseException {
        Human human1 = new Human("Judy", "Maxwell", "12/05/1977");
        assertEquals(human, human1);
    }

    @Test
    void testNonEquality() throws ParseException {
        Human human1 = new Human("July", "Maxwell", "10/06/1985");
        assertNotEquals(human, human1);
    }
}