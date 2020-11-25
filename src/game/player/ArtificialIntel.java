
public class ArtificialIntel extends Player{
    public static void play_ai(int Max){
        int nombreAleatoire;
        nombreAleatoire =(int)(Math.random() * (Max + 1));
        System.out.println("ai choose " + nombreAleatoire);
    }


}
