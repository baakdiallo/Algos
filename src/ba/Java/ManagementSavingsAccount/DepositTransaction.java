
public class DepositTransaction extends Transaction {
	private final int bonus;
	public DepositTransaction(int amount){
		super(TypeOfTransaction.deposit,amount);
		this.bonus = 5;
	}
	public int getTheBonus(){
		return this.bonus;
	}
	public void displayTransaction(){
		System.out.println("dep                         " + this.amount + "                                                 " + this.oldSales);
		System.out.println("bon                         " + this.bonus + "                                                    " + this.newSales);
	}
}
