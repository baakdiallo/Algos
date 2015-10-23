
public class WithdrawalTransaction extends Transaction {
	private final int fine;
	public WithdrawalTransaction(int amount){
		super(TypeOfTransaction.withdrawal,amount);
		this.fine = 10;
	}
	public int getTheFine(){
		return this.fine;
	}
	public void displayTransaction(){
		System.out.println("ret                                                   " + this.amount + "                        " + this.oldSales);
		System.out.println("pen                                                   " + this.fine + "                         " + this.newSales);
	}
}
