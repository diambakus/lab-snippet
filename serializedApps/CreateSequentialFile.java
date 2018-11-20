import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateSequentialFile {

    private static ObjectOutputStream objectOutputStream;

    public static void main(String[] args) {
        openFile();
        addRecords();
        closeFile();
    }

    public static void openFile()
    {
        try {
             objectOutputStream = new ObjectOutputStream(
                 Files.newOutputStream(Paths.get("clients.ser")));
        }
        catch(IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    public static void addRecords() {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("%s%n%s%n? ", 
              "Enter <account number> <First name> <Last name> <Balance>", 
              "Enter end-of-file");

        while(scanner.hasNext()) {

            try {
                Account account = new Account(scanner.nextInt(), scanner.next(), 
                scanner.next(), scanner.nextDouble());
                objectOutputStream.writeObject(account);
            }
            catch(NoSuchElementException noSuchElementException) {
                System.err.println("Invalid input. Please, try again.");
                scanner.nextLine();
            }
            catch(IOException ioException) {
                System.err.println("File not found. Terminating");
                break;
            }
            System.out.print("? "); 
        }     
    }

    public static void closeFile() {
        try {
            if (objectOutputStream != null)
              objectOutputStream.close();
        }
        catch(IOException ioException) {
            System.err.println("Error closing file. Terminating.");
        }
    }
}