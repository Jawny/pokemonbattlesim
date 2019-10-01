package model;

public class PokemonConstants {

    public Move flamethrower = new Move("flamethrower", 7,90, 15);
    public Move fireblast = new Move("fireblast", 14, 50,5);
    public Move ember = new Move("ember", 2, 100,20);
    public Move growl = new Move("growl",0,100,20);
    //squirtle's moves
    public Move watergun = new Move("watergun", 7,90,15);
    public Move hydropump = new Move("hydropump", 14, 50,5);
    public Move bubblebeam = new Move("bubblebeam", 2, 100,20);
    //bulbasaur's moves
    public Move vinewhip = new Move("vinewhip", 7,90,15);
    public Move solarbeam = new Move("solarbeam", 14, 50,5);
    public Move bulletseed = new Move("bulletseed", 2, 100,20);
    //cyndaquil's moves
    public Move lavaplume = new Move("lava plume", 7, 100,5);
    public Move eruption = new Move("eruption", 20, 60,2);
    public Move swift = new Move("swift", 5, 100,10);
    public Move rollout = new Move("rollout", 10, 90,10);


    public MoveSet charmanderMoves = new MoveSet(flamethrower, fireblast, ember, growl);
    public MoveSet squirtleMoves = new MoveSet(watergun, hydropump, bubblebeam, growl);
    public MoveSet bulbasaurMoves = new MoveSet(vinewhip, solarbeam, bulletseed, growl);
    public MoveSet cyndaquilMoves = new MoveSet(lavaplume, eruption, swift, rollout);

    public Pokemon charmander = new Pokemon("charmander", charmanderMoves, 10, 100);
    public Pokemon squirtle = new Pokemon("squirtle", squirtleMoves, 10, 100);
    public Pokemon bulbasaur = new Pokemon("bulbasaur", bulbasaurMoves, 7, 150);
    public Pokemon cyndaquil = new Pokemon("cyndaquil", cyndaquilMoves, 2, 100);
}
