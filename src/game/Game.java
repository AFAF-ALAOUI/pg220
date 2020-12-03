package game;
import game.player.Player;


public class Game {

    private Grid grid;
    private Rules rules;

    private Player[] players = new Player[2] ;
    private Display display = new Display();

    public Game(Player player1, Player player2){
        setPlayers(player1,player2);
        setGrid();
        setrules();
    }

    public void setrules(){
        this.rules = new Rules();
    }

    public void setPlayers(Player player1, Player player2){
        this.players[0] = player1;
        this.players[1] = player2;
    }

    public void setGrid(){
        this.grid = new Grid();
    }

    public void startGame(Game game){
        int [] manches ={0,0}; //tableau des parties gagnées par les deux joueurs
        boolean endgame = false;
        while(endgame==false) {
            for (int i = 0; i < 2; i++) {

                game.display.display(game.grid);
                int col = game.players[i].play(game.grid);
                if (game.grid.playColumn(game.players[i].getPawn(), col)) {
                    if (rules.search4(game.grid)) {
                        manches[i]++;
                        game.display.display(game.grid);
                        if(manches[i]==3){
                            endgame = true;
                            break;
                        }
                        game.grid.initGrid(game.grid.getHeight(),game.grid.getLength());
                        System.out.println(players[i].getName()+" a gagné.Nouvelle manche");
                        break;
                    }
                }
                else {
                    endgame = true;
                    break;
                }
            }
        }
        System.out.println("Fin de partie");
    }


}
