import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class WordsFrequencyCounter {

    public static void main(String[] args) {
        Map<String, Integer> wordsFrequency = new HashMap<>();
         
        createMap(wordsFrequency);
        printWordsFrequency(wordsFrequency);  
    }

    private static void createMap(Map<String, Integer> map) {

        Scanner scanner = new Scanner (System.in);

        String text = scanner.nextLine();
        String[] wordsArray = text.split(" ");

        for(String string: wordsArray) {
            String loweredString = string.toLowerCase();

            if (map.containsKey(loweredString))
                map.put(loweredString, map.get(loweredString)+1);
            else
                map.put(loweredString, 1);
        }
    }

    private static void printWordsFrequency(Map<String, Integer> map) {

            Set<String> keys =  map.keySet();
            TreeSet<String> sortedKeys = new TreeSet<>(keys);

            System.out.printf("%n%-10s%-12s%n", "Palavra", "Frequência");
            for (String string: sortedKeys) {
                System.out.printf("%-10s%-12s%n", string, map.get(string));
            }
    }
}