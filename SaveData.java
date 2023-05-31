import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.io.FileWriter;
import java.util.Scanner;
public class SaveData {

    private File file;
    private FileWriter fw;
    private String[] saves;
    
    public SaveData(String name) throws IOException {
        file = new File(name);
        fw = new FileWriter(file, true);
    }

    public void save(Player player) throws IOException {
        Scanner fr = new Scanner(file);
        PrintWriter pw = new PrintWriter(fw, true);
        
        /* work on later
        if(fr.hasNextLine()){
            // BufferedWriter writer = Files.newBufferedWriter(file.toPath());
            // writer.write("");
            // writer.flush();
            SaveData.clearFile(file);
        }
        */
        String total = player.getName()+"_"+player.getBalance();
        pw.print(total+" ");
        pw.close();
    }

    public static void clearFile(File file) throws IOException {
        FileWriter fww = new FileWriter(file, false);
        PrintWriter pw = new PrintWriter(fww, false);

        pw.flush();
        pw.close();
        
    }
    
    public boolean anyContents() throws IOException {
        Scanner fr = new Scanner(file);
        if(fr.hasNextLine()){
            return true;
        } else {
            return false;
        }
    }

    public void loadPlayer(Player player) throws IOException {

        Scanner fr = new Scanner(file);
        
        saves = fr.nextLine().split(" ");

        String recentSave = saves[saves.length-1];
        String name = recentSave.substring(0,recentSave.indexOf("_"));
        double balance = Double.parseDouble(recentSave.substring(recentSave.indexOf("_")+1));

        player.setName(name);
        player.setBalance(balance);
        
    }
    
}