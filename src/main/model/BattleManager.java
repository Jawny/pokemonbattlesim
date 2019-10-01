package model;

public class BattleManager {
    BattlePrints battlePrints;

    //MODIFIES:
    //EFFECTS: battle pokemon based on move speed
    public BattleManager() {
        battlePrints = new BattlePrints();
    }

    public void battlePokemon(Pokemon userP, Move userMove, Pokemon cpuP, Move cpuMove) {
        if (checkUserSpeed(userP, cpuP)) {
            cpuTakeDamageCalculation(userP, userMove, cpuP, cpuMove);
            userTakeDamageCalculation(userP, userMove, cpuP, cpuMove);
        } else if (checkCpuSpeed(userP, cpuP)) {
            userTakeDamageCalculation(userP, userMove, cpuP, cpuMove);
            cpuTakeDamageCalculation(userP, userMove, cpuP, cpuMove);
        } else {
            cpuTakeDamageCalculation(userP, userMove, cpuP, cpuMove);
            userTakeDamageCalculation(userP, userMove, cpuP, cpuMove);
        }
    }

    //EFFECTS: check user speed
    public boolean checkUserSpeed(Pokemon p1, Pokemon p2) {
        if (p1.getSpeed() > p2.getSpeed()) {
            return true;
        }
        return false;
    }

    //EFFECTS: check cpu speed
    public boolean checkCpuSpeed(Pokemon p1, Pokemon p2) {
        if (p2.getSpeed() > p1.getSpeed()) {
            return true;
        }
        return false;
    }

    public void cpuTakeDamageCalculation(Pokemon userP, Move userMove, Pokemon cpuP, Move cpuMove) {
        cpuP.setHealth(cpuP.getHealth() - userMove.getPower());
        printUserAttackTurn(userP, userMove); //print user attack turn
        printCpuHealthTurn(cpuP);  //print enemy health
        userMove.useMove();
    }

    public void userTakeDamageCalculation(Pokemon userP, Move userMove, Pokemon cpuP, Move cpuMove) {
        userP.setHealth(userP.getHealth() - cpuMove.getPower());
        printCpuAttackTurn(cpuP, cpuMove); //print computer attack turn
        printUserHealthTurn(userP);  //print user health
        cpuMove.useMove();
    }

    //EFFECTS: print user Pokemon turn
    public void printUserAttackTurn(Pokemon p, Move m) {
        battlePrints.printUserAttackTurn(p, m);
    }

    //EFFECTS: print user Pokemon check health
    public void printUserHealthTurn(Pokemon p) {
        battlePrints.printUserHealthTurn(p);
    }

    //EFFECTS: print cpu Pokemon turn
    public void printCpuAttackTurn(Pokemon p, Move m) {
        battlePrints.printCpuAttackTurn(p, m);
    }

    //EFFECTS: print cpu Pokemon check health
    public void printCpuHealthTurn(Pokemon p) {
        battlePrints.printCpuHealthTurn(p);
    }


}
