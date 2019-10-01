package model;

public class Move {
    private String moveName;
    private int power;
    private int accuracy;
    private int pp;

    public Move(String moveName, int power, int accuracy, int pp) {
        this.moveName = moveName;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
    }

    //EFFECTS gets Move name
    public String getMoveName() {
        return moveName;
    }

    //EFFECTS gets attack damage integer
    public int getPower() {
        return power;
    }

    //EFFECTS get accuracy
    public int getAccuracy() {
        return accuracy;
    }

    //EFFECTS get pp
    public int getPP() {
        return pp;
    }

    public int useMove() {
        return pp--;
    }

    public int setPP(int i) {
        return pp = i;
    }

    public String toString() {
        String str = moveName + ", Power: " + power + ", Accuracy: " + accuracy + ", PP: " + pp;
        return str;
    }
}
