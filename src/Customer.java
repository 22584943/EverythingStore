import java.util.ArrayList;
import java.util.Random;



public class Customer {
	private int id;
	private String name;
	private String address;
	private String email;
	private String telephone;
//	private static ArrayList<Customer> customers;
	static Random r = new Random();
	static int n = r.nextInt(5000);
	
	public static int getNewCustomerID(ArrayList<Customer>customers) {
		
		
		// check for unique IDs
		for (Customer c : customers) {
			if (n == c.getID()) {
				n = r.nextInt(5000);
				getNewCustomerID(customers);
			} 
		}
		return n;
		
	}
	
	
public Customer(String name, String address, String email, String telephone, ArrayList<Customer> customers) {
		
		this.id = getNewCustomerID(customers);
		this.name = name;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
//		Customer.customers = customers;
	}

public Customer(int id, String name, String address, String email, String telephone) {
	
	this.id = id;
	this.name = name;
	this.address = address;
	this.email = email;
	this.telephone = telephone;
//	Customer.customers = customers;
}
	public Customer getCustomer() {
		return this;
	}
	
	public int getID() {
		return this.id;
	}
	public String getCustomerName() {
		return this.name;
	}
	public String toString() {
		return "{" + id + ", " + name + ", " + address + ", " + email + ", " + telephone + "}";
	}
}