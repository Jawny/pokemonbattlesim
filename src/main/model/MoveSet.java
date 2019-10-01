package model;

import java.util.ArrayList;

public class MoveSet {
    private ArrayList<Pokemon> pokemon;
    private Move moveOne;
    private Move moveTwo;
    private Move moveThree;
    private Move moveFour;

    public MoveSet(Move moveOne, Move moveTwo, Move moveThree, Move moveFour) {
        this.moveOne = moveOne;
        this.moveTwo = moveTwo;
        this.moveThree = moveThree;
        this.moveFour = moveFour;
    }


    public Move getMoveOne() {
        return moveOne;
    }

    public Move getMoveTwo() {
        return moveTwo;
    }

    public Move getMoveThree() {
        return moveThree;
    }

    public Move getMoveFour() {
        return moveFour;
    }
    //TODO this is my deliverable
//    public void addMoveSet(Pokemon p) {
//        if(!pokemon.contains(p)) {
//            pokemon.add(p);
//            p.setMoveSet(this);
//        }
//    }

    public void printMoveSet() {
        System.out.println(moveOne);
        System.out.println(moveTwo);
        System.out.println(moveThree);
        System.out.println(moveFour);
    }

    public boolean checkMove(String move) {
        if (move.equals(moveOne.getMoveName())) {
            return true;
        } else if (move.equals(moveTwo.getMoveName())) {
            return true;
        } else if (move.equals(moveThree.getMoveName())) {
            return true;
        } else if (move.equals(moveFour.getMoveName())) {
            return true;
        } else {
            return false;
        }
    }

    public Move getMove(String move) {
        if (move.equals(moveOne.getMoveName())) {
            return getMoveOne();
        } else if (move.equals(moveTwo.getMoveName())) {
            return getMoveTwo();
        } else if (move.equals(moveThree.getMoveName())) {
            return getMoveThree();
        } else if (move.equals(moveFour.getMoveName())) {
            return getMoveFour();
        }
        return getMoveOne(); //TODO change to exception later tho it shouldnt ever reach this
    }
}
