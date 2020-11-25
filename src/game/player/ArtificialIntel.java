package game.player;

import game.Grid;

public final class ArtificialIntel extends Player {

    public ArtificialIntel(String name,int pawn){
        super(name,pawn);
    }

    @Override
    public final void play(Grid grid) {

    }

    /*public static void play_ai(int Max){
        int nombreAleatoire;
        nombreAleatoire =(int)(Math.random() * (Max + 1));
        System.out.println("ai choose " + nombreAleatoire);
    }*/
}
