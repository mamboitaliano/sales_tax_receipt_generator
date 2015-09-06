package taxes;

public class Item {
	
	static String item;
	boolean imported;
	ItemType itemType;
	
	// Construct a default item
	public Item() {
		//default constructor
	}
	
	// Construct an item with specified item name
	public Item(String item) {
		Item.item = item;
	}
	
	public String getItemName() {
		return item;
	}
	
	// Returns item type
	public ItemType getItemType() {
		
		if(item.contains("book") == true) {
			this.itemType = ItemType.BOOK;
			return itemType;
		}
		else if(item.contains("chocolate") == true || item.contains("apple") == true || item.contains("gum") == true || item.contains("wine") == true) {
			this.itemType = ItemType.FOOD;
			return itemType;
		}
		else if(item.contains("pills") == true) {
			this.itemType = ItemType.MEDICAL;
			return itemType;
		}
		else {
			this.itemType = ItemType.OTHER;
			return itemType;
		}
	}
	
	// Returns whether the item is imported
	public static boolean isImported() {
		if (item.contains("imported") == true) {
			return true;
		}
		else {
			return false;
		}
	}
}
