package game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGame {

    public static void save(String file,String historique,boolean type) { //type:false or true

        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file,type)))
        {
           bufferedWriter.write(historique);
           bufferedWriter.newLine();
        }
        catch (IOException e)
        {
            System.out.println("error");
        }
    }
}
