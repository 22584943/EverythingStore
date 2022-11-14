import java.util.Random;
import java.util.UUID;

public class Customer {
	private UUID id;
	private String name;
	private Address address;
	private String email;
	private String telephone;
	Random r = new Random();
	public Customer(String name, Address address, String email, String telephone) {
		this.id = new UUID(r.nextLong(), r.nextLong());
		this.name = name;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
	}
	
	public Customer getCustomer() {
		return this;
	}
	
	public UUID getID() {
		return this.id;
	}
	public String getCustomerName() {
		return this.name;
	}
	public String toString() {
		return "{" + id + ", " + name + ", " + address + ", " + email + ", " + telephone + "}";
	}
}