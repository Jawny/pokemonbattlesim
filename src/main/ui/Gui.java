//package ui;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.TextArea;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import model.*;
//
//import java.io.*;
//
//
//public class Gui extends Application implements EventHandler<ActionEvent> {
//    Stage window;
//    Scene pickPokemonScene;
//    Scene pickMoveScene;
//    Scene startMenu;
//
//    Button startProgram = new Button("Start Game");
//    Button charmanderButton = new Button("Charmander");
//    Button squirtleButton = new Button("Squirtle");
//    Button bulbasaurButton = new Button("Bulbasaur");
//    //Button cyndaquilButton = new Button("Cyndaquil");
//    Button moveOneButton;
//    Button moveTwoButton;
//    Button moveThreeButton;
//    Button moveFourButton;
//
//    TextArea updateInfo;
//
//    Input input = new Input();
//    BattleOrganizer organizer = new BattleOrganizer();
//    BattleManager manager = new BattleManager();
//    PokemonConstants constants = new PokemonConstants();
//    Pokemon computerPokemon = organizer.generatePokemon(); // randomize computer pokemon
//    Pokemon selectedPokemon;
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        window = primaryStage;
//        VBox startMenuLayout = new VBox();
//        startMenuLayout.getChildren().addAll(startProgram);
//        startMenu = new Scene(startMenuLayout, 200, 200);
//
//
//        createMoveButtons();
//        VBox pickPokemonLayout = new VBox();
//        pickPokemonLayout.getChildren().addAll(charmanderButton, squirtleButton, bulbasaurButton);
//        pickPokemonScene = new Scene(pickPokemonLayout, 200, 200);
//
//        VBox leftMenu = new VBox();
//        leftMenu.getChildren().addAll(moveOneButton, moveTwoButton, moveThreeButton, moveFourButton);
//        updateInfo = new TextArea();
//
//        BorderPane borderPane = new BorderPane();
//        borderPane.setLeft(leftMenu);
//        borderPane.setCenter(updateInfo);
//        pickMoveScene = new Scene(borderPane, 400, 200);
//
//        window.setScene(startMenu);
//        window.setTitle("Pokemon Battle Simulator");
//        window.show();
//    }
//
//    public void createMoveButtons() {
//        moveOneButton = new Button("move 1");//selectedPokemon.getMoveSet().getMoveOne().getMoveName());
//        moveOneButton.setOnAction(this);
//        moveTwoButton = new Button("move 2");//selectedPokemon.getMoveSet().getMoveTwo().getMoveName());
//        moveTwoButton.setOnAction(this);
//        moveThreeButton = new Button("move 3");//selectedPokemon.getMoveSet().getMoveThree().getMoveName());
//        moveThreeButton.setOnAction(this);
//        moveFourButton = new Button("move 4");//selectedPokemon.getMoveSet().getMoveFour().getMoveName());
//        moveFourButton.setOnAction(this);
//
//        startProgram.setOnAction(this);
//        charmanderButton.setOnAction(this);
//        squirtleButton.setOnAction(this);
//        bulbasaurButton.setOnAction(this);
//        //cyndaquilButton.setOnAction(this);
//    }
//
//
//    @Override
//    public void handle(ActionEvent event) {
//        convertSystemOutToTextField();
//        if (event.getSource() == startProgram) {
//            window.setScene(pickPokemonScene);
//        } else if (event.getSource() == charmanderButton) {
//            pickedCharmander();
//        } else if (event.getSource() == squirtleButton) {
//            pickedSquirtle();
//        } else if (event.getSource() == bulbasaurButton) {
//            pickedBulbasaur();
////        } else if (event.getSource() == cyndaquilButton) {
////            pickedCyndaquil();
//        } else if (event.getSource() == moveOneButton) {
//            moveOneHandle();
//        } else if (event.getSource() == moveTwoButton) {
//            moveTwoHandle();
//        } else if (event.getSource() == moveThreeButton) {
//            moveThreeHandle();
//        } else if (event.getSource() == moveFourButton) {
//            moveFourHandle();
//        }
//    }
//
//    public void convertSystemOutToTextField() {
//        PrintStream ps = new PrintStream(
//                new OutputStream() {
//                    public void write(int c) {
//                        updateInfo.setText(updateInfo.getText() + (char) c);
//                    }
//                }
//        );
//        System.setOut(ps);
//    }
//
//    public void pickedCharmander() {
//        selectedPokemon = constants.charmander;
//        window.setScene(pickMoveScene);
//        System.out.println("Your opponoent picked " + computerPokemon.getName());
//        selectedPokemon.getMoveSet().printMoveSet();
//    }
//
//    public void pickedSquirtle() {
//        selectedPokemon = constants.squirtle;
//        window.setScene(pickMoveScene);
//        System.out.println("Your opponoent picked " + computerPokemon.getName());
//        selectedPokemon.getMoveSet().printMoveSet();
//    }
//
//    public void pickedBulbasaur() {
//        selectedPokemon = constants.bulbasaur;
//        window.setScene(pickMoveScene);
//        System.out.println("Your opponoent picked " + computerPokemon.getName());
//        selectedPokemon.getMoveSet().printMoveSet();
//    }
//
//    public void pickedCyndaquil() {
//        selectedPokemon = constants.cyndaquil;
//        window.setScene(pickMoveScene);
//        System.out.println("Your opponoent picked " + computerPokemon.getName());
//        selectedPokemon.getMoveSet().printMoveSet();
//    }
//
//    public void moveOneHandle() {
//        Move cpuMove = organizer.generateMove(computerPokemon, organizer.randomizer());
//        manager.battlePokemon(selectedPokemon, selectedPokemon.getMoveSet().getMoveOne(), computerPokemon, cpuMove);
//        input.checkHealth(selectedPokemon, computerPokemon);
//        selectedPokemon.getMoveSet().printMoveSet();
//    }
//
//    public void moveTwoHandle() {
//        Move cpuMove = organizer.generateMove(computerPokemon, organizer.randomizer());
//        manager.battlePokemon(selectedPokemon, selectedPokemon.getMoveSet().getMoveTwo(), computerPokemon, cpuMove);
//        input.checkHealth(selectedPokemon, computerPokemon);
//        selectedPokemon.getMoveSet().printMoveSet();
//    }
//
//    public void moveThreeHandle() {
//        Move cpuMove = organizer.generateMove(computerPokemon, organizer.randomizer());
//        manager.battlePokemon(selectedPokemon, selectedPokemon.getMoveSet().getMoveThree(), computerPokemon, cpuMove);
//        input.checkHealth(selectedPokemon, computerPokemon);
//        selectedPokemon.getMoveSet().printMoveSet();
//    }
//
//    public void moveFourHandle() {
//        Move cpuMove = organizer.generateMove(computerPokemon, organizer.randomizer());
//        manager.battlePokemon(selectedPokemon, selectedPokemon.getMoveSet().getMoveFour(), computerPokemon, cpuMove);
//        input.checkHealth(selectedPokemon, computerPokemon);
//        selectedPokemon.getMoveSet().printMoveSet();
//    }
//
//}
//
//
//
