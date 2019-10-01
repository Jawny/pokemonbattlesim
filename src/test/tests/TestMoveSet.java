package tests;

import model.Move;
import model.MoveSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMoveSet {
    private Move flamethrower;
    private Move fireblast;
    private Move ember;
    private Move growl;
    private MoveSet moveSet;

    @BeforeEach
    void beforeEachTest() {
        flamethrower = new Move("flamethrower", 7, 90, 15);
        fireblast = new Move("fireblast", 14, 50, 5);
        ember = new Move("ember", 2, 100, 20);
        growl = new Move("growl", 0, 100, 20);

        moveSet = new MoveSet(flamethrower, fireblast, ember, growl);
    }

    @Test
    void testGetMoves() {
        assertEquals(moveSet.getMoveOne(), flamethrower);
        assertEquals(moveSet.getMoveTwo(), fireblast);
        assertEquals(moveSet.getMoveThree(), ember);
        assertEquals(moveSet.getMoveFour(), growl);
    }

    @Test
    void testPrintMoveSet() {
        moveSet.printMoveSet();
    }

    @Test
    void testCheckMove() {
        String str = "flamethrower";
        String str1 = "fireblast";
        String str2 = "ember";
        String str3 = "growl";
        String str4 = "wrong String";
        assertTrue(moveSet.checkMove(str));
        assertTrue(moveSet.checkMove(str1));
        assertTrue(moveSet.checkMove(str2));
        assertTrue(moveSet.checkMove(str3));
        assertFalse(moveSet.checkMove(str4));
    }

    @Test
    void testGetMove() {
        String str = "flamethrower";
        String str1 = "fireblast";
        String str2 = "ember";
        String str3 = "growl";
        String str4 = "wrong String";
        assertEquals(moveSet.getMove(str), flamethrower);
        assertEquals(moveSet.getMove(str1), fireblast);
        assertEquals(moveSet.getMove(str2), ember);
        assertEquals(moveSet.getMove(str3), growl);
        assertEquals(moveSet.getMove(str4), flamethrower);
    }
}
