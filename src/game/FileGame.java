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
        //File fichier = new File(file);

        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,true)))
        {
            bufferedWriter.write(historique);
            //bufferedWriter.write(url+"\n");
           bufferedWriter.newLine();

        }
        catch (IOException e)
        {
            System.out.println("error");
        }


    }


}