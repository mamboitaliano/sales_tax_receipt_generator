package taxes;

import java.math.BigDecimal;

public class Quantity {
	
	private static BigDecimal itemQty;
	
	Quantity(String itemQtyString) {
		Quantity.itemQty = new BigDecimal(itemQtyString);
	}
	
	public static BigDecimal getQuantity() {
		return itemQty;
	}

}
