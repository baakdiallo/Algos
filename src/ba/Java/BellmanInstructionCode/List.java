
public class List {
	private char name;
	private int cost;
	private int index;
	private List next;
	//Constructor number 0
	public List(){
		this.name = '?';
		this.cost = 0;
		this.index = 0;
		this.next = null;
	}
	public List(char name,int cost,int index){
		this.name = name;
		this.cost = cost;
		this.index = index;
		this.next = null;
	}
	//get Methods
	public char getName(){
		return this.name;
	}
	public int getCost(){
		return this.cost;
	}
	public int getIndex(){
		return this.index;
	}
	public List getNext(){
		return this.next;
	}
	//set Methods
	public void setName(char name){
		this.name = name;
	}
	public void setCost(int cost){
		this.cost = cost;
	}
	public void setIndex(int index){
		this.index = index;
	}
	public void setNext(List next){
		this.next = next;
	}
}
