
public class Edge {
	private char leftVertice;
	private char rightVertice;
	private int cost;
	//Constructor number 0
	public Edge(char leftVertice,char rightVertice,int cost){
		this.leftVertice = leftVertice;
		this.rightVertice = rightVertice;
		this.cost = cost;
	}
	//Methods get
	public char getLeftVertice(){
		return this.leftVertice;
	}
	public char getRightVertice(){
		return this.rightVertice;
	}
	public int getCost(){
		return this.cost;
	}
	//Methods set
	public void setLeftVertice(char leftVertice){
		this.leftVertice = leftVertice;
	}
	public void setRightVertice(char rightVertice){
		this.rightVertice = rightVertice;
	}
	public void setCost(int cost){
		this.cost = cost;
	}
}
