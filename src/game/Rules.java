package game;

public class Rules {
    private final int EMPTY = 0;

    // Function that checks if 4 pawns are aligned in a lign or a colomn
    // sligne: origine de la ligne
    // dligne : déplacement de la ligne
    private boolean search4aligned(Grid grid,int sligne,int scol,int dligne,int dcol){
        int pawn = EMPTY;
        int cpt =0; //compteur
        int height = grid.getHeight();
        int length = grid.getLength();
        while( (sligne>=0) && (sligne<height) && (scol>=0) && (scol<length) ){
            if(grid.getGrid()[sligne][scol] != pawn){
                cpt =1; //reinitialisation du compteur
                pawn = grid.getGrid()[sligne][scol];
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
    public boolean search4(Grid grid){
        int height = grid.getHeight();
        int length = grid.getHeight();
        //Parcours de lignes
        for(int ligne=0;ligne < height; ligne++){
            if(search4aligned(grid,ligne,0,0,1)){
                return true;
            }
        }
        //Parcours des colonnes
        for(int col=0;col < length ;col++){
            if(search4aligned(grid,0,col,1,0)){
                return true;
            }
        }
        //parcours des diagonals par colonnes
        for(int col=0;col < length ;col++){
            //première diag
            if(search4aligned(grid,0,col,1,1)){
                return true;
            }
            //deuxième diag
            if(search4aligned(grid,0,col,1,-1)){
                return true;
            }
        }
        //parcours des diagonals par lignes
        for(int ligne=0;ligne < height; ligne++){
            //première diag
            if(search4aligned(grid,ligne,0,1,1)){
                return true;
            }
            //deuxième diag
            if(search4aligned(grid,ligne,length-1,1,-1)){
                return true;
            }
        }
        return false;
    }

}