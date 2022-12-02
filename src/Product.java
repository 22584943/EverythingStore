import java.util.UUID;

public class Product {
 private UUID SKU; //stock keeping unit (a unique code for each product)
 private int stock;
 private String name;
 private String description;
 private String category;
 private int price;


	public Product(UUID SKU, int initialStock, String category, String name, String description, int price) {
		this.SKU = SKU;
		this.stock = initialStock;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	
//	public Product(int id, String SKU) {
//		this.id = id;
//		this.SKU = "some product";
//		this.description = "best product ever";
//		this.category = "category x";
//		this.price = 1000;
//	}
	
	// Getters
	public String get() {
		return this.toString();
	}
	public UUID getSKU() {
		return SKU;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getPrice() {
		return price;
	}
	
	
	public int getStock( ) {
		return stock;
	}
	// Setters
	
	public void setSKU(UUID newSKU) {
		this.SKU = newSKU;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}
	
	public void setCategory(String newCategory) {
		this.category = newCategory;
	}
	
	public void setPrice(int newPrice) {
		this.price = newPrice;
	}
	
	public void incrementStock(int newStock ) {
		this.stock += newStock;
	}
	// toString
	
	public String toString() {
		return "SKU: " + SKU + ", CATEGORY: " + category + " , NAME: " + name + ", DESCRIPTION: " + description + ", PRICE: " + price;
	}
	
	
}