
public class LinkedList {
	public List head;
	public LinkedList(){this.head = null;}
	public boolean TheLinkedListIsEmpty(){
		if(this.head == null){
			return true;
		}
		else{
			return false;
		}
	}
	public void insertRecordingIntoTheLinkedListAtFirst(Recording data){
		this.head = List.insertListBeforeTheFirst(this.head,data);
	}
	public void insertRecordingIntoTheLinkedListAtLast(Recording data){
		this.head = List.insertListAfterTheLast(this.head, data);
	}
	public void displayTheLinkedList(){
		List.displayTheList(this.head);
		System.out.println("");//Go to the next line
	}
	public List searchListFromTheLinkedListByCode(int code){
		return List.searchListByTheRecordingCode(this.head, code);
	}
}
