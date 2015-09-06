package taxes;
import java.io.File;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
  @SuppressWarnings("unused")
public static void main(String[] args) throws Exception {
	  
	  String tempString = "";
	  BigDecimal taxTotal = new BigDecimal("0");
	  BigDecimal basketSubtotal = new BigDecimal("0");
	  
	  // File reference
	  File file = new File("Order.txt");
	  Scanner input = new Scanner(file);
	  
	  // File reader 
	  while(input.hasNextLine()) {
		  tempString = input.nextLine();
		  
		  StringBuilder itemQty = new StringBuilder();
		  StringBuilder itemName = new StringBuilder();
		  StringBuilder itemPrice = new StringBuilder();
		  int placeholder = 0;
		  char[] character = tempString.toCharArray();
	  
		  // Steps through character[] and grabs the quantity, which would be the first digit(s) of each line
		  for (int i = 0; i < character.length; i++) {
			  placeholder = i;
			  String tempItemQty = null;
			  Character charAtPlaceholder = new Character(character[i]);
			  if (Character.isDigit(charAtPlaceholder.charValue()) == true) {
				  tempItemQty = Character.toString(charAtPlaceholder.charValue());
				  //System.out.println("The character at position " + i + " matches expected value " + charAtPlaceholder.charValue()+ ", storing " + tempItemQty + " to variable tempItemQty");
				  itemQty.append(tempItemQty);
				  }
			  else {
				  break;
				  }
			  }
		  
		  // Steps through the rest of character[] starting at the placeholder position and grabs the item name
		  for (int i = placeholder + 1; i < character.length; i++) {
			  placeholder = i;
			  String tempItemName = "";
			  Character charAtPlaceholder = new Character(character[i]);
			  if (charAtPlaceholder.charValue() == ' ' || Character.isLetter(charAtPlaceholder.charValue()) == true) {
				  tempItemName = Character.toString(charAtPlaceholder.charValue());
				  //System.out.println("The character at position " + i + " matches expected value '" + charAtPlaceholder.charValue()+ "', storing '" + tempItemName + "' to variable tempItemName");
				  itemName.append(tempItemName);
				  }
			  else {
				  break;
				  }
			  }
		  
		  // Steps through the rest of character[] starting at the placeholder position and grabs the item price
		  for (int i = placeholder; i < character.length; i++) {
			  placeholder = i;
			  String tempItemPrice = "";
			  Character charAtPlaceholder = new Character(character[i]);
			  if ((charAtPlaceholder.charValue() == '.') || (Character.isDigit(charAtPlaceholder.charValue()) == true)) {
				  tempItemPrice = Character.toString(charAtPlaceholder.charValue());
				  //System.out.println("The character at position " + i + " matches expected value '" + charAtPlaceholder.charValue()+ "', storing '" + tempItemPrice + "' to variable tempItemQty");
				  itemPrice.append(tempItemPrice);
				  }
			  else {
				  break;
				  }
			  }
	  
		  String itemNameString = itemName.toString();
		  String itemPriceString = itemPrice.toString();
		  String itemQtyString = itemQty.toString();
		  
		  Item currentItem = new Item(itemNameString);
		  // System.out.println("Is item imported? " + currentItem.isImported());
		  // System.out.println("Item type: " + currentItem.getItemType());
		  ItemPrice currentItemPrice = new ItemPrice(itemPriceString);
		  ItemSalesTax currentItemSalesTax = new ItemSalesTax(currentItemPrice.getItemPrice());
		  ItemImportTax currentItemImportTax = new ItemImportTax(currentItemPrice.getItemPrice());
		  Quantity currentItemQty = new Quantity(itemQtyString);
		  CalcItemTotal currentItemTotal = new CalcItemTotal(currentItemPrice.getItemPrice(), Quantity.getQuantity());
		  
		  // Add the subtotal for each line to variable basketSubtotal
		  basketSubtotal = basketSubtotal.add(currentItemTotal.getItemSubtotal());
		  
		  // Summing up all taxes applicable to the current line and adding them to variable taxTotal
		  taxTotal = taxTotal.add(currentItemTotal.getItemTaxTotal());
		  
		  System.out.println(Quantity.getQuantity() + " " + itemNameString + ": " + (currentItemTotal.getItemSubtotal().add(currentItemTotal.getItemTaxTotal())));
		  }
	  
	  input.close();
	  System.out.println("Sales Taxes: " + taxTotal);
	  System.out.println("Total: " + (basketSubtotal.add(taxTotal)));
	  }
  }

