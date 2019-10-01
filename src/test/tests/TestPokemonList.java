package tests;

import model.PokemonConstants;
import model.MoveSet;
import model.Pokemon;
import model.PokemonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPokemonList {

    private PokemonConstants moveList;
    private PokemonList pokemonList;
    private Pokemon CHARMANDER;
    private Pokemon CYNDAQUIL;


    @BeforeEach
    void beforeEachTest() {
        pokemonList = new PokemonList();
        moveList = new PokemonConstants();

        MoveSet CHARMANDERMOVES = new MoveSet(moveList.flamethrower, moveList.fireblast, moveList.ember, moveList.growl);
        MoveSet CYNDAQUILMOVES = new MoveSet(moveList.lavaplume, moveList.eruption, moveList.swift, moveList.rollout);

        CHARMANDER = new Pokemon("charmander", CHARMANDERMOVES, 10, 100);
        CYNDAQUIL = new Pokemon("cyndaquil", CYNDAQUILMOVES, 2, 100);
    }

    @Test
    void testAddPokemonEmptyList() {
        pokemonList.addPokemon(CHARMANDER);
        assertEquals(pokemonList.getPokemonList().size(), 1);
    }

    @Test
    void testAddPokemonNonEmpty() {
        pokemonList.addPokemon(CHARMANDER);
        pokemonList.addPokemon(CYNDAQUIL);
        assertEquals(pokemonList.getPokemonList().size(), 2);
    }

    @Test
    void testAddDuplicatePokemon() {
        pokemonList.addPokemon(CHARMANDER);
        pokemonList.addPokemon(CHARMANDER);
        assertEquals(pokemonList.getPokemonList().size(), 2);
    }

    @Test
    void testGetPokemonList() {
        assertEquals(pokemonList.getPokemonList(), pokemonList);
    }
}
