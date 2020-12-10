package game.player;

import game.HumanPlayStrException;
import game.HumanPlayIntException;
import game.FullcolException;
import game.Grid;
import java.util.Scanner;

public final class Human extends Player{

    private Scanner sc = new Scanner(System.in);

    public Human(String name, int pawn) {
        super(name, pawn);
    }

    public final int play(Grid grid) throws HumanPlayIntException, HumanPlayStrException {
        int length = grid.getLength();
        System.out.println(this.getName() + ", choose a column ");
        int col;

        //check if the input is an integer
        if(this.sc.hasNextInt()==false){
            String str = this.sc.nextLine();
            throw new HumanPlayStrException(str);
        }
        else{
            col = this.sc.nextInt();
            if(1>col || col>length){ //check if the number is between [1,length]
                throw new HumanPlayIntException(col);
            }
            if(grid.fullColumn(col)){
                throw new FullcolException(col);
            }
        }
        return col;
    }



    public final String serialization(){
      return String.format("joueur %d est humain %s",this.getPawn(),this.getName());
    }
}
