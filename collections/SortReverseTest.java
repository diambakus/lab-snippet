import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortReverseTest {

    public static void main(String[] args) {
        
        String[] cards = {"Hearts", "Diamonds", "Clubs", "Spades"};
        List<String> list = Arrays.asList(cards);

        System.out.printf("Unsorted: %s%n", list);
        
        Collections.sort(list, Collections.reverseOrder());

        System.out.printf("Sorted: %s%n", list);

    }
}