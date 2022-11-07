import java.util.*;
public class Controller {
	static String inputSKU;
	static ArrayList<Product> products = new ArrayList<Product>(Arrays.asList());
	static String selection;
	static String inputCategory;
	static String inputDescription;
	static int inputPrice;
	static int intInput;
	
	// Create input scanner
	static Scanner in = new Scanner(System.in);
	
	//Check if product exists
	static public void checkIfProductExists(String SKU, ArrayList<Product> products) {
		boolean SKUAlreadyExists = false;
		 //Check if SKU already exists
		 for (Product product : products) {
			 if (product.getSKU().equals(SKU)) {
				 SKUAlreadyExists = true;
			 }
		 }
		 if (SKUAlreadyExists) {
			 System.out.println("SKU: " + inputSKU + " already exists. Please enter a unique SKU");
			 System.out.println("\nEnter product SKU");
			 inputSKU = in.nextLine();
			 // call method recursively
			 checkIfProductExists(inputSKU, products);
		 }
		 
	}
	
	
	public static void main(String[] args) {
		
		
		// POPULATE MOCK PRODUCTS
		 products.add(new Product(products.size() + 1, "123", "fish", "tuna", 50));
		 products.add(new Product(products.size() + 1, "128", "fish", "salmon", 20));
		 products.add(new Product(products.size() + 1, "124", "fish", "sardines", 5));
		 products.add(new Product(products.size() + 1, "125", "fish", "mackerel", 10));
		 products.add(new Product(products.size() + 1, "126", "fish", "swordfish", 100));
		 products.add(new Product(products.size() + 1, "127", "fish", "cod", 70));
		 
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
			System.out.println("[5] return ");
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
					System.out.println("sort item name ascending");
					
					// loop through each product
					for(int i=1; i < sortedProducts.size(); i++){  
						// compare each product to all the others
		                 for(int j=sortedProducts.size()-1; j >= i; j--){  
		                
		                          if(sortedProducts.get(j-1).getDescription().compareTo(sortedProducts.get(j).getDescription()) > 0){  
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
					System.out.println("sort by item descending ");
					// loop through each product
					for(int i=1; i < sortedProducts.size(); i++){  
						// compare each product to all the others
		                 for(int j=sortedProducts.size()-1; j >= i; j--){  
		                
		                          if(sortedProducts.get(j-1).getDescription().compareTo(sortedProducts.get(j).getDescription()) < 0){  
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
					break;
			 }
		 break;
		 
		 case "2":
			 System.out.println("\nSearch for a product by SKU");
			 String SKU = in.nextLine();
			 // code to find and display product based on SKU
			 System.out.println("SKU: " + SKU);
			 break;
			 
		 case "3":
			 
			 System.out.println("\nEnter product SKU");
			 inputSKU = in.nextLine();
			 
			 checkIfProductExists(inputSKU, products);
			 System.out.println("\nEnter product category");
			 inputCategory = in.nextLine();
			 System.out.println("\nEnter product description");
			 inputDescription = in.nextLine();
			 System.out.println("\nEnter product price");
			 inputPrice = in.nextInt();
			
			 // Create new product, add to arrayList
			 Product newProduct = new Product(products.size() + 1, inputSKU, inputCategory, inputDescription, inputPrice);
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
			 
		 } 
		 

		 } while (!selection.equals("99"));
	}

	
}