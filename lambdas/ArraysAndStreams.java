import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {

    public static void main(String[] args) {
        Integer[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 71};
        System.out.printf("The original values: %s%n", Arrays.asList(values));   

        // sort values in ascending order with streams
        System.out.printf("Sorted values: %s%n", Arrays.stream(values)
        .sorted().collect(Collectors.toList()));

        //Values greater than 4
        List<Integer> valuesGreaterThan4 = Arrays.stream(values)
        .filter(value->value > 4).collect(Collectors.toList());
        System.out.printf("Values greater than 4: %s%n", valuesGreaterThan4);

        // filter values greater than 4 then sort the results
        System.out.printf("Sorted values greater than 4: %s%n", 
        Arrays.stream(values).filter(element -> element > 4).sorted()
        .collect(Collectors.toList()));

        // greaterThan4 List sorted with streams
        System.out.printf("Values greater than 4 (ascending with streams): %s%n",
        valuesGreaterThan4.stream().sorted().collect(Collectors.toList()));
    }
}