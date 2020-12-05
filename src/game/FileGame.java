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


     static void save(String file,String historique,boolean type) { //type:faux ou vrai
        //File fichier = new File(file);

        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,type)))
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
