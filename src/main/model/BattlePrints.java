package model;

public class BattlePrints {

    //EFFECTS: print user Pokemon turn
    public void printUserAttackTurn(Pokemon p, Move m) {
        System.out.println(p.getName() + " uses " + m.getMoveName());
        //return p.getName() + " uses " + m.getMoveName();
    }

    //EFFECTS: print user Pokemon check health
    public void printUserHealthTurn(Pokemon p) {
        System.out.println(p.getName() + " has " + p.getHealth() + " HP remaining!");
        //return p.getName() + " has " + p.getHealth() + " HP remaining!";
    }

    //EFFECTS: print cpu Pokemon turn
    public void printCpuAttackTurn(Pokemon p, Move m) {
        System.out.println("Enemy " + p.getName() + " uses " + m.getMoveName());
        //return "Enemy " + p.getName() + " uses " + m.getMoveName();
    }

    //EFFECTS: print cpu Pokemon check health
    public void printCpuHealthTurn(Pokemon p) {
        System.out.println("Enemy " + p.getName() + " has " + p.getHealth() + " HP remaining!");
        //return "Enemy " + p.getName() + " has " + p.getHealth() + " HP remaining!";
    }
}
