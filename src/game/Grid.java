package game;

public class Grid {

    private final int EMPTY = 0;
    private final int player1 = 1;
    private final int player2 = 2;

    private int height;
    private int length;
    private int[][] grid;


    //const
    public Grid(){
        setHeight(6);
        setLength(7);
        initGrid(6,7);
    }
    public Grid(int height, int length){
        setHeight(height);
        setLength(length);
        initGrid(height,length);
    }


    //setters
    public void setHeight(int height){
        this.height = height;
    }
    public void setLength(int length){
        this.length = length;
    }

    //getters
    public int getHeight(){
        return this.height;
    }
    public int getLength() {
        return this.length;
    }
    public int[][] getGrid() {
        return this.grid;
    }


    //
    public void initGrid(int height,int length){
        grid = new int[height][length];
        for (int i=0; i<height; i++){
            for (int j=0; j<length; j++){
                grid[i][j] = EMPTY;
            }
        }

    }



    public boolean playColumn(int player,int column){
      for (int i = this.height-1; -1 < i; i--) {
         if (this.grid[i][column-1] == EMPTY) {
            this.grid[i][column-1] = player;
            return true;
          }
        }
        return false;
      }


}
