
public class Account {
	private static int indexCreateCompte = 0;//This variable is used to know the number of the current object.
	private int sales;
	private int number;
	private Customer customer;
	public Account(int sales){
		this.sales = sales;
		this.number = indexCreateCompte;
		indexCreateCompte++;
	}
	public Customer getMyCustomer(){
		return this.customer;
	}
	public void setMyCustomer(Customer customer){
		this.customer = customer;
	}
	public int getSalesOfTheAccount(){
		return this.sales;
	}
	public int getNumberOfTheAccount(){
		return this.number;
	}
	public void setSalesOfTheAccount(int sales){
		this.sales = sales;
	}
	public  void setNumberOfTheAccount(int number){
		this.number = number;
	}
	public void deposeAmountIntoTheAccount(DepositTransaction transaction){
		this.sales += transaction.getAmountOfTheTransaction();
		transaction.setTheOldSales(this.sales);
		this.sales += transaction.getTheBonus();
		transaction.setTheNewSales(this.sales);
	}
	public void withdrawalAmountFromTheAccount(WithdrawalTransaction transaction){
		this.sales -= transaction.getAmountOfTheTransaction();
		transaction.setTheOldSales(this.sales);
	    this.sales -= transaction.getTheFine();
		transaction.setTheNewSales(this.sales);
	}
}
