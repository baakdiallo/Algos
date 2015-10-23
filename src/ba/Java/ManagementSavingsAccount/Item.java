
public class Item {
	private int sale = 0;
	private Customer customer;
	private Statement statement;
	public Item(Customer customer){
		this.customer = customer;
		this.statement = new Statement();
	}
	public int getTheSale(){
		return this.sale;
	}
	public void setTheSale(int sale){
		this.sale = sale;
	}
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	public void setStatement(Statement statement){
		this.statement = statement;		
	}
	public Customer getCustomer(){
		return this.customer;
	}
	public Statement getStatement(){
		return this.statement;
	}
	public void addAmountIntoTheItem(int amount){
		Receipt receipt = new Receipt(this.customer.defineDepositTypeTransaction(amount));
		this.statement.addTransaction(receipt);
	}
	public void delAmountIntoTheItem(int amount){
		Receipt receipt = new Receipt(this.customer.defineWithdrawalTypeTransaction(amount));
		this.statement.addTransaction(receipt);
	}
	public void displayTheItem(){
		Customer gest = this.getCustomer();
		Account  acct = gest.getTheAccountOfTheCustomer();
		System.out.println("Nom : " + gest.getFristNameOfTheCustomer() + " " + gest.getLastNameOfTheCustomer() + " Tel : (221) " + gest.getPhoneOfTheCustomer());
		System.out.println("Numero compteEpargne : " + acct.getNumberOfTheAccount() );
		System.out.println("Solde precedent : " + this.sale);
		System.out.println("--------------------------------------------------------------------------------------------");
		this.statement.displayTheStatementOfTheCustomer();
		this.setTheSale(acct.getSalesOfTheAccount());
		this.statement = new Statement();//Empty the statement of this customer
		
	}
	
}
