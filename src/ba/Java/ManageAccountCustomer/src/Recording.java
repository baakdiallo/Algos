
public class Recording {
	private int indexHistorique = 0;
	private Customer key;
	private Transaction type;
	private Account value;
	private int code;
	private Operation[] historique = new Operation[10];
	public Recording(Customer key,Account value){this.key = key; this.value = value;} //This method is the constructor number zero
	//The next method is the constructor number one
	public Recording(Customer key,Account value,int code){
		this.key = key;
		this.value = value;
		this.code = code;
	}
	public Customer getKeyOfTheRecording(){
		return this.key;
	}
	public Transaction getTypeOfTheRecording(){
		return this.type;
	}
	public Account getValueOfTheRecording(){
		return this.value;
	}
	public int getCodeOfTheRecording(){
		return this.code;
	}
	public void setKeyOfTheRecording(Customer key){
		this.key = key;
	}
	public void setTypeOfTheRecording(Transaction type){
		this.type = type;
	}
	public void setValueOfTheRecording(Account value){
		this.value = value;
	}
	public void setCodeOfTherecording(int code){
		this.code = code;
	}
	public void OperationIntoTheRecording(int balance){
		if(this.type == Transaction.deposit){
			this.historique[this.indexHistorique] = new Operation(Transaction.deposit,5,0,balance);
			this.historique[this.indexHistorique].setOldSold(this.value.getBalcanceOfTheAccount() + this.historique[this.indexHistorique].balanceOfThisOperation);
			this.historique[this.indexHistorique].setNewSold(this.value.getBalcanceOfTheAccount() + this.historique[this.indexHistorique].balanceOfThisOperation + 5);
			this.value.depositBalanceIntoTheAccount(balance + 5);
		}
		else{
			this.historique[this.indexHistorique] = new Operation(Transaction.withdrawal,0,10,balance);
			this.historique[this.indexHistorique].setOldSold(this.value.getBalcanceOfTheAccount() - this.historique[this.indexHistorique].balanceOfThisOperation);
			this.historique[this.indexHistorique].setNewSold(this.value.getBalcanceOfTheAccount() - this.historique[this.indexHistorique].balanceOfThisOperation - 10);
			this.value.withdrawalBalanceFromTheAccount(balance + 10);
		}
		this.indexHistorique++;
	}
		
	
	public void displayTheRecording(){
		this.key.displayTheCustomer();
		this.value.displayTheAccount();
		if(this.indexHistorique != 0){
			System.out.println("Code                        Depot                     Retrait                   Solde");
			System.out.println(".............................................................................................");
			for(int i = 0; i <  this.indexHistorique; i++){
				this.historique[i].displayOperation();
			}
			this.indexHistorique = 0;
			this.value.setOldBalance(this.value.getBalcanceOfTheAccount());
		}
		
		System.out.println("");
	}
}
