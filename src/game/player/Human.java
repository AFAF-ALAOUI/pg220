import java.util.Scanner;
package game.player;
public class Human extends Player{


    public String play_human(){
        System.out.println("choose number of column");

        String number1;
        Scanner reader = new Scanner(System.in);
        number1 = reader.nextLine();
        //System.out.println(number1);
        return number1;
    }


}
