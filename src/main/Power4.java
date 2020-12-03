package main;

import game.*;
import game.player.*;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Power4 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("player1?");
        String concurent1 = scanner.next();
        String name1 = scanner.next();

        System.out.println("player2?");
        String concurent2 = scanner.next();
        String name2 = scanner.next();

        System.out.println(concurent2);
        System.out.println(concurent1);
        if ((concurent1.equals("humain")) && (concurent2.equals("humain")))
        {
            Game game = new Game(new Human(name1, 1), new Human(name2, 2));
            System.out.println("humain vs humain");
            game.startGame(game);
         }
        if ((concurent1.equals("humain")) && (concurent2.equals("ia")))
        {
            Game game = new Game(new Human(name1, 1), new ArtificialIntel(name2, 2));
            game.startGame(game);
        }
        if ((concurent1.equals("ia")) && (concurent2.equals("humain")))
        {
            Game game = new Game(new ArtificialIntel(name1, 1), new Human(name2, 2));
            game.startGame(game);
        }
        if ((concurent1.equals("ia")) && (concurent2.equals("ia")))
        {
            Game game = new Game(new ArtificialIntel(name1, 1), new ArtificialIntel(name2, 2));
            game.startGame(game);
        }
        else
        {
            System.out.println("error");
        }


        //int col = game.players[1].play(game.grid);
    }

}
