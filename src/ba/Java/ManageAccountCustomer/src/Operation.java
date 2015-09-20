
public class Operation {
	Transaction typeOperation;
	int balanceOfThisOperation;
	int bon;
	int pen;
	int oldSold;
	int newSold;
	public Operation(Transaction typeOperation,int bon,int pen,int montant){
		this.typeOperation = typeOperation;
		this.pen = pen;
		this.bon = bon;
		this.oldSold = 0;
		this.newSold = 0;
		this.balanceOfThisOperation = montant;
	}
	public void setOldSold(int oldSold){
		this.oldSold = oldSold;
	}
	public void setNewSold(int newSold){
		this.newSold = newSold;
	}
	public int getNewSold(){
		return this.newSold;
	}
	public void displayOperation(){
		if(this.typeOperation == Transaction.deposit){
			System.out.println("dep                         " + this.balanceOfThisOperation + "                                                 " + this.oldSold);
			System.out.println("bon                         " + this.bon + "                                                    " + this.newSold);
		}
		else{
			System.out.println("ret                                                   " + this.balanceOfThisOperation + "                        " + this.oldSold);
			System.out.println("pen                                                   " + this.pen + "                         " + this.newSold);
		}
	}

}
