import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class CollectionTest {

    public static void main(String []args) {

        String[] colors = {"BLUE", "YELLOW", "GREEN", "RED", "BLACK", "MAGENTO"};
        List<String> list = new ArrayList<String>();

        for(String color: colors)
          list.add(color);
        
          String[] removingColors = {"MAGENTO", "RED"};
          List<String> removeList = new ArrayList<String>();

          for(String color: removingColors)
              removeList.add(color);

          System.out.print("List before remotion:");
          
          for (int i = 0; i < list.size(); i++)
              System.out.printf("%s ", list.get(i));

         removeColor(list, removeList);
         
         System.out.printf("%nList after remotion: ");

         for (int i = 0; i < list.size(); i++)
              System.out.printf("%s ", list.get(i));
         System.out.println();     
    }

    private static void removeColor(Collection<String> collection1, 
        Collection<String> collection2) {

        Iterator<String> iterator = collection1.iterator();

        while(iterator.hasNext()) {
            if (collection2.contains(iterator.next()))
                iterator.remove();
        }
    }
}