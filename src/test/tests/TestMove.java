package tests;

import model.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMove {
    private Move eruption;
    private Move lavaplume;

    @BeforeEach
    public void beforeEachTest() {
        lavaplume = new Move("lava plume", 7, 100, 5);
        eruption = new Move("eruption", 20, 60, 2);
    }

    @Test
    void testGetMoveName() {
        assertEquals(lavaplume.getMoveName(), "lava plume");
    }

    @Test
    void testGetPower() {
        assertEquals(lavaplume.getPower(), 7);
    }

    @Test
    void testGetAccuracy() {
        assertEquals(lavaplume.getAccuracy(), 100);
    }

    @Test
    void testGetPP() {
        assertEquals(lavaplume.getPP(), 5);
    }

    @Test
    void testUseMove() {
        assertEquals(lavaplume.useMove(), 4);
    }

    @Test
    void testSetPP() {
        assertEquals(lavaplume.setPP(0),0);
    }
    @Test
    void testToString() {
        String str = lavaplume.getMoveName() + ", Power: " + lavaplume.getPower() + ", Accuracy: " + lavaplume.getAccuracy() + ", PP: " + lavaplume.getPP();
        assertEquals(lavaplume.toString(), str);
    }
}
