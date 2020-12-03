package main;

import game.*;
import game.player.*;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Power4 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("player1?");
        String name1 = scanner.nextLine();
        System.out.println("player2?");
        String name2 = scanner.nextLine();
        FileGame fileGame = new FileGame();
        fileGame.charger("infos.txt","hallo");

        Game game = new Game(new Human(name1,1),new ArtificialIntel(name2,2));
        game.startGame(game);
    }

}
