
public abstract class Transaction {
	protected TypeOfTransaction type;
	protected int amount;
	protected int oldSales = 0;
	protected int newSales = 0;
	public Transaction(TypeOfTransaction type,int amount){
		this.type = type;
		this.amount = amount;
	}
	protected int getAmountOfTheTransaction(){
		return this.amount;
	}
	protected void setAmountOfTheTransaction(int amount){
		this.amount = amount;
	}
	protected int getTheOldSales(){
		return this.oldSales;
	}
	protected void setTheOldSales(int oldSales){
		this.oldSales = oldSales;
	}
	protected int getTheNewSales(){
		return this.newSales;
	}
	protected void setTheNewSales(int newSales){
		this.newSales = newSales;
	}
	public void displayTransaction(){}
}
