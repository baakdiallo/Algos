
public class Heap {
	private int size;
	private int index;
	private Vertice[] data;
	//Constructor number 0
	public Heap(){
		this.size = 0;
		this.index = 0;
		this.data = null;
	}
	//Constructor number 1
	public Heap(int size)
	throws MakeHeapException{
		if (size <= 0){
			throw new MakeHeapException();
		}
		else{
			this.size = size;
			this.index = 0;
			this.data = new Vertice[this.size];			
		}
	}
	//Methods get
	public int getSize(){
		return this.size;
	}
	public Vertice getComponent(int index){
		return this.data[index];
	}
	public boolean heapUnderFlow(){
		return (this.index <= 0);
	}
	public boolean heapOverFlow(){
		return (this.index >= this.size);
	}
	public int getIndex(){
		return this.index;
	}
	public Vertice getRoot(){
		if (!this.heapUnderFlow()){
			return this.data[0];
		}
		else{
			return null;
		}
	}
	public void displayHeap(){
		if(!this.heapUnderFlow()){
			for (int i = 0; i < this.index; i++){
				System.out.print(this.data[i].getName() + "-" + this.data[i].getValue() + "-" + this.data[i].getState() + "-" + this.data[i].getIndice() + "-" + this.data[i].getPredecessor() + " ");
			}
			System.out.println("");
		}
		else{
			System.out.println("Oups Heap under flow");
		}
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
	public int searchVertice(Vertice q){
		int i = 0;
		while(i < this.index && this.data[i].getName() != q.getName()){
			i++;
		}
		if (i < this.index){
			return i;
		}
		else{
			return -1;
		}
	}
	//Methods set
	public void setValue(int value,Vertice q){
		int i = 0;
		while(i < this.index && this.data[i] != q){
			i++;
		}
		if (i < this.index){
			this.data[i].setValue(value);
		}
	}
	public void addValue(Vertice v){
		int oldIndex,curantIndex;
		curantIndex = this.index;
		oldIndex = (curantIndex - 1) / 2;
		while(curantIndex > 0 && this.data[oldIndex].getValue() > v.getValue()){
			this.data[curantIndex] = this.data[oldIndex];
			curantIndex = oldIndex;
			oldIndex = (curantIndex - 1) / 2;
		}
		this.data[curantIndex] = v;
		this.index++;
	}
	public void removeValue(){
		boolean greaterThanSon = true; //while you are greater than yours sons
		int leftIndex,rightIndex,rootIndex,minIndex;
		Vertice minimum,buffer;
		rootIndex = 0;
		this.data[0] = this.data[this.index - 1];
		leftIndex = 2 * rootIndex + 1;
		rightIndex = leftIndex + 1;
		while(leftIndex < this.index && greaterThanSon){
			if(rightIndex < this.index && this.data[rightIndex].getValue() < this.data[leftIndex].getValue()){
				minimum = this.data[rightIndex];
				minIndex = rightIndex;
			}
			else{
				minimum = this.data[leftIndex];
				minIndex = leftIndex;
			}
			if(minimum.getValue() < this.data[rootIndex].getValue()){
				buffer = this.data[rootIndex];
				this.data[rootIndex] = minimum;
				this.data[minIndex] = buffer;
				rootIndex = minIndex;
				leftIndex = 2 * rootIndex + 1;
				rightIndex = leftIndex + 1;
			}else{
				greaterThanSon = false;
			}
		}
		this.index--;
	}
	public void removeDupplicate(int i){
		int j = i;
		while(j < this.index -1){
			this.data[j] = this.data[j + 1];
			j++;
		}
		this.index--;
	}
}
