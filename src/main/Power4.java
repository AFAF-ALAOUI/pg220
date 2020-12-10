package main;

import game.*;
import game.player.*;
import java.util.Scanner;


public class Power4 {

    private static Scanner scanner = new Scanner(System.in);


    private static String scannerconc() throws SetAliasException{

      String concurent = scanner.next();
      if ((!concurent.equals("human")) && (!concurent.equals("ia"))){
          throw new SetAliasException(concurent);
      }
      return concurent;
    }

    public static void main(String[] args) {
        try {
            System.out.println("joueur1?");
            String concurent1 = scannerconc();
            String name1 = scanner.next();

            System.out.println("joueur2?");
            String concurent2 = scannerconc();
            String name2 = scanner.next();

            if ((concurent1.equals("human")) && (concurent2.equals("human"))) {
                Game game = new Game(new Human(name1, 1), new Human(name2, 2));
                game.startGame();
            } else if ((concurent1.equals("human")) && (concurent2.equals("ia"))) {
                Game game = new Game(new Human(name1, 1), new ArtificialIntel(name2, 2));
                game.startGame();
            } else if ((concurent1.equals("ia")) && (concurent2.equals("human"))) {
                Game game = new Game(new ArtificialIntel(name1, 1), new Human(name2, 2));
                game.startGame();
            } else if ((concurent1.equals("ia")) && (concurent2.equals("ia"))) {
                Game game = new Game(new ArtificialIntel(name1, 1), new ArtificialIntel(name2, 2));
                game.startGame();
            }

        }catch(SetAliasException e){
            System.out.println(e);
        }
    }

    }
