package ui;

import model.*;
//import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        MusicStuff musicObject = new MusicStuff();
        musicObject.playMusic("Music/backgroundmusic.wav");

        //Application.launch(Gui.class, args);

        Pokemon userPokemon;
        BattleOrganizer organizer = new BattleOrganizer();
        Input input = new Input();
        organizer.printInstructions(); //print menu
        userPokemon = input.userPickPokemon();
        Pokemon computerPokemon = organizer.generatePokemon(); // randomize computer pokemon
        input.battlePokemon(userPokemon, computerPokemon);

    }

}




