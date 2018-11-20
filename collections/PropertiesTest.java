import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {

    public static void main(String []args) {

        Properties table = new Properties();

        table.setProperty("color", "blue");
        table.setProperty("width", "200");

        System.out.println("After setting properties.");
        listProperties(table);

        table.setProperty("color", "green");

        System.out.println("After replacing a property");
        listProperties(table);

        saveProperties(table);

        table.clear();
        
        System.out.println("After clearing properties");
        listProperties(table);

        loadProperties(table);

        Object valueObject = table.get("color");

        if (valueObject != null)
            System.out.printf("The property color's value is %s%n", valueObject);
        else
            System.out.println("The property color is not in the table.");
    }

    private static void saveProperties(Properties properties) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("properties.dat");
            properties.store(fileOutputStream, "Sample properties");
            fileOutputStream.close();

            System.out.println("After saving properties.");
            listProperties(properties);
        }
        catch(IOException ioException){
           ioException.printStackTrace();
        }
    }

    private static void loadProperties(Properties properties) {
        try {
             FileInputStream fileInputStream = new FileInputStream("properties.dat");
             properties.load(fileInputStream);
             fileInputStream.close();
             System.out.println("After loading properties.");
             listProperties(properties);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

    private static void listProperties(Properties properties) {

        Set<Object> keys = properties.keySet();

        for (Object object: keys) {
            System.out.printf("%s\t%s%n", object, properties.getProperty((String)object));
        }
        System.out.println();
    }
}