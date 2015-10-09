
public class Receipt {
	private Transaction transaction;
	public Receipt(Transaction transaction){
		this.transaction = transaction;
	}
	public Transaction getTrsanction(){
		return this.transaction;
	}
	public void setTransaction(Transaction transaction){
		this.transaction = transaction;
	}
	public void displayReceipt(){
		this.transaction.displayTransaction();
	}
}
