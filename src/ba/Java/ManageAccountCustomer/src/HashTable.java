
public class HashTable {
	private int indexCreateAccount;
	private LinkedList dataBase[];
	private int size = -1;
	public HashTable(int size){
		this.indexCreateAccount = 0;//There are no recording instance 
		this.size = size;
		this.dataBase = new LinkedList[this.size];
		this.initializeTheDataBase();
	}
	public void initializeTheDataBase(){
		for(int i = 0; i < this.size; i++){
			this.dataBase[i] = new LinkedList();//At this moment all element of the array data base contains one list type head. So we consider that the Linked Lists are empty
		}
	}
	public int getHashCodeOfTheCustomerByHisPhone(String phone){
		int hashCode = 0;//Initialize the hash code
		int charCode = 0;//Initialize the character code
		for(int i = 0; i <  phone.length(); i++){
			charCode = (int) phone.charAt(i);
			hashCode = ((hashCode << 6) + (hashCode << 16) - hashCode) + charCode;
		}
		return Math.abs(hashCode);
	}
	public void insertItemIntoTheDataBase(String name,String firstName,String phone){
		int hashCode = this.getHashCodeOfTheCustomerByHisPhone(phone);
		int indexCode = hashCode % this.size;
		Customer gest = new Customer(name,firstName,phone);
		Account account = new Account(0,this.indexCreateAccount);//The first balance equals to zero.
		Recording recording = new Recording(gest,account,hashCode);
		this.dataBase[indexCode].insertRecordingIntoTheLinkedListAtLast(recording);
		this.indexCreateAccount++;
	}
	public List returnItemFromTheDataBase(String phone){
		int hashCode = this.getHashCodeOfTheCustomerByHisPhone(phone);
		int indexCode = hashCode % this.size;
		return (this.dataBase[indexCode].searchListFromTheLinkedListByCode(hashCode));
		
	}
	public void deleteItemFromTheDataBase(String phone){}
	public void displayTheDataBase(){
		for(int i = 0; i < this.size; i++){
			if(this.dataBase[i].TheLinkedListIsEmpty() == false){
				this.dataBase[i].displayTheLinkedList();
			}
		}
	}
	public void depositBalanceIntoTheDataBaseByPhone(int balance,String phone){
		List l = this.returnItemFromTheDataBase(phone);
		List.defineDepositTypeTransaction(l);
		List.operationOverTheBalance(l, balance);
	}
	public void withdrawalBalanceFromTheDataBaseByPhone(int balance,String phone){
		List l = this.returnItemFromTheDataBase(phone);
		List.defineWithdrawalTypeTransaction(l);
		List.operationOverTheBalance(l, balance);
	}
}
