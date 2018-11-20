
public class DivideByZeroNoException {

    public static void main(String[] args) throws ArithmeticException {
        
        int numerator = Integer.parseInt(args[0]);
            int denominator = Integer.parseInt(args[1]);
            System.out.println(numerator/denominator);

        try {
            
        } catch(ArithmeticException arithmeticException) {
           System.err.append("No No No!\n We cannot divide by zero.\n");
        }catch(NumberFormatException numberFormatException) {
            System.err.append("Wrong number format\n");
        }
        System.out.println("Keep rolling...");
    }
}