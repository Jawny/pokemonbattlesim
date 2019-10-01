package ui;

import model.*;

import java.util.Scanner;

public class Input {
    private Scanner input;
    public BattleOrganizer organizer;
    private Pokemon userPokemon;
    private boolean loop = true;
    private boolean battling = true;
    private Move userMove;

    public Input() {
        input = new Scanner(System.in);
        organizer = new BattleOrganizer();
    }

    //EFFECTS: gets user input
    public String getUserInputString() {
        String str = "";
        if (input.hasNext()) {
            str = input.nextLine();
            str = makePrettyString(str);
        }
        return str;
    }

    //EFFECTS: removes white space and quotation marks around s
    public String makePrettyString(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\"|\'", "");
        return s;
    }

    //EFFECTS: start battle
    public Pokemon userPickPokemon() {
        while (loop) {
            try {
                userPokemon = organizer.choosePokemon(getUserInputString()); // let user choose main.model
                loop = false;
            } catch (NotAPokemonException e) {
                System.out.println("That is not a valid pokemon");
                continue;
            }
        }
        return userPokemon;
    }

    //EFFECTS: checks if pokemon health is 0 if so end program
    public void checkHealth(Pokemon user, Pokemon computer) {
        if (user.getHealth() <= 0) {
            System.out.println("You Lose!");
            battling = false;
        } else if (computer.getHealth() <= 0) {
            System.out.println("You Win!");
            battling = false;
        }
    }

    public void battlePokemon(Pokemon userPokemon, Pokemon computerPokemon) {
        while (battling) {
            System.out.println("Choose a move!");
            userPokemon.getMoveSet().printMoveSet(); //prints moves out

            userMove = organizer.getMoveByName(userPokemon, getUserInputString());

            Move computerMove = organizer.generateMove(computerPokemon, organizer.randomizer()); //generate cpu move
            organizer.battlePokemon(userPokemon, userMove, computerPokemon, computerMove); //hit each other
            checkHealth(userPokemon, computerPokemon); //check if health < 0O
        }
    }
}

