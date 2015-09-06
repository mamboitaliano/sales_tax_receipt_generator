package taxes;
import java.math.*;

public class ItemPrice {
	
	private BigDecimal amount;
	
	// Default constructor
	public ItemPrice() {
	// no-arg	
	}
	
	// Constructor to receive dollar amount of item's price
	public ItemPrice(String itemPriceString) {
		BigDecimal tempDecimal = new BigDecimal(itemPriceString);
		tempDecimal = tempDecimal.setScale(2);
		this.amount = tempDecimal;
	}
	
	// Method to receive item price
	public BigDecimal getItemPrice() {
		return amount;
	}
}
