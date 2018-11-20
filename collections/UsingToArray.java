import java.util.Arrays;
import java.util.LinkedList;

public class UsingToArray {
    
    public static void main(String[] args) {
        
        String[] colors = {"black", "blue", "yellow"};
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(colors));

        linkedList.addLast("cyan");
        linkedList.add("green");
        linkedList.add(3, "pink");
        linkedList.addFirst("brown");

        colors = linkedList.toArray(new String[linkedList.size()]);

        for (String color: colors)
            System.out.printf("%s(%s) ", color, color.toUpperCase());
        System.out.println();
    }
}