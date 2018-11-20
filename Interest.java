
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Interest {

    public static void main(String[] args) {
        BigDecimal principal = BigDecimal.valueOf(1000.0);
        BigDecimal rate = BigDecimal.valueOf(0.05);

        System.out.printf("%s%20s%n", "Year", "Amount of deposit");

        for (int year = 1; year<= 10; year++) {
            BigDecimal amount = principal.multiply(rate.add(BigDecimal.ONE).pow(year));
            
            System.out.printf("%4d%20s%n", year, NumberFormat.getCurrencyInstance(Locale.GERMANY).format(amount));
        }
    }
}