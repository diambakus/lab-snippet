import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();
    int[] ints = {10, 3, 5, 10, 3, 5, 10};

    for (int i = 0; i < ints.length; i++) {

        Integer integer = map.get(ints[i]);

        if (integer == null) {
            map.put(ints[i], 1);
        }else {
           map.put(ints[i], ++integer);
        }
    }

        for (Map.Entry entry: map.entrySet()) {
            System.out.printf("%d occurres %d times%n", entry.getKey(), entry.getValue());
        }    
    }
}