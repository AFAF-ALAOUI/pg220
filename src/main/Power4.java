package main;

import game.*;
import game.player.*;


import java.util.Scanner;


public class Power4 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();


        Game game = new Game(new Human(name1,1),new ArtificialIntel(name2,2));

        //game.grid.display(game.grid);
        System.out.println(name1);
    }

}
