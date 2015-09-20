
public class Customer {
	private String name;
	private String firstName;
	private String phone;//This is the primary key of the customer class because the phone is unique
	public Customer(String name,String firstName,String phone ){
		this.name = name;
		this.firstName = firstName;
		this.phone = phone;
	}
	public String getNameOfTheCustomer(){
		return this.name;
	}
	public String getFristNameOfTheCustomer(){
		return this.firstName;
	}
	public String getPhoneOfTheCustomer(){
		return this.phone;
	}
	public void setNameOfTheCustomer(String name){
		this.name = name;
	}
	public void setFirstNameOfTheCustomer(String firstName){
		this.firstName = firstName;
	}
	public void setPhoneOfTheCustomer(String phone){
		this.phone = phone;
	}
	public void displayTheCustomer(){
		System.out.println("Nom : " + this.firstName + " " + this.name + " Tel : (221) " + this.phone);
	}
}
