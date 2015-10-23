
public class Statement {
	LinkedList historic;
	public Statement(){
		this.historic = new LinkedList();
	}
	public void addTransaction(Receipt receipt){
		this.historic.insertDataAfterTheLastList(receipt);
	}
	public void displayTheStatementOfTheCustomer(){
		this.historic.displayTheLinkedList();
	}
}
