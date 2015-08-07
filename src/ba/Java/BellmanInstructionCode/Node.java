
public class Node {
	private char name;
	private int dist;
	private int index;
	private char predecessor;
	private LinkedList neighbord;
	//default constructor
	public Node(){
		this.dist = 2147483647;
		this.name = '?';
		this.neighbord = null;
		this.index = 0;
		this.predecessor = '!';
	}
	//this constructor is used to make all nodes
	public Node(char name,int index){
		this.dist = 2147483647;//largest integer
		this.name = name;
		this.neighbord = new LinkedList();
		this.index = index;
		this.predecessor = '!';
	}
	//this constructor is used to make the start of the path
	public Node(char name,int dist,int index){
		this.dist = dist;
		this.name = name;
		this.neighbord = new LinkedList();
		this.index = index;
		this.predecessor = '!';
	}
	//getters methods
	public char getName(){
		return this.name;
	}
	public int getIndex(){
		return this.index;
	}
	public int getDist(){
		return this.dist;
	}
	public char getPredecessor(){
		return predecessor;
	}
	public void whoAreYou(){
		if(!this.neighbord.isEmpty()){
			System.out.print(this.name + "----->"  );
			this.neighbord.displayData();
			System.out.println("");
		}
		else{
			System.out.print(this.name );
		}
		
	}
	public LinkedList getNeighbord(){
		return this.neighbord;
	}
	//setters methods
	public void setIndex(int index){
		this.index = index;
	}
	public void setName(char name){
		this.name = name;
	}
	public void setDist(int dist){
		this.dist = dist;
	}
	public void setPredecessor(char predecessor){
		this.predecessor = predecessor;
	}
	public void addNeighbord(List p){
		this.neighbord.addLast(p);
	}
}
