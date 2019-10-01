package model;

import java.util.ArrayList;

public class PokemonList {
    private ArrayList<Pokemon> pokemonList;

    public PokemonList() {
        pokemonList = new ArrayList<Pokemon>();
    }

    public void addPokemon(Pokemon p) {
        pokemonList.add(p);
    }


    public ArrayList<Pokemon> getPokemonList() {
        ArrayList<Pokemon> temp = new ArrayList<Pokemon>(pokemonList);
        return temp;
    }

}
