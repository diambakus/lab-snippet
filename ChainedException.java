
public class ChainedException {

    public static void main(String []args) {

        try {
            method1();
        }
        catch(Exception exception) {
            System.out.println("Stacktrace legnth: "+ exception.getStackTrace().length);
            exception.printStackTrace();
            System.out.println("Stacktrace legnth: "+ exception.getStackTrace().length);
        }
    }

    static void method1() throws Exception {

        try {
            method2();
        }
        catch(Exception exception) {
            throw new Exception ("Exception thrown by method1", exception);
        }
    }

    static void method2() throws Exception {
        try {
            method3();
        }
        catch(Exception exception) {
            throw new Exception ("Exception thrown by method2", exception);
        }
    }

    static void method3() throws Exception {
        throw new Exception("Exception created by method3");        
    }
}