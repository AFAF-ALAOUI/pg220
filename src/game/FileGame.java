package game;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileGame {
    //BufferedReader buff = null;
    //BufferedReader(new FileReader("Historique.txt"));


    public static void charger(String file,String historique) {
        File fichier = new File(file);

        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fichier)))
        {
            bufferedWriter.write(historique);
        }
        catch (IOException e)
        {
            System.out.println("error");
        }


    }


}