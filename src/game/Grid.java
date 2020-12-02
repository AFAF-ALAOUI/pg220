package game;

public class Grid {

    private final int EMPTY = 0;
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






    // Function that checks if 4 pawns are aligned in a lign or a colomn
    // sligne: origine de la ligne
    // dligne : déplacement de la ligne
    public boolean search4aligned(int sligne,int scol,int dligne,int dcol){
        int pawn = 0;
        int cpt =0;
        while( (sligne>=0) && (sligne<=height) && (scol>=0) && (scol<=length) ){
            if(grid[sligne][scol] != pawn){
                cpt =1; //reinitialisation du compteur
                pawn = grid[sligne][scol];
            }
            else{
                cpt++;
            }
            if((pawn!=0) && (cpt==4) ){
                return true;
            }
            sligne +=dligne;
            scol +=dcol;
        }
        return false;
    }

    // Function that checks if 4 pawns are aligned in the grid
    public boolean search4(){
        //Parcours de lignes
        for(int ligne=0;ligne < height; ligne++){
            if(search4aligned(ligne,0,1,0)){
                return true;
            }
        }
        //Parcours des colonnes
        for(int col=0;col < length ;col++){
            if(search4aligned(0,col,0,1)){
                return true;
            }
        }
        //parcours des diagonals par colonnes
        for(int col=0;col < length ;col++){
            //première diag
            if(search4aligned(0,col,1,1)){
                return true;
            }
            //deuxième diag
            if(search4aligned(0,col,1,-1)){
                return true;
            }
        }
        //parcours des diagonals par lignes
        for(int ligne=0;ligne < height; ligne++){
            //première diag
            if(search4aligned(ligne,0,1,1)){
                return true;
            }
            //deuxième diag
            if(search4aligned(ligne,0,1,-1)){
                return true;
            }
        }
        return false;
    }
}
