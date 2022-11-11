import java.util.*;
import java.util.stream.Collectors;
public class Controller {
	private static String selection;
	private static int inputStock;
	private static String inputCategory;
	private static String inputName;
	private static String inputDescription;
	private static int inputPrice;
	private static ArrayList<Product> products = new ArrayList<Product>(Arrays.asList());
	private static ArrayList<String> categories = new ArrayList<String>(Arrays.asList());
	private static ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList());
	// Create input scanner
	static Scanner in = new Scanner(System.in);
	
	//Check if product exists
	static public boolean checkIfProductUnique(String name, String description, ArrayList<Product> products) {
		boolean nameAlreadyExists = false;
		boolean descriptionAlreadyExists = false;
		 //Check if SKU already exists
		 for (Product product : products) {
			 if (product.getName().equals(name)) {
				 nameAlreadyExists = true;
			 }
			 if (product.getDescription().equals(description)) {
				 descriptionAlreadyExists = true;
			 }
		 }
		 if (nameAlreadyExists || descriptionAlreadyExists) {
			 String errorType = "";
			 if (nameAlreadyExists) {
				 errorType += "\nProduct name already exists. ";
			 } 
			 if (descriptionAlreadyExists) {
				 errorType += "\nProduct description already exist. ";
			 }
			 System.out.println(errorType + "Please ensure you enter a unique name and description");
			 System.out.println("\nEnter product name");
			 inputName = in.nextLine();
			 
			 System.out.println("\nEnter product description");
			 inputDescription = in.nextLine();
			 // call method recursively
			 checkIfProductUnique(inputName, inputDescription, products);
		 } 
		 
		
			 
		 return true;
		 
		 
	}
	// get categories
	static public ArrayList<String> getCategories() {
		for (Product product : products) {
			String category = product.getCategory();
			if (!categories.contains(product.getCategory())) {
				categories.add(category);
			}
		}
		return categories;
	}
	
	
	public static void main(String[] args) {
		
		Random r = new Random();
		// POPULATE MOCK PRODUCTS
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "fish", "tuna", "massive fish from atlantic", 50));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "fish", "salmon", "big fish from North Sea",20));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "cereal", "Coco Pops","tiny fish from atlantic", 5));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "fish", "mackerel", "small fish from atlantic",10));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "cereal", "Frosties", "tropical fish",100));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "fish", "cod", "white fish from atlantic",70));
		 
		 ArrayList<Product> sortedProducts;
		 
		 do {
		 System.out.println("--------------------");
		 System.out.println("The Everything Store");
		 System.out.println("Choose from these options");
		 System.out.println("--------------------");
		 System.out.println("[1] List all Products");
		 System.out.println("[2] Search for a product by SKU");
		 System.out.println("[3] Add a product");
		 System.out.println("[4] Delete a product");
		 System.out.println("[5] View Customers");
		 System.out.println("[6] Add a Customer");
		 // insert code to print remaining options
		 System.out.println("[99] Exit");
		 System.out.println();
		 selection = in.nextLine();
		 switch (selection) {
		 case "1":
			 // create shallow copy
			 sortedProducts = new ArrayList<Product>(Arrays.asList());
			 for (Product product : products) {
				 sortedProducts.add(product);
						 
			 }
			 System.out.println("There are " + products.size() + " items in the shop");
			 System.out.println("-----------------------------");
			 if (products.size() > 0) System.out.println("PRODUCTS: ");
			 
			for (Product product : products) {
				System.out.println(product.toString());
					 
			 }
			
			// ASK TO ORDER BY PRICE
			System.out.println("OPTIONS: ");
			System.out.println("[1] Sort by price ASCENDING ");
			System.out.println("[2] Sort by price DESCENDING ");
			System.out.println("[3] Sort by item name ASCENDING ");
			System.out.println("[4] Sort by item name DESCENDING ");
			System.out.println("[5] View items by CATEGORY ");
			System.out.println("[6] return ");
			System.out.println("-------------");
			selection = in.nextLine();
				switch(selection) {
				case "1":
					System.out.println("sort price ascending");
					// create deep copy of array for sorting
					
					// implement bubble sort
					// The inner loop checks adjacent elements in the array, looking for 
					// out-of-order elements. When an out-of-order element pair is found, 
					// the two elements are exchanged. With each pass, the smallest of the 
					// remaining elements moves into its proper location. The outer loop causes 
					// this process to repeat until the entire array has been sorted
					
					// loop through each product
					for(int i=1; i < sortedProducts.size(); i++){  
						// compare each product to all the others
		                 for(int j=sortedProducts.size()-1; j >= i; j--){  
		                
		                          if(sortedProducts.get(j-1).getPrice() > sortedProducts.get(j).getPrice()){  
		                                 //swap elements  
		                                 Product temp = sortedProducts.get(j-1);  
		                                 sortedProducts.set(j-1, sortedProducts.get(j));  
		                                 sortedProducts.set(j, temp);  
		                         }  
		                          
		                 }  
					}
					for (int i=0; i<sortedProducts.size(); i++) {
						System.out.println(sortedProducts.get(i));
					}
					break;
				case "2":
					System.out.println("sort by price descending ");
					// loop through each product
					for(int i=1; i < sortedProducts.size(); i++){  
						// compare each product to all the others
		                 for(int j=sortedProducts.size()-1; j >= i; j--){  
		                
		                          if(sortedProducts.get(j-1).getPrice() < sortedProducts.get(j).getPrice()){  
		                                 //swap elements  
		                                 Product temp = sortedProducts.get(j-1);  
		                                 sortedProducts.set(j-1, sortedProducts.get(j));  
		                                 sortedProducts.set(j, temp);  
		                         }  
		                          
		                 }  
					}
					for (int i=0; i<sortedProducts.size(); i++) {
						System.out.println(sortedProducts.get(i));
					}
					break;
				case "3":
					System.out.println("sort item alphabetically ascending");
					
					// loop through each product
					for(int i=1; i < sortedProducts.size(); i++){  
						// compare each product to all the others
		                 for(int j=sortedProducts.size()-1; j >= i; j--){  
		                
		                          if(sortedProducts.get(j-1).getName().compareTo(sortedProducts.get(j).getName()) > 0){  
		                                 //swap elements  
		                                 Product temp = sortedProducts.get(j-1);  
		                                 sortedProducts.set(j-1, sortedProducts.get(j));  
		                                 sortedProducts.set(j, temp);  
		                         }  
		                          
		                 }  
					}
					for (int i=0; i<sortedProducts.size(); i++) {
						System.out.println(sortedProducts.get(i));
					}
					break;
				case "4":
					System.out.println("sort by item alphabetically descending ");
					// loop through each product
					for(int i=1; i < sortedProducts.size(); i++){  
						// compare each product to all the others
		                 for(int j=sortedProducts.size()-1; j >= i; j--){  
		                
		                          if(sortedProducts.get(j-1).getName().compareTo(sortedProducts.get(j).getName()) < 0){  
		                                 //swap elements  
		                                 Product temp = sortedProducts.get(j-1);  
		                                 sortedProducts.set(j-1, sortedProducts.get(j));  
		                                 sortedProducts.set(j, temp);  
		                         }  
		                          
		                 }  
					}
					for (int i=0; i<sortedProducts.size(); i++) {
						System.out.println(sortedProducts.get(i));
					}
					break;
					
				case "5":
					System.out.println("SELECT CATEGORY");
					// get categories
					ArrayList<String> categories = getCategories();
					ArrayList<Product> categoryItems = new ArrayList<Product>();
					for (String category : categories) {
						System.out.println("[" + categories.indexOf(category) + "] " + category);
					}
					// print categories
					
					int inputCategoryIndex = in.nextInt();
					
					// filter product matching selected category
					for (Product product : products) {
						if (product.getCategory().equals(categories.get(inputCategoryIndex))) {
							categoryItems.add(product);
						}	
					}
					
					// print out selected category products
					for (Product product : categoryItems) {
						System.out.println(product);
						
					}
					
					
					
					break;	
				case "6":
					break;
			 }
		 break;
		 
		 case "2":
			 System.out.println("\nSearch for a product by SKU");
			 String inputSKU = in.nextLine();
			 // code to find and display product based on SKU
			 // filter products to match input SKU
			 List<Product> productMatch = products
					  .stream()
					  .filter(p -> p.getSKU().equals(inputSKU))
					  .collect(Collectors.toList());
			 System.out.println(productMatch.get(0));
			 break;
			 
		 case "3":
			 
			 
			 
			 
//			 System.out.println("\nEnter product SKU");
//			 inputSKU = in.nextLine();
			 System.out.println("\nEnter product category");
			 inputCategory = in.nextLine();
			 System.out.println("\nEnter initialStock");
			 inputStock = in.nextInt();
			 System.out.println("\nEnter product name");
			 inputName = in.nextLine();
			
			 System.out.println("\nEnter product description");
			 inputDescription = in.nextLine();
			//TODO make checkIfProductExists more robust - check item name and description
			checkIfProductUnique(inputName, inputDescription, products);
			System.out.println("\nEnter product price");
			inputPrice = in.nextInt();
				 
				
			// Create new product, add to arrayList
			Product newProduct = new Product(new UUID(r.nextLong(), r.nextLong()), inputStock, inputCategory, inputName, inputDescription, inputPrice);
			products.add(newProduct);
			 break;
			 
			 
			 
		 case "4":
			 System.out.println("Enter an SKU to delete product: ");
			 String SKUToDelete = in.nextLine();
			 int totalProducts = products.size();
			 // remove matching product
			 products.removeIf(item -> item.getSKU().equals(SKUToDelete));
			 
			 if (products.size() < totalProducts) {
				 // if product removed, print updated store
				 System.out.println("UPDATED STORE");
				 for (Product product : products) {
						 System.out.println(product.toString());
				}
			 } else {
				 System.out.println("Product not found");
			 }
			 break;
		 case "5":
			 for (Customer customer : customers) {
				 System.out.println(customer);
			 }
			 break;
			 
		 case "6":
			 String customerName;
			 String houseNumber;
			 String firstLine;
			 String secondLine;
			 String countyState;
			 String postcode;
			 String country;
			 String email;
			 String telephone;
			 System.out.println("\nEnter customer name");
			 customerName = in.nextLine();
			 System.out.println("\nEnter house number/name");
			 houseNumber = in.nextLine();
			 System.out.println("\nEnter street name");
			 firstLine = in.nextLine();
			 System.out.println("\nEnter town");
			 secondLine = in.nextLine();
			 System.out.println("\nEnter county/state");
			 countyState = in.nextLine();
			 System.out.println("\nEnter postcode");
			 postcode = in.nextLine();
			 System.out.println("\nEnter country");
			 country = in.nextLine();
			 System.out.println("\nEnter email");
			 email = in.nextLine();
			 System.out.println("\nEnter telephone");
			 telephone = in.nextLine();
			 Address address = new Address(houseNumber, firstLine, secondLine, countyState, postcode, country);
			 Customer newCustomer = new Customer(customerName, address, email, telephone);
			 customers.add(newCustomer);
			 
			 break; 
		 } 
		 
		 
		 } while (!selection.equals("99"));
	}

	
}