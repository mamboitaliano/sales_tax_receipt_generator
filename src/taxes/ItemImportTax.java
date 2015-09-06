package taxes;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemImportTax extends ItemPrice {

	private static BigDecimal importTaxAmt;
	private BigDecimal importTaxRate = new BigDecimal(0.05);
	
	public ItemImportTax(BigDecimal amount) {
		if (Item.isImported() == false) {
			ItemImportTax.importTaxAmt = new BigDecimal(0.00);
		}
		else {
			BigDecimal tempImportTaxAmt;
			tempImportTaxAmt = amount.multiply(importTaxRate);
			
			// Rounding...
			BigDecimal twenty = new BigDecimal(20);
			BigDecimal roundedImportTax = new BigDecimal(tempImportTaxAmt.multiply(twenty)
					.add(new BigDecimal("0.5"))
					.toBigInteger()).divide(twenty);
			ItemImportTax.importTaxAmt = roundedImportTax.setScale(2, RoundingMode.HALF_UP);
		}
	}
	
	public static BigDecimal getItemImportTax() {
		return importTaxAmt;
	}
}
