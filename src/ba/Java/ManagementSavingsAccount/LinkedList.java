
public class LinkedList {
	private List leader;
	protected LinkedList(){
		this.leader = null;
	}
	protected boolean isEmpty(){
		if(this.leader == null){
			return true;
		}
		else{
			return false;
		}
	}
	protected  void insertDataBeforeTheFirstList(Receipt data){
		this.leader = List.insertDataInTheHead(data,this.leader);
	}
	protected void insertDataAfterTheLastList(Receipt data){
		this.leader = List.insertDataInTheTail(data,this.leader);
	}
	protected void removeTheFirstList(){
		this.leader = List.removeTheHeadDataOfTheList(this.leader);
	}
	protected void removeTheLastList(){
		List.removeTheTailDataOfTheList(this.leader);
	}
	protected List getTheHeadList(){
		return List.getTheHeadOfTheList(this.leader);
	}
	protected List getTheTailList(){
		return List.getTheTailOfTheList(this.leader);
	}
	protected void displayTheLinkedList(){
		List.displayAllCellOfTheList(this.leader);
	}
}
