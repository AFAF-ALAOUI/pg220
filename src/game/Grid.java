package game;

public class Grid {

    private final static int EMPTY = 0;

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


    void initGrid(int height,int length){
        grid = new int[height][length];
        for (int i=0; i<height; i++){
            for (int j=0; j<length; j++){
                grid[i][j] = EMPTY;
            }
        }

    }

    public boolean fullColumn(int column){
        for (int i = this.height-1; -1 < i; i--) {
            if (this.grid[i][column-1] == EMPTY) {
                return false;
            }
        }
        return true;
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
