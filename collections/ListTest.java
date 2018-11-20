import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class ListTest {

    public static void main(String[] args) {
        
        String[] colors = {"black", "yellow", "green", "blue", "violet", "silver"};
        List<String> list1 = new LinkedList<>();

        String[] colors2 = {"gold", "white", "brown", "blue", "gray", "silver"};
        List<String> list2 = new LinkedList<>();

        for (String color: colors)
            list1.add(color);

        for (String color: colors2)
            list2.add(color);
        
        list1.addAll(list2);
        list2 = null;

        System.out.println(list1);

        convertToUpperCaseStrings(list1);
        printList(list1);

        System.out.println("Deleting elements from 4 - 6");

        removeItems(list1, 4, 7);
        printList(list1);

        reverseList(list1);
    }

    private static void printList(List<String> list) {

        for(String color: list)
            System.out.printf("%s ", color);    
        System.out.println();
    }

    private static void convertToUpperCaseStrings(List<String> list) {
         
        ListIterator<String> iterator = list.listIterator();

        while(iterator.hasNext()) {
            iterator.set(iterator.next().toUpperCase());
        }
    }

    private static void removeItems(List<String> list, int start, int end) {
        list.subList(start, end).clear();
    }

    private static void reverseList(List<String> list) {

        ListIterator<String> iterator = list.listIterator(list.size());

        while(iterator.hasPrevious()) {
            System.out.printf("%s ", iterator.previous());
        }
        System.out.println();
    }
}