package taxes;
import java.math.*;
public class CalcItemTotal {
	
	private BigDecimal itemSubtotal;
	private BigDecimal itemTotalTax;
	
	public CalcItemTotal(BigDecimal price, BigDecimal quantity) {
		this.itemSubtotal = price.multiply(quantity);
	}
	
	// Returns price * quantity of current item
	public BigDecimal getItemSubtotal() {
		return itemSubtotal;
	}
	
	// Returns the total applicable tax amount for this item's subtotal
	public BigDecimal getItemTaxTotal() {
		itemTotalTax = Quantity.getQuantity().multiply(ItemSalesTax.getItemSalesTax().add(ItemImportTax.getItemImportTax()));
		itemTotalTax = itemTotalTax.setScale(2, RoundingMode.HALF_UP);
		
		return itemTotalTax;
	}

}
