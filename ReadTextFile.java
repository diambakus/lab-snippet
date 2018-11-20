import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile {
    
    private static Scanner scanner;

    public static void main(String[] args) {
        openFile();
        readRecords();
        closeFile();
    }

    public static void openFile() {
        try {
            scanner = new Scanner(Paths.get("clients.txt"));
        }
        catch(IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    public static void readRecords() {
        System.out.printf("%-10s%-12s%-12s%10s%n", "Account", "First name", "Last name",
         "Balance");

        try {
            while(scanner.hasNext()) {
                System.out.printf("%-10d%-12s%-12s%10.2f%n", scanner.nextInt(), scanner.next(),
                scanner.next(), scanner.nextDouble());
            }
        } 
        catch(NoSuchElementException noSuchElementException) {
            System.err.println("File improperly formed. Terminating.");
        }
        catch(IllegalStateException illegalStateException) {
            System.err.println("Error reading from file. Terminating.");
        }
    }

    public static void closeFile() {
        if (scanner != null) {
            scanner.close();
        }
    }
}