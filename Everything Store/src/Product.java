public class Product {
 private int id; 
 private String SKU; //stock keeping unit (a unique code for each product)
 private String description;
 private String category;
 private int price;


	public Product(int id, String SKU, String description,String category, int price) {
		this.id = id;
		this.SKU = SKU;
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
	public String getSKU() {
		return SKU;
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
	
	public int getID() {
		return id;
	}
	
	// Setters
	
	public void setSKU(String newSKU) {
		this.SKU = newSKU;
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
	// toString
	
	public String toString() {
		return "ID: " + id + ", SKU: " + SKU + ", CATEGORY: " + category + ", DESCRIPTION: " + description + ", PRICE: " + price;
	}
	
	
}
