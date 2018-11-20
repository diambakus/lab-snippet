
import java.lang.IllegalArgumentException;
import Payable;

public class Fatura implements Payable {
    
    private final String partNumber;
    private final String partDescription;
    private  int quantity;
    private  double pricePerItem;

    public Fatura(String partNumber, String partDescription, int quantity, double pricePerItem) {

        if (quantity < 0)
          throw new IllegalArgumentException("Quantity cannot be less then zero");
         
        if (pricePerItem < 0.0)
          throw new IllegalArgumentException("Quantity cannot be less then zero");
        
          this.partDescription = partDescription;
          this.partNumber = partNumber;
          this.pricePerItem = pricePerItem;
          this.quantity = quantity;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0)
          throw new IllegalArgumentException("Quantity cannot be less then zero");
        this.quantity = quantity;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem < 0.0)
          throw new IllegalArgumentException("Quantity cannot be less then zero");
        this.pricePerItem = pricePerItem;  
    }

    // return String representation of Invoice object
    @Override
    public String toString() {
         return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f",
                     "invoice", "part number", getPartNumber(), getPartDescription(),
                     "quantity", getQuantity(), "price per item", getPricePerItem());
    }

    @Override
    public double getPayableAmount() {
        return getQuantity() * getPricePerItem();
    }
}