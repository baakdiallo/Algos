
public class Account {
	private int balance;
	private int number;
	private int oldBalance;
	public Account(int balance,int number){
		this.oldBalance = this.balance = balance;
		this.number = number;
	}
	public int getBalcanceOfTheAccount(){
		return this.balance;
	}
	public int getNumberPfTheAccount(){
		return this.number;
	}
	public void setBalanceOfTheAccount(int balance){
		this.balance = balance;
	}
	public void depositBalanceIntoTheAccount(int balance){
		this.balance += balance;
	}
	public void withdrawalBalanceFromTheAccount(int balance){
		this.balance -= balance;
	}
	public  void setNumberOfTheAccount(int number){
		this.number = number;
	}
	public void setOldBalance(int balance){
		this.oldBalance = balance;
	}
	public void displayTheAccount(){
		System.out.println("Numero compteEpargne :" + this.number );
		System.out.println("Solde precedent : " + this.oldBalance);
	}
}
