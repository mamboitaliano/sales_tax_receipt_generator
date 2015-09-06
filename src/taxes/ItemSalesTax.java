package taxes;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemSalesTax extends ItemPrice {
	
	private static BigDecimal salesTaxAmt;
	private BigDecimal salesTaxRate = new BigDecimal(0.10);
	
	public ItemSalesTax(BigDecimal amount) {
		Item tempItemTypeObj = new Item();
		if (tempItemTypeObj.getItemType() == ItemType.BOOK || tempItemTypeObj.getItemType() == ItemType.FOOD || tempItemTypeObj.getItemType() == ItemType.MEDICAL) {
			ItemSalesTax.salesTaxAmt = new BigDecimal(0.00);
		}
		else {
			BigDecimal tempSalesTaxAmt;
			tempSalesTaxAmt = amount.multiply(salesTaxRate);
			
			// Rounding...
			BigDecimal twenty = new BigDecimal(20);
			BigDecimal roundedSalesTax = new BigDecimal(tempSalesTaxAmt.multiply(twenty)
					.add(new BigDecimal("0.5"))
					.toBigInteger()).divide(twenty);
			ItemSalesTax.salesTaxAmt = roundedSalesTax.setScale(2, RoundingMode.HALF_UP);
		}
	}
	
	public static BigDecimal getItemSalesTax() {
		return salesTaxAmt;
	}

}
