package model;

import java.util.concurrent.ThreadLocalRandom;

public class BattleOrganizer {

    private BattleManager battleManager;
    private PokemonConstants constants;
    private PokemonList pokemonList;

    //EFFECTS: creates a new PokemonList, PokemonConstants, and calls createPokemon
    public BattleOrganizer() {
        battleManager = new BattleManager();
        pokemonList = new PokemonList();
        constants = new PokemonConstants();
        createPokemen();

    }

    // EFFECTS: CREATES POKEMEN
    public void createPokemen() {
        pokemonList.addPokemon(constants.charmander);
        pokemonList.addPokemon(constants.bulbasaur);
        pokemonList.addPokemon(constants.squirtle);
        pokemonList.addPokemon(constants.cyndaquil);
    }

    //EFFECTS: prints menu instructions
    public void printInstructions() {
        System.out.println("\nYou can choose a pokemon:\n");
        for (int i = 0; i < pokemonList.getPokemonList().size(); i++) {
            Pokemon p = getPokemonByIndex(i);
            System.out.println("Enter " + p.getName() + " to choose " + p.getName());
        }
    }

    public Pokemon getPokemonByIndex(int i) {
        return pokemonList.getPokemonList().get(i);
    }


    //EFFECTS: picks a pokemon at random from list of pokemon
    public Pokemon generatePokemon() {
        int i = ThreadLocalRandom.current().nextInt(0, pokemonList.getPokemonList().size() - 1);
        Pokemon p = getPokemonByIndex(i);
        System.out.println("Opponent has chosen " + p.getName());
        return p;
    }

    //EFFECTS: picks a move at random from list of moves available to pokemon
    public Move generateMove(Pokemon p, int i) {
        switch (i) {
            case 0:
                return p.getMoveSet().getMoveOne();
            case 1:
                return p.getMoveSet().getMoveTwo();
            case 2:
                return p.getMoveSet().getMoveThree();
            case 3:
                return p.getMoveSet().getMoveFour();
            default:
                System.out.println("Sorry, I didn't understand that command. Please try again.");
                printInstructions();
                break;
        }
        return null;
    }

    public int randomizer() {
        return ThreadLocalRandom.current().nextInt(0, 3);
    }

    //MODIFIES:
    //EFFECTS: battle pokemon based on move speed
    public void battlePokemon(Pokemon userP, Move userMove, Pokemon cpuP, Move cpuMove) {
        battleManager.battlePokemon(userP, userMove, cpuP, cpuMove);
    }


    //EFFECTS: check if pokemon exists
    public Pokemon getPokemonByName(String pokemonName) throws NotAPokemonException {
        for (Pokemon p : pokemonList.getPokemonList()) {
            if (pokemonName.equals(p.getName())) {
                System.out.println("You chose " + p.getName());
                return p;
            }
        }
        throw new NotAPokemonException();
    }

    //EFFECTS: chooses pokemon for user based on UI
    public Pokemon choosePokemon(String str) {
        Pokemon p = getPokemonByName(str);
        return p;
    }

    //EFFECTS: checks if there is a move that matches the string given and if pp > 0
    public Move getMoveByName(Pokemon p, String str) {
        String move = str;
        if (p.getMoveSet().checkMove(move)) {
            if (p.getMoveSet().getMove(move).getPP() > 0) {
                return p.getMoveSet().getMove(move);
            }
            return p.getMoveSet().getMoveOne();
        }
        return p.getMoveSet().getMoveOne();
    }
}
