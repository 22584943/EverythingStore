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
	private static ArrayList<Product> sortedProducts;
	private static ArrayList<String> categories = new ArrayList<String>(Arrays.asList());
	private static ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList());
	static Random r = new Random();
	// Create input scanner
	static Scanner in = new Scanner(System.in);
	
	
	public static void main(String[] args) {
			
			 populateProducts();
			 populateCustomers();
			 do {	 
			 printPrimaryMenu();
			 switch (selection) {
			 case "1":
				showProducts();
				printSortMenu();
				selection = in.nextLine();
				switch(selection) {
				case "1": sortProducts("price", "ascending"); break;
				case "2": sortProducts("price","descending"); break;
				case "3": sortProducts("name", "ascending"); break;
				case "4": sortProducts("name", "descending"); break;
				case "5": showCategoryMenu(); break;	
				case "6":break;
			 }
			 break;
	
			 case "2":
				 searchProductBySKU();
				 break;
				 
			 case "3":
				 addNewProduct();
				 break;
				 
			 case "4":
				 deleteProductBySKU();
				 break;
				 
			 case "5":
				 showCustomers();
				 break;
				 
			 case "6":
				 addNewCustomer();
				 break; 
			 case "7":
				 deleteCustomer();
				 break;
			 } 
			 
			 
			 } while (!selection.equals("99"));
		}
		
	static void showCustomers() {
		 for (Customer customer : customers) {
			 System.out.println(customer);
		 }
	}
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
	
	static public void showCategoryMenu() {
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
	}
	static public void populateProducts() {
		
		// POPULATE MOCK PRODUCTS
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "fish", "tuna", "massive fish from atlantic", 50));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "fish", "salmon", "big fish from North Sea",20));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "cereal", "Coco Pops","tiny fish from atlantic", 5));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "fish", "mackerel", "small fish from atlantic",10));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "cereal", "Frosties", "tropical fish",100));
		 products.add(new Product(new UUID(r.nextLong(), r.nextLong()), 100, "fish", "cod", "white fish from atlantic",70));
	}
	
	static public void populateCustomers() {
		 
		customers.add(new Customer("Harry Styles", new Address("108", "Styles Mansion", "Hollywood", "California", "HL 4738", "USA"), "harry@mail.com", "064387477"));
		customers.add(new Customer("Eric Cantona", new Address("288", "France Street", "London", "Greater London", "NH4 S83", "UK"), "eric@mail.com", "087776345"));
		customers.add(new Customer("Fred East", new Address("12", "Church Street", "Stockport", "Cheshire", "SK8 6HF", "UK"), "fred@mail.com", "0543789345"));
		customers.add(new Customer("Jammy Dodger", new Address("1", "Biscuit Lane", "Sweettown", "Blobshire", "BB33 4LG", "Chocolateland"), "jammy@mail.com", "095432345"));
		 customers.add(new Customer("Master  Bourbon", new Address("23", "Chocolate Boulevard", "Chocton", "Chocshire", "CH3 2CC", "Chocolateland"), "bourbon@mail.com", "0774345"));
	}
	
	static public void printPrimaryMenu() {
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
		 System.out.println("[7] Delete a Customer");
		 // insert code to print remaining options
		 System.out.println("[99] Exit");
		 System.out.println();
		 selection = in.nextLine();
	}
	
	static public void printSortMenu() {

		// ASK TO ORDER BY PRICE
		System.out.println("OPTIONS: ");
		System.out.println("[1] Sort by price ASCENDING ");
		System.out.println("[2] Sort by price DESCENDING ");
		System.out.println("[3] Sort by item name ASCENDING ");
		System.out.println("[4] Sort by item name DESCENDING ");
		System.out.println("[5] View items by CATEGORY ");
		System.out.println("[6] return ");
		System.out.println("-------------");
	}
	
	static public void addNewProduct() {
//		 System.out.println("\nEnter product SKU");
//		 inputSKU = in.nextLine();
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
	}
	static public void searchProductBySKU() {
		System.out.println("\nSearch for a product by SKU");
		 String inputSKU = in.nextLine();
		 // code to find and display product based on SKU
		 // filter products to match input SKU
		 List<Product> productMatch = products
				  .stream()
				  .filter(p -> p.getSKU().equals(UUID.fromString(inputSKU)))
				  .collect(Collectors.toList());
		 System.out.println(productMatch.get(0));
		 
	}
	static public void addNewCustomer() {
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
	}
	
	static public void deleteCustomer() {
		
		System.out.println("\nEnter customer name");
		String customerToDelete = in.nextLine();
		// change to lowercase for case insensitive search
		List<Customer> customerMatch = customers
				  .stream()
				  .filter(p -> p.getCustomerName().toLowerCase().contains(customerToDelete.toLowerCase()))
				  .collect(Collectors.toList());
		System.out.println("Is this the customer you wish to delete? Y/N");
		UUID customerIDToDelete;
		if (customerMatch.size() > 0) {
			System.out.println(customerMatch.get(0));
			customerIDToDelete = customerMatch.get(0).getID();
			String confirmDelete = in.nextLine();
			if (confirmDelete.toLowerCase().equals("y")) {
				customers.removeIf(customer -> customer.getID().equals(customerIDToDelete));
			} else {
				System.out.println("NOT DELETED");
			}
		}
		showCustomers();
		
		
		 
		
	}
	static public void showProducts() {
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
	}
	
	static public void sortProducts(String sortType, String sortDirection) {
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
            	 if (sortType == "price") {
	            	 if (sortDirection == "ascending") {
	                      if(sortedProducts.get(j-1).getPrice() > sortedProducts.get(j).getPrice()){  
	                             //swap elements  
	                             Product temp = sortedProducts.get(j-1);  
	                             sortedProducts.set(j-1, sortedProducts.get(j));  
	                             sortedProducts.set(j, temp);  
		                     }  
		                      
		             } else {
		            	 if(sortedProducts.get(j-1).getPrice() < sortedProducts.get(j).getPrice()){  
	                         //swap elements  
	                         Product temp = sortedProducts.get(j-1);  
	                         sortedProducts.set(j-1, sortedProducts.get(j));  
	                         sortedProducts.set(j, temp);  
	                     }  
		             }
	             } else if (sortType =="name") {
	            	 if (sortDirection == "ascending") {
		            	 System.out.println("sort item alphabetically ascending");
							
							// loop through each product
							for(int a=1; a < sortedProducts.size(); a++){  
								// compare each product to all the others
				                 for(int b=sortedProducts.size()-1; b >= a; b--){  
				               
				                          if(sortedProducts.get(b-1).getName().toLowerCase().compareTo(sortedProducts.get(b).getName().toLowerCase()) > 0){  
				                                 //swap elements  
				                                 Product temp = sortedProducts.get(b-1);  
				                                 sortedProducts.set(b-1, sortedProducts.get(b));  
				                                 sortedProducts.set(b, temp);  
				                         }  
				                          
				                 }  
							}
	            	 } else {
	            	 
	            		System.out.println("sort by item alphabetically descending ");
	 					// loop through each product
	 					for(int a=1; a < sortedProducts.size(); a++){  
	 						// compare each product to all the others
	 		                 for(int b=sortedProducts.size()-1; b >= a; b--){  
	 		                
	 		                          if(sortedProducts.get(b-1).getName().toLowerCase().compareTo(sortedProducts.get(b).getName().toLowerCase()) < 0){  
	 		                                 //swap elements  
	 		                                 Product temp = sortedProducts.get(b-1);  
	 		                                 sortedProducts.set(b-1, sortedProducts.get(b));  
	 		                                 sortedProducts.set(b, temp);  
	 		                         }  
	 		                          
	 		                 }  
	 					}
	            	 
	            	 }
						
						
	             }
             }
	
		}
	
		// Print out products
		for (int i=0; i<sortedProducts.size(); i++) {
			System.out.println(sortedProducts.get(i));
		}
	}
	
	static public void deleteProductBySKU() {
		System.out.println("Enter an SKU to delete product: ");
		 String SKUToDelete = in.nextLine();
		 int totalProducts = products.size();
		 // remove matching product
		 products.removeIf(item -> item.getSKU().equals(UUID.fromString(SKUToDelete)));
		 
		 if (products.size() < totalProducts) {
			 // if product removed, print updated store
			 System.out.println("UPDATED STORE");
			 for (Product product : products) {
					 System.out.println(product.toString());
			}
		 } else {
			 System.out.println("Product not found");
		 }
		 
	}
	

	
}