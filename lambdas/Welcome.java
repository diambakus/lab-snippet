import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Welcome {

    public static void main(String[] args) {

        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 71};
        IntPredicate greaterThanFive = value -> value > 5;
        IntPredicate even = value -> value % 2 == 0;

        int[] target = new int[4];
        int i = 0;
        Stream<Integer> list = IntStream.of(values).filter(even.and(greaterThanFive));
        
        
    }
}