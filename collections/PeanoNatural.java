import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PeanoNatural {

    public static void main(String[] args) {
        Integer[] primeNumbers = {2, 3, 5, 7, 31};
        Integer[] oddNumbers = {11, 9, 51};


        List<Integer> primeNumbersList = new ArrayList<>(Arrays.asList(primeNumbers));

        Collections.addAll(primeNumbersList, oddNumbers);
        System.out.printf("List of prime numbers %s%n", primeNumbersList);

        Integer[] evenNumbers = {0, 2, 4, 10, 20};
        List<Integer> evenNumbersList = new ArrayList<>(Arrays.asList(evenNumbers));

        System.out.printf("Do passed lists have some numbers in common ? %s%n", 
        (Collections.disjoint(primeNumbersList, evenNumbersList) ? "Yes" : "No"));

        System.out.println("How many times the number 17 appears in the list ?");
        System.out.printf("The number 17 appears %d times in the list.%n", 
        Collections.frequency(primeNumbersList, 2));
    }
}