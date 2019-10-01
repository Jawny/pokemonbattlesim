package tests;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBattleManager {
    private PokemonConstants moveList;
    private PokemonList pokemonList;
    private BattleManager battleManager;
    private BattleOrganizer organizer;
    private Pokemon CHARMANDER;
    private Pokemon CYNDAQUIL;


    @BeforeEach
    void beforeEachTest() {
        moveList = new PokemonConstants();
        organizer = new BattleOrganizer();
        battleManager = new BattleManager();
        pokemonList = new PokemonList();
        MoveSet CHARMANDERMOVES = new MoveSet(moveList.flamethrower, moveList.fireblast, moveList.ember, moveList.growl);
        MoveSet CYNDAQUILMOVES = new MoveSet(moveList.lavaplume, moveList.eruption, moveList.swift, moveList.rollout);

        CHARMANDER = new Pokemon("charmander", CHARMANDERMOVES, 10, 100);
        CYNDAQUIL = new Pokemon("cyndaquil", CYNDAQUILMOVES, 2, 100);
        pokemonList.addPokemon(CHARMANDER);
        pokemonList.addPokemon(CYNDAQUIL);
    }

    @Test
    public void testBattleManagerUserFirst() {
        battleManager.battlePokemon(CHARMANDER, moveList.flamethrower, CYNDAQUIL, moveList.eruption);
        boolean t = battleManager.checkUserSpeed(CHARMANDER, CYNDAQUIL);
        assertTrue(t);
        boolean f = battleManager.checkUserSpeed(CYNDAQUIL, CHARMANDER);
        assertFalse(f);
    }

    @Test
    void testBattleManagerCpuFirst() {
        battleManager.battlePokemon(CYNDAQUIL, moveList.eruption, CHARMANDER, moveList.flamethrower);
        boolean f = battleManager.checkCpuSpeed(CHARMANDER, CYNDAQUIL);
        assertFalse(f);
        boolean t = battleManager.checkCpuSpeed(CYNDAQUIL, CHARMANDER);
        assertTrue(t);
    }

    @Test
    void testBattleManagerElse() {
        battleManager.battlePokemon(CHARMANDER, moveList.ember, CHARMANDER, moveList.flamethrower);
    }

    @Test
    public void testCheckUserSpeed() {
        boolean t = battleManager.checkUserSpeed(CHARMANDER, CYNDAQUIL);
        assertTrue(t);
        boolean f = battleManager.checkUserSpeed(CYNDAQUIL, CHARMANDER);
        assertFalse(f);
    }

    @Test
    public void testCheckCpuSpeed() {
        boolean f = battleManager.checkCpuSpeed(CHARMANDER, CYNDAQUIL);
        assertFalse(f);
        boolean t = battleManager.checkCpuSpeed(CYNDAQUIL, CHARMANDER);
        assertTrue(t);
    }

    @Test
    public void testCpuTakeDamageCalculation() {
        battleManager.cpuTakeDamageCalculation(CHARMANDER, moveList.flamethrower, CYNDAQUIL, moveList.eruption);
        assertEquals(CHARMANDER.getHealth(), 100);
        assertEquals(CYNDAQUIL.getHealth(), 93);

    }

    @Test
    public void testUserTakeDamageCalculation() {
        battleManager.userTakeDamageCalculation(CHARMANDER, moveList.flamethrower, CYNDAQUIL, moveList.eruption);
        assertEquals(CHARMANDER.getHealth(), 80);
        assertEquals(CYNDAQUIL.getHealth(), 100);
    }
}
