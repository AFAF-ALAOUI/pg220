package game;
import game.player.Player;


public class Game {

    public Grid grid;
    private Player[] players = new Player[2] ;
    protected Display display = new Display();

    public Game(Player player1, Player player2){
        setPlayers(player1,player2);
        setGrid();

    }

    public void setPlayers(Player player1, Player player2){
        this.players[0] = player1;
        this.players[1] = player2;
    }

    public void setGrid(){
        this.grid = new Grid();
    }

    public void startGame(Game game){

        while(true) {
            for (int i=0; i<2;i++){
                game.display.display(game.grid);
                int col = game.players[i].play(game.grid);
                game.grid.playColumn(game.players[i].getPawn(),col);
            }
        }
    }


}