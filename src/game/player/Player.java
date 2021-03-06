package game.player;

import game.Grid;

public abstract class Player {
    private String name;
    private int pawn;


    public Player(String name, int pawn) {
        this.name = name;
        this.pawn = pawn;
    }


    //getters
    public String getName() {
        return this.name;
    }

    public int getPawn() {
        return this.pawn;
    }

    public abstract int play(Grid grid);

    public abstract String serialization();

}
