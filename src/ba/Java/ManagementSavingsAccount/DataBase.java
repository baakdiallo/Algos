
public class DataBase {
	private int index;
	private int sizeOfTheDataBase;
	private Item[] recordings;
	public DataBase(int sizeOfTheDataBase){
		this.sizeOfTheDataBase = sizeOfTheDataBase;
		this.index = 0;
		this.recordings = new Item[this.sizeOfTheDataBase];
	}
	public int getTheIndex(){
		return this.index;
	}
	public void addRecordingIntoTheDataBase(Item item){
		this.recordings[this.index] = item;
		this.index++;
	}
	public void displayTheDataBase(){
		for(int i = 0; i < this.index; i++){
			this.recordings[i].displayTheItem();
		}
	}
	public int getIndexOfTheItemByName(String name ){
		int i = 0;
		boolean found = false;
		while(i < this.index && !found){
			String word = new String(this.recordings[i].getCustomer().getFristNameOfTheCustomer());
			if(word.equals(name)){
				found = true;
			}
			else{
				i++;
			}
		}
		if(found == true){
			return i;
		}
		else{
			return -1;//Error this number does no exist into the data base
		}
	}
	public void addAmount(String name,int amount ){
		int pos = this.getIndexOfTheItemByName(name);
		if(pos != -1){
			this.recordings[pos].addAmountIntoTheItem(amount);
		}
	}
	public void delAmount(String name,int amount){
		int pos = this.getIndexOfTheItemByName(name);
		if(pos != -1){
			this.recordings[pos].delAmountIntoTheItem(amount);	
		}
	}
}
