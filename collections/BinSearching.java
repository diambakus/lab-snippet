import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinSearching {

    public static void main(String[] args) {
        
        String[] colors = {"red", "white", "blue", "black", "yellow",
             "purple", "tan", "pink"};
        List<String> list = new ArrayList<>(Arrays.asList(colors));
        
        Collections.sort(list);
        System.out.println(list);

        printSearchResult(list, "red");
        printSearchResult(list, "blue");
        printSearchResult(list, "tan");
        printSearchResult(list, "aqua");
        printSearchResult(list, "grey");
        printSearchResult(list, "green");
    }

    private static void printSearchResult(List<String> list, String color) {

        int index = Collections.binarySearch(list, color);

        if (index >= 0)
            System.out.printf("O elemento encontrado em %d%n", index);
        else
            System.out.printf("O elemento não foi encontrado.(%d)%n", index);
    }
}