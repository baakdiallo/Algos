
public class LinkedList {
	private List head;//This is the head of my linked list. With this element we have the full access to the linked list 
	//This is my default constructor. It is used to make an empty list
	public LinkedList(){
		this.head = null;
	}
	//The next method is used to know is the linked list is empty or not
	public boolean isEmpty(){
		return (this.head == null);
	}//The next method is used to return the head of the linked List
	public List getHead(){
		return this.head;
	}
	//The next method is used to insert a data before the first list
	public void insertDataBeforeTheFirst(int data){
		this.head = List.insertDataIntoTheFirstList(data,this.head);
	}
	//The next method is used to insert a data after the last list
	public void insertDataAfterTheLast(int data){
		this.head = List.insertDataIntoTheLastList(data,this.head);
	}
	//The next method is used to display the set of data that are present into the linked list
	public void displayTheLinkedList(){
		List.displayAllDataOfTheList(this.head);
	}
	//THe next method is used to search a data into the linked List by its value
	public void searchDataByValFromTheLinkedList(int data){
		List p = List.searchDataByVal(this.head,data);
		if(p == null){
			System.out.println("Oups the data " + data + " was not found");
		}
		else{
			System.out.println("The data " + data + " was found");
		}
	}
	//The next method is used to search the data into the linked list by its position
	public void searchDataByPosFromTheLinkedList(int pos){
		List p = List.searchDataByPos(this.head,pos);
		if(p == null){
			System.out.println("Oups there is no data at the position " + pos + " was not found");
		}
		else{
			System.out.println("The data that was found at the position " + pos + " is : " + List.getTheDataOfTheList(p));
		}
	}
	//The next method is used to reverse the linked list
	public void reverseTheLinkedList(){
		this.head = List.reverseTheList(this.head);
	}
	//The next method is used to sort the linked list
	public void sortTheLinkedList(){
		List.sortTheList(this.head);
	}
	//The next method is used to return the minimum value of the linked list
	public void getTheMinimumOfTheLinkedList(){
		int min = List.getTheMinimumOfTheList(this.head);
		System.out.println("Min: " + min);
	}
	//The next method is used to return the maximum value of the linked list
	public void getTheMaximumOfTheLinkedList(){
		int max = List.getTheMaximumOfTheList(this.head);
		System.out.println("Max: " + max);
	}
	//The next method is used to remove a data from the by its value
	public void removeDataByValFromTheLinkedList(int data){
		this.head = List.removeDataByValFromTheList(data,this.head);
	}
	//The next method is used to remove a data from the list by its position
	public void removeDataByPosFromTheLinkedList(int pos){
		this.head = List.removeDataByPosFromTheList(pos,this.head);
	}
	//The next method is used to link together two link list without destroying them
	public void appendLinkedList(LinkedList q){
		this.head = List.append(this.head,q.getHead());
	}
	//THe next method is used to link together two linked list by destroying the first linked list
	public void nconcLinkedList(LinkedList q){
		List.nconc(this.head, q.getHead());
	}
}
