package game;
import game.player.Player;


public class Game {

    private final Grid grid;
    private final Rules rules;

    private Player[] players = new Player[2] ;
    private Display display = new Display();

    public Game(Player player1, Player player2){
        this.players[0] = player1;
        this.players[1] = player2;
        this.grid = new Grid();
        this.rules = new Rules();
    }




    public void startGame(){
        int col;
        int [] manches ={0,0}; //initialisation de la table des parties gagnees par les deux joueurs
        boolean endgame = false;
        FileGame fileGame = new FileGame();
        int j =0;

        fileGame.save("log.txt",this.players[0].serialization(),false);

        fileGame.save("log.txt",this.players[1].serialization(),true);
        fileGame.save("log.txt","Manche commence ",true);

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

                            if (manches[j] == 3) {
                                endgame = true;
                                break;
                            }

                            System.out.println(players[j].getName() + " gagne.Nouvelle manche");
                            fileGame.save("log.txt", players[j].getName() + " gagne", true);
                            fileGame.save("log.txt", "Score " + manches[0] + "-" + manches[1], true);
                            fileGame.save("log.txt", "Manche commence ", true);

                            this.grid.initGrid(this.grid.getHeight(), this.grid.getLength());

                            break;
                        }
                    } else {
                        if (grid.fullGrid()) {
                            System.out.println("Match nul");
                            fileGame.save("log.txt", "Draw", true);
                            endgame = true;
                            break;
                        } else {
                            System.out.println("This colomn is full try another");
                        }
                    }
                } catch(HumanPlayIntException | HumanPlayStrException e){
                    System.out.println(e);
                }
            }
        }
        System.out.println("Fin de partie");
        fileGame.save("log.txt","Fin de partie",true);
    }


}
