
public class StringValueOf {

    public static void main(String[] args) {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        boolean booleanValue = true;
        char charValue = 'Z';
        int integerValue = 1;
        long longValue = 100000000000L;
        float floatValue = 2.5f;
        double doubleValue = 33.333;
        Object objectRef = "hello";

        System.out.println("Char array: "+String.valueOf(charArray));
        System.out.println("Bool: "+ String.valueOf(booleanValue));
        System.out.println("char: "+String.valueOf(charValue));
        System.out.println("integer: "+ String.valueOf(integerValue));
        System.out.println("long: "+ String.valueOf(longValue));
        System.out.println("float: "+ String.valueOf(floatValue));
        System.out.println("double: "+ String.valueOf(doubleValue));
        System.out.println("ref: "+ String.valueOf(objectRef));
    }
}