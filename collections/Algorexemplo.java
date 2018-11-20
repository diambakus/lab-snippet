import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algorexemplo {

    public static void main(String[] args) {
        Character[] characters = {'P', 'C', 'M'};
        List<Character> listOfCharacters = Arrays.asList(characters);

        /*Reverse list*/
        Collections.reverse(listOfCharacters);
        System.out.printf("After reverse the list%n");
        output(listOfCharacters);

        Character[] copyCharacters = new Character[3];
        List<Character> listOfCopyCharacters = Arrays.asList(copyCharacters);

        /* Copy list */
        Collections.copy(listOfCopyCharacters, listOfCharacters);
        System.out.print("After copy the list%n");
        output(listOfCopyCharacters);

        /** Fill */
        Collections.fill(listOfCharacters, 'R');
        System.out.print("After fill the list with R %n");
        output(listOfCharacters);
    }

    private static void output(List<Character> list) {
        System.out.println("Printing list:");

        for (Character character: list)
            System.out.printf("%s ", character);

        System.out.printf("%n Max element: %s and ", Collections.max(list));
        System.out.printf("Min element: %s%n", Collections.min(list));    
    }
}