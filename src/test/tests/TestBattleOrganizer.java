package tests;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBattleOrganizer {
    private PokemonConstants moveList;
    private PokemonList pokemonList;
    private BattleManager battleManager;
    private BattleOrganizer organizer;
    private Pokemon CHARMANDER;
    private Pokemon SQUIRTLE;
    private Pokemon BULBASAUR;
    private Pokemon CYNDAQUIL;

    @BeforeEach
    void beforeEachTest() {
        moveList = new PokemonConstants();
        organizer = new BattleOrganizer();
        battleManager = new BattleManager();
        pokemonList = new PokemonList();
        MoveSet CHARMANDERMOVES = new MoveSet(moveList.flamethrower, moveList.fireblast, moveList.ember, moveList.growl);
        MoveSet SQUIRTLEMOVES = new MoveSet(moveList.watergun, moveList.hydropump, moveList.bubblebeam, moveList.growl);
        MoveSet BULBASAURMOVES = new MoveSet(moveList.vinewhip, moveList.solarbeam, moveList.bulletseed, moveList.growl);
        MoveSet CYNDAQUILMOVES = new MoveSet(moveList.lavaplume, moveList.eruption, moveList.swift, moveList.rollout);

        CHARMANDER = new Pokemon("charmander", CHARMANDERMOVES, 10, 100);
        SQUIRTLE = new Pokemon("squirtle", SQUIRTLEMOVES, 10, 100);
        BULBASAUR = new Pokemon("bulbasaur", BULBASAURMOVES, 7, 150);
        CYNDAQUIL = new Pokemon("cyndaquil", CYNDAQUILMOVES, 2, 100);
        pokemonList.addPokemon(CHARMANDER);
        pokemonList.addPokemon(SQUIRTLE);
        pokemonList.addPokemon(BULBASAUR);
        pokemonList.addPokemon(CYNDAQUIL);
    }

    @Test
    public void testGetPokemonByName() {
        Assertions.assertThrows(NotAPokemonException.class, () -> {
            organizer.getPokemonByName("charrmander");
        });

        Assertions.assertThrows(NotAPokemonException.class, () -> {
            organizer.getPokemonByName("fsdfs");
        });

        try {
            Pokemon p = organizer.getPokemonByName("charmander");
            assertEquals(p, CHARMANDER);
        } catch (NotAPokemonException e) {
            fail();
        }

        try {
            Pokemon p = organizer.getPokemonByName("djfhksdf");
            fail("should've failed");
        } catch (NotAPokemonException e) {
            fail();
        }
    }

    @Test
    public void testPrintInstructions() {
        organizer.printInstructions();
    }


    @Test
    public void testGetPokemonByIndex() {
        assertEquals(organizer.getPokemonByIndex(0), CHARMANDER);
        assertEquals(organizer.getPokemonByIndex(2), BULBASAUR);
        assertEquals(organizer.getPokemonByIndex(3), CYNDAQUIL);
    }

    @Test
    public void testChoosePokemon() {
        assertEquals(organizer.choosePokemon("charmander"), CHARMANDER);
        assertEquals(organizer.choosePokemon("Charmander"), CHARMANDER);
        assertEquals(organizer.choosePokemon("CHARMANDER"), CHARMANDER);
    }

    //TODO FINISH THIS TEST
    @Test
    public void testGeneratePokemon() {
        organizer.generatePokemon();
    }

    //TODO FINISH THIS TEST
    @Test
    public void testGenerateMove() {
        assertEquals(organizer.generateMove(CHARMANDER, 0), CHARMANDER.getMoveSet().getMoveOne());
        assertEquals(organizer.generateMove(CHARMANDER, 1), CHARMANDER.getMoveSet().getMoveTwo());
        assertEquals(organizer.generateMove(CHARMANDER, 2), CHARMANDER.getMoveSet().getMoveThree());
        assertEquals(organizer.generateMove(CHARMANDER, 3), CHARMANDER.getMoveSet().getMoveFour());
        assertEquals(organizer.generateMove(CHARMANDER, 4), null);
    }

    @Test
    public void testBattlePokemon() {
        organizer.battlePokemon(CHARMANDER, moveList.flamethrower, CYNDAQUIL, moveList.rollout);
    }

    @Test
    public void testRandomizer() {
        int i = organizer.randomizer();
        assertEquals(organizer.randomizer(), i);
    }

    @Test
    public void testGetMoveByName() {
        moveList.flamethrower.setPP(1);
        Move m = organizer.getMoveByName(CHARMANDER, "flamethrower");
        assertEquals(m, moveList.flamethrower);


        moveList.flamethrower.setPP(10);
        moveList.ember.setPP(0);
        Move m1 = organizer.getMoveByName(CHARMANDER, "ember");
        assertEquals(m1, moveList.flamethrower);


        moveList.flamethrower.setPP(-1);
        moveList.ember.setPP(10);
        Move m2 = organizer.getMoveByName(CHARMANDER, "flamethrower");
        assertEquals(m2, moveList.flamethrower);

        moveList.flamethrower.setPP(10);
        Move m3 = organizer.getMoveByName(CHARMANDER, "dfkjhdsf");
        assertEquals(m3, moveList.flamethrower);


    }

}
