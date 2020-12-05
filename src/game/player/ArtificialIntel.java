package game.player;

import game.Grid;

public final class ArtificialIntel extends Player {

    public ArtificialIntel(String name, int pawn) {
        super(name, pawn);
    }

    @Override
    public final int play(Grid grid) {
        int col = (int) (Math.random() * (grid.getLength() - 1) + 1);
        System.out.println(this.getName() + " plays " + col);
        return col;

    }

    public final String serialization(){
      return String.format("joueur %d est ia %s",this.getPawn(),this.getName());
    }
}
