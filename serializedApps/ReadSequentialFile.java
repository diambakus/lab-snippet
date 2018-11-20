import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadSequentialFile {

    private static ObjectInputStream objectInputStream;

    public static void main(String[] args) {
            openFile();
            readRecords();
            closeFile();
    }

    private static void openFile() {

        try {
            objectInputStream = new ObjectInputStream(Files.newInputStream(
                Paths.get("clients.ser")));
        }
        catch(IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    private static void readRecords() {

        System.out.printf("%n%-10s%-12s%-12s%10s%n", "Account Number", "First Name", 
             "Last Name", "Balance");

        try {     
            while(true) {

                Account account = (Account) objectInputStream.readObject();
                System.out.printf("%-10d%-12s%-12s%10.2f%n", account.getAccountNumber(),
                account.getFirstName(), account.getLastName(), account.getBalance());
            }
        }
        catch(EOFException eofException) {
            System.out.printf("No more records%n");
        }
        catch(ClassNotFoundException classNotFoundException) {
            System.err.println("Invalid object type. Terminating.");
            System.exit(1);
        }
        catch(IOException ioException) {
            System.err.println("Error reading file.");
        }
    }

    private static void closeFile() {
        try {
            if (objectInputStream != null)
                objectInputStream.close();
        }
        catch(IOException ioException) {
            System.err.println("Error closing file. Terminating");
            System.exit(1);
        }
    }
}