package game.player;

import game.Grid;

public abstract class Player {
    private String name;
    private int pawn;


    public Player(String name, int pawn) {
        this.setName(name);
        this.setPawn(pawn);
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPawn(int pawn) {
        this.pawn = pawn;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public int getPawn() {
        return this.pawn;
    }

    public abstract void play(Grid grid);

    /*public String choose(String str) {
       System.out.println(str);
       String name1, name2;
       Scanner reader = new Scanner(System.in);
       name1 = reader.nextLine();
       name2 = reader.nextLine();
       System.out.println(str + name1 + name2);

       return name2;
   }*/



}
