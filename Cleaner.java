
import java.util.Scanner;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Program made to clean your files (MAC version).
 * 
 * @author (Grant Goldenberg) 
 * @version (November 27, 2015)
 */
public class Cleaner 
{
    public static char init() {
        System.out.println("\fWelcome to File Valet the program made to clean your files!");
        System.out.print("Would you like us to clean your desktop (Y/n): ");
        Scanner keyboard = new Scanner(System.in);
        char input = keyboard.next().charAt(0);
        return input;
    }

    public static void cleaner(char input) throws IOException {
        if (input == 'Y') {
            System.out.println("Okay, cleaning...");
            String dirPath = "/Users/grantgoldenberg/Desktop";
            File dir = new File(dirPath);
            FilenameFilter textFilter = new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        String lowercaseName = name.toLowerCase();
                        if (lowercaseName.startsWith("#z")) {
                            System.out.println("The following files were found and are being cleaned.");
                            return true;
                        } else {
                            System.out.println("No files were found to be cleaned.");
                            return false;
                        }
                    }
                };
            File[] files = dir.listFiles(textFilter);
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.print("directory:");
                } else {
                    System.out.print("file:");
                }
                System.out.println(file.getCanonicalPath());
            }
        }
        else {
            System.out.println("Okay, closing the program...");
            System.exit(0);    
        }
    }

    public static void main(String args[]) throws IOException {    
        cleaner(init());
    }
}

