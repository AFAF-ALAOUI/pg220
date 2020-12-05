package game;

public class Display {


     void display(Grid grid) {

        for (int i=0; i<grid.getLength(); i++){
            System.out.print(i+1);
            System.out.print(" ");
        }
        System.out.println();
        for (int j=0; j<grid.getHeight(); j++){
            for (int k=0; k < grid.getLength(); k++){
                switch (grid.getGrid(j,k)) {
                    case 0:
                        System.out.print(". ");
                        break;
                    case 1:
                        System.out.print("x ");
                        break;
                    case 2:
                        System.out.print("o ");
                        break;
                }
            }
            System.out.println();
        }
    }
}
