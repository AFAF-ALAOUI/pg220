package game;

public class Grid {

    private final int EMPTY = 0;
    private final int PLAYER1 = 1;
    private final int PLAYER2 = 2;

    private int height;
    private int length;
    private int[][] grid;


    //const
    public Grid(){
        this.height = 6;
        this.length = 7;
        initGrid(6,7);
    }
    public Grid(int height, int length){
        this.height = height;
          this.length = length;
        initGrid(height,length);
    }

    //getters
    public int getHeight(){
        return this.height;
    }
    public int getLength() {
        return this.length;
    }
    int getGrid(int i, int j) {
        return this.grid[i][j];
    }


    //
    void initGrid(int height,int length){
        grid = new int[height][length];
        for (int i=0; i<height; i++){
            for (int j=0; j<length; j++){
                grid[i][j] = EMPTY;
            }
        }

    }



    boolean playColumn(int player,int column){
      for (int i = this.height-1; -1 < i; i--) {
         if (this.grid[i][column-1] == EMPTY) {
            this.grid[i][column-1] = player;
            return true;
          }
        }
        return false;
      }

    boolean fullGrid(){
      for (int i=0; i<this.height; i++){
          for (int j=0; j<this.length; j++){
            if (this.grid[i][j] == EMPTY){
              return false;
            }
          }
        }
    return true;
  }

}
