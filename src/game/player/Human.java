package game.player;

import game.Grid;
import main.Power4;

public final class Human extends Player{

    public Human(String name, int pawn) {
        super(name, pawn);
    }

    public final int play(Grid grid){
        System.out.println(this.getName() + ", choose a column ");

        int col = Power4.scanner.nextInt();
        return col;

    }

    public final String serialization(){
      return String.format("joueur %d est humain %s",this.getPawn(),this.getName());
    }
}
