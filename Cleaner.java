import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Write a description of class Cleaner here.
 * 
 * @author (Grant Goldenberg) 
 * @version (November 27, 2015)
 */
public class Cleaner
{
    public static char init(){
        System.out.println("\fWelcome to File Valet the program made to clean your files!");
        System.out.print("Would you like us to clean your desktop (Y/n): ");
        Scanner keyboard = new Scanner(System.in);
        char input = keyboard.next().charAt(0);
        return input;
    }

    public static void cleaner(char input) {
        if (input == 'Y') {
            System.out.println("Cleaning...");
            InputStream inStream = null;
            OutputStream outStream = null;
            File desktop = new File("C:/Users/grant/Desktop");
            File[] listOfFiles = desktop.listFiles();
            for(int i = 0; i < listOfFiles.length; i++) {
                String filename = listOfFiles[i].getName();
                if(filename.startsWith("#z")){
                    try {
                        File bfile = new File("C:/Users/grant/Documents");
                        inStream = new FileInputStream(desktop);
                        outStream = new FileOutputStream(bfile);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = inStream.read(buffer)) > 0){
                            outStream.write(buffer, 0, length);
                        }
                        inStream.close();
                        outStream.close();
                        desktop.delete();
                        System.out.println("File has been sorted successfully!");
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        else {
            System.out.println("Okay, closing the program...");
            System.exit(0);    
        }
    }

    public static void main(String args[]) {    
        cleaner(init());
    }
}

