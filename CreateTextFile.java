import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    
    private static Formatter formatter;

    public static void main(String[] args) {
        openFile();
        addRecords();
        closeFile();
    }

    public static void openFile() {
        try {
            formatter = new Formatter("clients.txt");
        }catch(SecurityException securityException) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }catch(FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    public static void addRecords() {

        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s%n%s%n", 
                          "Type <account number> <first name> <last name> <balance>",
                          "Enter end-of-file indicator to end input.");
        while(scanner.hasNext()) {
            try {
                formatter.format("%d %s %s %.2f%n", 
                    scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextDouble());
            }
            catch(FormatterClosedException formatterClosedException) {
                System.err.println("Error writing to the file. Terminating.");
                break;
            }
            catch(NoSuchElementException noSuchElementException) {
                System.err.println("Invalid input. You may try again.");
                scanner.nextLine();
            }
            System.out.print("? ");
        } 
    }

    public static void closeFile() {
        if (formatter != null)
           formatter.close(); 
    }
}