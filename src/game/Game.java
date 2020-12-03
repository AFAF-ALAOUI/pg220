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
        FileGame fileGame = new FileGame();
        fileGame.charger("infos.txt","player1 est human "+players[0].getName(),false);

        fileGame.charger("infos.txt","player2 est ia "+players[1].getName(),true);

        fileGame.charger("infos.txt","Manche commence ",true);
        while(endgame==false) {
            for (int i = 0; i < 2; i++) {

                game.display.display(game.grid);
                int col = game.players[i].play(game.grid);

                fileGame.charger("infos.txt",players[i].getName()+"joue "+col,true);
                if (game.grid.playColumn(game.players[i].getPawn(), col)) {
                    if (rules.search4(game.grid)) {
                        manches[i]++;
                        fileGame.charger("infos.txt","Score" +manches[0]+ "-"+manches[1],true);
                        game.display.display(game.grid);

                        if(manches[i]==3){
                            endgame = true;
                            break;
                        }

                        System.out.println(players[i].getName()+" a gagné.Nouvelle manche");
                        fileGame.charger("infos.txt",players[i].getName()+" a gagne",true);
                        fileGame.charger("infos.txt","Fin de partie",true);

                        game.grid.initGrid(game.grid.getHeight(),game.grid.getLength());

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
        fileGame.charger("infos.txt","Fin de partie",true);
    }


}
