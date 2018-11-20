import java.util.Scanner;

public class AssertTest {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner (System.in);
        System.out.print("Digite um número entre 0 e 10: ");

        int algo = scanner.nextInt();

        assert (algo >= 0 && algo <= 10) : "Número inválido: " + algo;
        
        System.out.println("Você digitou:"+algo);
    }
}