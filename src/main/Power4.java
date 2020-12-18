package main;

import game.*;
import game.player.*;
import java.util.Scanner;


public class Power4 {

    private static Scanner scanner = new Scanner(System.in);


    private static String scannerconc() throws SetAliasException{

      String concurent = scanner.next();
      if ((!concurent.equals("humain")) && (!concurent.equals("ia"))){
          throw new SetAliasException(concurent);
      }
      return concurent;
    }

    public static void main(String[] args) {
        boolean file = false;
        String[] concurent = {null,null};
        String[] name = {null,null};
        String[] exception = {null,null};
        Game game = null;


        for (int i=0; i < 2; i++){
          do {
              try {
                  System.out.println("joueur"+(i+1)+"?");
                  concurent[i] = scannerconc();
              } catch (SetAliasException e) {
                  if(e.getString().equals("sortir")){
                    System.exit(0);
                  }
                  System.out.println(e);
                  exception[i]= e.serialization(i+1);
              }
          } while(concurent[i] == null);
          name[i] = scanner.next();
          if(name[i].equals("sortir")){
            System.exit(0);
          }
        }



       if ((concurent[0].equals("humain")) && (concurent[1].equals("humain"))) {
            game = new Game(new Human(name[0], 1), new Human(name[1], 2));
       } else if ((concurent[0].equals("humain")) && (concurent[1].equals("ia"))) {
            game = new Game(new Human(name[0], 1), new ArtificialIntel(name[1], 2));
       } else if ((concurent[0].equals("ia")) && (concurent[1].equals("humain"))) {
            game = new Game(new ArtificialIntel(name[0], 1), new Human(name[1], 2));
       } else if ((concurent[0].equals("ia")) && (concurent[1].equals("ia"))) {
            game = new Game(new ArtificialIntel(name[0], 1), new ArtificialIntel(name[1], 2));
      }
      for (int i=0; i < 2; i++){
        if (exception[i] != null){
          game.getFileGame().save("log.txt",exception[i],file);
          file = true;
        }
      }

      if (file == false){
        game.getFileGame().save("log.txt","",file);
      }
      game.startGame();
    }

}
