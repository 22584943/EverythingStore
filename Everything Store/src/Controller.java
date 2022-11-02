import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Controller {
	// Create input scanner
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Product> products = new ArrayList<Product>(Arrays.asList());
		String selection;
		//
		
		String inputSKU;
		String inputCategory;
		String inputDescription;
		int inputPrice;
		
		int intInput;
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
		 
	//		 for (int i = 0; i < products.length; i++){
	//		 System.out.println(products[i].getSKU());
	//		 }
			 System.out.println("There are " + products.size() + " items in the shop");
			 System.out.println("-----------------------------");
			 if (products.size() > 0) System.out.println("PRODUCTS: ");
			 
			for (Product product : products) {
				System.out.println(product.toString());
					 
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
			 
			 products.removeIf(item -> item.getSKU().equals(SKUToDelete));
			 
			 for (Product product : products) {
					 System.out.println(product.toString());
			}
			 break;
			 
		 } 
		 

		 } while (!selection.equals("99"));
	}
}