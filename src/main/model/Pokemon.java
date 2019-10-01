package model;


public class Pokemon {
    //    private MoveSet m;
    private String name;
    private MoveSet moves;
    private int speed;
    private int health;

    public Pokemon(String name, MoveSet moves, int speed, int health) {
        this.name = name;
        this.moves = moves;
        this.speed = speed;
        this.health = health;
    }

    //EFFECTS: get name
    public String getName() {
        return name;
    }

    //EFFECTS: get moveset
    public MoveSet getMoveSet() {
        return moves;
    }

    //EFFECTS: get speed
    public int getSpeed() {
        return speed;
    }

    //EFFECTS: get health
    public int getHealth() {
        return health;
    }

    //MODIFIES: this
    //EFFECTS:set health to health
    public void setHealth(int health) {
        this.health = health;
    }

}


