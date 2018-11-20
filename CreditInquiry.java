import java.io.IOException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class CreditInquiry {

    private final static MenuOption[] choices = MenuOption.values();

    public static void main(String[] args) {
        
        MenuOption accountType = getRequest();

        while(accountType != MenuOption.END) {

            switch(accountType) {
               case ZERO_BALANCE:
                  System.out.printf("%n Accounts with zero balances:%n");
                  break;
               case CREDIT_BALANCE:
                  System.out.printf("%n Accounts with credit balances:%n");
                  break;
               case DEBIT_BALANCE:
                  System.out.printf("%n Accounts with debit balances:%n");
                  break;
            }
            readRecords(accountType);
            accountType = getRequest();
        }
    }

    private static MenuOption getRequest() {

        int request = 4;

        System.out.printf("%n Enter request %n%s%n%s%n%s%n%s%n", 
        "1 - List accounts with zero balance;",
        "2 - List accounts with credit balance;",
        "3 - List accounts with debit balance;",
        "4 - Terminate program;");

        try {
            Scanner scanner = new Scanner(System.in);
            do {
               System.out.printf("%n?");
               request = scanner.nextInt();
            } while ((request < 1) || (request > 4));
        }
        catch(NoSuchElementException noSuchElementException) {
            System.err.println("Invalid input. Terminating."); 
        }
        return choices[request - 1];
    }

    private static void readRecords(MenuOption accountType) {

        try (Scanner scanner = new Scanner(Paths.get("clients.txt"))) {
            
            while(scanner.hasNext()) {
                int accountNumber = scanner.nextInt();
                String firstName = scanner.next();
                String lastName = scanner.next();
                double balance = scanner.nextDouble();

                if (shouldDisplay(accountType, balance)) {
                    System.out.printf("%-10d%-12s%-12s%10.2f%n",
                    accountNumber, firstName, lastName, balance);
                }
                else
                    scanner.nextLine();
            }

        } catch(NoSuchElementException | 
                IllegalStateException | IOException ioException) {
                System.err.println("Error processing file. Terminanting.");
                System.exit(1);
        }
    }

    private static boolean shouldDisplay(MenuOption accountType, double balance)
    {
        if ((accountType == MenuOption.CREDIT_BALANCE) && (balance < 0))
            return true;
        else if((accountType == MenuOption.DEBIT_BALANCE) && (balance > 0))
            return true;
        else if ((accountType == MenuOption.ZERO_BALANCE) && (balance == 0))        
            return true;
        return false;
    }
}