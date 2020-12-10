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
        boolean alias =true;
        String concurent1 = null;
        String name1 = null;
        String concurent2 = null;
        String name2 = null;
    do {
        try {
            System.out.println("joueur1?");
            concurent1 = scannerconc();
            name1 = scanner.next();
        } catch (SetAliasException e) {
            System.out.println(e);
        }
    } while(concurent1 == null);
        do {
            try {
                System.out.println("joueur2?");
                concurent2 = scannerconc();
                name2 = scanner.next();
            } catch (SetAliasException e) {
                System.out.println(e);
            }
        }while(concurent2 == null);

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
    }

    }
