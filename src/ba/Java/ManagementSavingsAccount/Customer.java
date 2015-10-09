
public class Customer {
	private String lastName;
	private String firstName;
	private String phone;//This is the primary key of the customer class because the phone is unique
	private Account account;
	LinkedList operations = new LinkedList();
	public Customer(String lastName,String firstName,String phone ){
		this.lastName = lastName;
		this.firstName = firstName;
		this.phone = phone;
		this.account = new Account(0);
		this.account.setMyCustomer(this);
	}
	public String getLastNameOfTheCustomer(){
		return this.lastName;
	}
	public String getFristNameOfTheCustomer(){
		return this.firstName;
	}
	public String getPhoneOfTheCustomer(){
		return this.phone;
	}
	public void setNameOfTheCustomer(String lastName){
		this.lastName = lastName;
	}
	public void setFirstNameOfTheCustomer(String firstName){
		this.firstName = firstName;
	}
	public void setPhoneOfTheCustomer(String phone){
		this.phone = phone;
	}
	public Transaction defineDepositTypeTransaction(int amount){
		DepositTransaction transaction = new DepositTransaction(amount);
		this.account.deposeAmountIntoTheAccount(transaction);
		return transaction;
	}
	public Transaction defineWithdrawalTypeTransaction(int amount){
		WithdrawalTransaction transaction = new WithdrawalTransaction(amount);
		this.account.withdrawalAmountFromTheAccount(transaction);
		return transaction;
	}
	public Account getTheAccountOfTheCustomer(){
		return this.account;
	}
	
}
