
public class Vertice {
	private char name;
	private Color state;
	private int value;
	private char predecessor;
	private int indice;
	//Constructor number 0
	public Vertice(){
		this.name = '?';
		this.state = Color.white;
		this.value = 2147483647;//Largest integer
		this.predecessor = '?';
		this.indice = 0;
	}
	//Constructor number 1 is used to initialize the heap
	public Vertice(char name,int indice){
		this.name = name;
		this.state = Color.white;
		this.value = 2147483647;//Largest integer
		this.predecessor = '?';
		this.indice = indice;
	}
	//Constructor number 2 is uses for the first value in the heap
	public Vertice(char name,int indice,int value){
		this.name = name;
		this.state = Color.white;
		this.value = value;//Default value
		this.predecessor = '?';
		this.indice = indice;
	}
	//Methods get
	public char getName(){
		return this.name;
	}
	public Color getState(){
		return this.state;
	}
	public int getValue(){
		return this.value;
	}
	public char getPredecessor(){
		return this.predecessor;
	}
	public int getIndice(){
		return this.indice;
	}
	public boolean isMarked(){
		return (this.state == Color.black);
	}
	//Methods set
	public void setName(char name){
		this.name = name;
	}
	public void setState(Color state){
		this.state = state;
	}
	public void setValue(int value){
		this.value = value;
	}
	public void setPredecessor(char predecessor){
		this.predecessor = predecessor;
	}
}
