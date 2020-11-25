package game;

public class Grid {

    private final int empty = 0;
    private final int player1 = 1;
    private final int player2 = 2;

    private int height;
    private int length;
    private int[][] grid;


    //const
    public Grid(){
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
        for(int i=0; i<this.height; i++){
            if (this.grid[i][column] == 0){
                return i;
            }
        }
        return -1;
    }


    public void playColumn(int player,int column){
        int i = firstEmpty(column);
        if (i!= -1){
            this.grid[i][column]=player;
        }
    }


    public void display(Grid grid) {
        for (int i=1; i<grid.length; i++){
            System.out.println(i );
        }
        for (int j=1; j<grid.height; j++){
            for (int k=1; k < grid.length; k++){
                switch (grid.grid[j][k]) {
                    case empty:
                        System.out.println(". ");
                        break;
                    case player1:
                        System.out.println("x ");
                        break;
                    case player2:
                        System.out.println("o ");
                        break;
                }
                System.out.println("\n");

            }
        }
    }
}
