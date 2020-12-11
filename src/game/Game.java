package game;
import game.player.*;


public class Game {

    private final Grid grid;
    private final Rules rules;

    private Player[] players = new Player[2] ;
    private Display display = new Display();

    private FileGame fileGame = new FileGame();

    public Game(Player player1, Player player2){
        this.players[0] = player1;
        this.players[1] = player2;
        this.grid = new Grid();
        this.rules = new Rules();
    }

    public FileGame getFileGame(){
      return this.fileGame;
    }


    public void startGame(){
        int col;
        int [] manches ={0,0}; //initialisation de la table des parties gagnees par les deux joueurs
        boolean endgame = false;
        int j =0;

        this.fileGame.save("log.txt",this.players[0].serialization(),true);

        this.fileGame.save("log.txt",this.players[1].serialization(),true);
        this.fileGame.save("log.txt","Manche commence ",true);

        while(endgame==false) {
            for (int i = 0; i < 2; i++) { //(i+manches[0]+manches[1])%2 to altern the  player starting first
                j=(i+manches[0]+manches[1])%2;
                this.display.display(grid);
                try {
                col = this.players[j].play(grid);
                fileGame.save("log.txt",this.players[j].getName()+" joue "+col,true);
                    if (this.grid.playColumn(this.players[j].getPawn(), col)) {
                        if (rules.search4(grid)) {
                            manches[j]++;
                            this.display.display(grid);
                            this.fileGame.save("log.txt", players[j].getName() + " gagne", true);
                            this.fileGame.save("log.txt", "Score " + manches[0] + "-" + manches[1]+"\n", true);
                            if (manches[j] == 3) {
                                endgame = true;
                                break;
                            }

                            System.out.println(players[j].getName() + " gagne.Nouvelle manche");
                            this.fileGame.save("log.txt", "Manche commence ", true);
                            this.grid.initGrid(this.grid.getHeight(), this.grid.getLength());

                            break;
                        }
                    } else {
                        if (grid.fullGrid()) {
                            System.out.println("Match nul");
                            this.fileGame.save("log.txt", "Draw", true);
                            endgame = true;
                            break;
                        }
                    }
                } catch(HumanPlayIntException e){
                    System.out.println(e);
                    this.fileGame.save("log.txt", e.serialization(), true);
                    i--; //Player will try again
                } catch(HumanPlayStrException e){
                    System.out.println(e);
                    this.fileGame.save("log.txt", e.serialization(), true);
                    i--; //Player will try again
                } catch(FullcolException e){
                    System.out.println(e);
                    this.fileGame.save("log.txt", e.serialization(), true);
                    i--; //Player will try again
                }
            }
        }
        System.out.println("Fin de partie");
        this.fileGame.save("log.txt","Fin de partie",true);
    }


}
