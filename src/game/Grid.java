package game;

public class Grid {

    private final int empty = 0;
    private final int player1 = 1;
    private final int player2 = 2;

    protected int height;
    protected int length;
    protected int[][] grid;


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
                grid[i][j] = empty;
            }
        }

    }

    private int firstEmpty(int column){
        for(int i=this.height-1; -1<i; i--){
            if (this.grid[i][column] == 0){
                return i;
            }
        }
        return -1;
    }


    public void playColumn(int player,int column){
        int i = firstEmpty(column);
        if (i!= -1){
            this.grid[i][column-1]=player;
        }
    }


}


