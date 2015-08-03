
public class VectorEdge {
	private int size;
	private int index;
	private Edge[] data;
	//Constructor number 0
	public VectorEdge(int size){
		this.size = size;
		this.index = 0;
		data = new Edge[this.size];
	}
	public int getSize(){
		return this.size;
	}
	public void addValue(Edge e){
		this.data[this.index] = e;
		this.index++;
	}
	public void disPlayVectorEdge(){
		for (int i = 0; i < this.index; i++){
			System.out.print("(" + this.data[i].getLeftVertice() + "," + this.data[i].getRightVertice() + ","  + this.data[i].getCost() + ")");
		}
	}
	public int getCostByVertice(Vertice v0,Vertice v1){
		int i = 0;
		while((i < this.index ) && (v0.getName() != this.data[i].getLeftVertice() || v1.getName() != this.data[i].getRightVertice())){
			i++;
		}
		if (i < this.index){
			return this.data[i].getCost();
		}
		else{
			return -1;
		}
	}
	public boolean isInVector(Vertice v0,Vertice v1){
		int i = 0;
			while((i < this.index) && (v0.getName() != this.data[i].getLeftVertice() || v1.getName() != this.data[i].getRightVertice()) ){
				i++;
			}
			if (i < this.index){
				return true;
			}
			else{
				return false;
			}
		}
}
