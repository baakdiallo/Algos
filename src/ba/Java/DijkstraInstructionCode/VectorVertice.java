
public class VectorVertice {
	private int size;
	private int index;
	private Vertice[] data;
	public VectorVertice(int size){
		this.size = size;
		this.index = 0;
		data = new Vertice[this.size];
	}
	public int getSize(){
		return this.size;
	}
	public void addValue(Vertice v){
		this.data[this.index] = v;
		this.index++;
	}
	public Vertice getVerticeByIndice(int indice){
		int i = 0;
		while(i < this.index && this.data[i].getIndice() != indice){
			i++;
		}
		if (i < this.index){
			return this.data[i];
		}
		else{
			return null;
		}
	}
	public Vertice getVerticeByName(char name){
		int i = 0;
		while(i < this.index && this.data[i].getName() != name){
			i++;
		}
		if (i < this.index){
			return this.data[i];
		}
		else{
			return null;
		}
	}
	public int getIndex(){
		return this.index;
	}
	public void setValue(int value,Vertice q){
		int i = 0;
		while(i < this.index && this.data[i] != q){
			i++;
		}
		if (i < this.index){
			this.data[i].setValue(value);
		}
	}
	public void setPredecessor(char predecessor,Vertice q){
		int i = 0;
		while(i < this.index && this.data[i].getName() != q.getName()){
			i++;
		}
		if (i < this.index){
			this.data[i].setPredecessor(predecessor);
		}
	}
	public void setState(Color state,Vertice q){
		int i = 0;
		while(i < this.index && this.data[i].getName() != q.getName()){
			i++;
		}
		if (i < this.index){
			this.data[i].setState(state);
		}
	}
	public void disPlayVectorVertice(){
		for (int i = 0; i < this.index; i++){
			System.out.print("(" + this.data[i].getName() + "," + this.data[i].getValue() + ","  + this.data[i].getState() + "," + this.data[i].getIndice() + " " + this.data[i].getPredecessor() + ")");
		}
		System.out.println("");
	}
}
