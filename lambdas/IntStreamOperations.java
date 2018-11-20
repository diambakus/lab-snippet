import java.util.stream.IntStream;

public class IntStreamOperations {

    public static void main(String[] args) {

        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 71};

        //display original values
        System.out.print("Original values: ");
        IntStream.of(values).forEach(value->System.out.printf("%d ", value));
        System.out.println();

        // count, min, max, sum and average of the values
        System.out.printf("Number of elements: %d%n", IntStream.of(values).count());

        System.out.printf("Smallest element: %d%n", IntStream.of(values).min().getAsInt());

        System.out.printf("Biggest element: %d%n", IntStream.of(values).max().getAsInt());

        System.out.printf("The sum of the elements: %d%n", 
        IntStream.of(values).sum());

        System.out.printf("The average of the elements: %.2f%n", 
        IntStream.of(values).average().orElse(-1.0));

        // sum of values with reduce method
        System.out.printf("%nThe sum via reduce: %d%n", 
        IntStream.of(values).reduce(0, (x,y)-> x+y));

        // sum of squares of values with reduce method
        System.out.printf("The sum of squares via reduce: %d%n",
        IntStream.of(values).reduce(0, (x,y)-> x + y * y));

        // product of values with reduce method
        System.out.printf("The product via reduce: %d%n",
        IntStream.of(values).reduce(1, (x,y)-> x * y));

        // even values displayed in sorted order
        System.out.print("The set of even elements in sorted order: ");
        IntStream.of(values).filter(value -> value % 2 == 0).sorted()
        .forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        // odd values multiplied by 10 and displayed in sorted order
        System.out.print("odd values multiplied by 10 and displayed in sorted order: ");
        IntStream.of(values).filter(value-> value % 2 != 0).map(value->value * 10)
        .sorted().forEach(value->System.out.printf("%d ", value));
        System.out.println();

        //sum range of integers from 1 to 10, exclusive
        System.out.printf("%nSum of integers from 1 to 9: %d%n", 
        IntStream.range(1, 10).sum());

        //sum range of integers from 1 to 10, inclusive
        System.out.printf("%nSum of integers from 1 to 10: %d%n", 
        IntStream.rangeClosed(1, 10).sum());
    }
}