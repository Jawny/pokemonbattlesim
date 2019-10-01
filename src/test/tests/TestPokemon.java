package tests;

import model.PokemonConstants;
import model.MoveSet;
import model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPokemon {
    private PokemonConstants moveList;
    private MoveSet CHARMANDERMOVES;
    private MoveSet SQUIRTLEMOVES;
    private MoveSet BULBASAURMOVES;
    private MoveSet CYNDAQUILMOVES;

    private Pokemon CHARMANDER;
    private Pokemon SQUIRTLE;
    private Pokemon SHARONHE;
    private Pokemon CYNDAQUIL;

    @BeforeEach
    void beforeEachTest() {
        moveList = new PokemonConstants();
        CHARMANDERMOVES = new MoveSet(moveList.flamethrower, moveList.fireblast, moveList.ember, moveList.growl);
        SQUIRTLEMOVES = new MoveSet(moveList.watergun, moveList.hydropump, moveList.bubblebeam, moveList.growl);
        BULBASAURMOVES = new MoveSet(moveList.vinewhip, moveList.solarbeam, moveList.bulletseed, moveList.growl);
        CYNDAQUILMOVES = new MoveSet(moveList.lavaplume, moveList.eruption, moveList.swift, moveList.rollout);

        CHARMANDER = new Pokemon("charmander", CHARMANDERMOVES, 10, 100);
        SQUIRTLE = new Pokemon("squirtle", SQUIRTLEMOVES, 10, 100);
        SHARONHE = new Pokemon("bulbasaur", BULBASAURMOVES, 7, 150);
        CYNDAQUIL = new Pokemon("cyndaquil", CYNDAQUILMOVES, 2, 100);
    }

    @Test
    public void testGetName() {
        assertEquals(CHARMANDER.getName(), "charmander");
    }

    @Test
    public void testGetMoveSet() {
        assertEquals(CHARMANDER.getMoveSet(), CHARMANDERMOVES);
    }

    @Test
    public void testGetSpeed() {
        assertEquals(CHARMANDER.getSpeed(), 10);
    }

    @Test
    public void testGetHealth() {
        assertEquals(CHARMANDER.getHealth(), 100);
    }

    @Test
    public void testSetHealth() {
        assertEquals(CHARMANDER.getHealth(), 100);
        CHARMANDER.setHealth(2);
        assertEquals(CHARMANDER.getHealth(), 2);
    }
}
