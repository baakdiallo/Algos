
public class Heap {
	private int currentIndex;
	private int data[];
	private int heapSize;
	public Heap(int size){
		this.heapSize = size;
		this.currentIndex = 0;
		this.data = new int[this.heapSize];
	}
	public int getCurrentIndex(){
		return this.currentIndex;
	}
	public int getHeapSize(){
		return this.heapSize;
	}
	public void setCurrentIndex(int currentIndex){
		this.currentIndex = currentIndex;
	}
	public void setHeapSize(int heapSize){
		this.heapSize = heapSize;
	}
	public boolean isEmpty(){
		boolean stateHeap = (this.currentIndex == 0) ? true : false;
		return stateHeap;
	}
	public boolean isFull(){
		boolean stateHeap = (this.currentIndex >= this.heapSize) ? true : false;
		return stateHeap;
	}
	public boolean isLeaf(int indexNode){
		boolean stateNode = (2 * indexNode + 1 >= currentIndex) ? true : false;
		return stateNode;
	}
	public void insertDataByKey(int key){
		if(this.isFull()){
			System.out.println("The heap is full so that is impossible to insert data in the heap");
		}
		else{
			int indexData = this.currentIndex;
			int indexFather = (indexData - 1) / 2;
			boolean correctOrder = false;
			while(indexData > 0 && !correctOrder){
				if(key > this.data[indexFather]){
					correctOrder = true;
				}
				else{
					this.data[indexData] = this.data[indexFather];
					indexData = indexFather;
					indexFather = (indexData - 1) / 2;
				}
			}
			this.data[indexData] = key;
			this.currentIndex++;//For the next add
		}
	}
	public int bestCandidate(int index){
		int pos;
		if(2 * index + 2 < this.currentIndex){
			int x = this.data[2 * index + 1];
			int y = this.data[2 * index + 2];
		    pos = (x < y) ? 2 * index + 1 : 2 * index + 2;
		}
		else{
			pos = 2 * index + 1;
		}
		return pos;
	}
	public int deleteData(){
		int index = 0;
		int max = this.data[0];
		int key = this.data[0] = this.data[this.currentIndex - 1];
		boolean correctOrder = false;
		while(!isLeaf(index) && !correctOrder){
			int position = bestCandidate(index);
			if(key < this.data[position]){
				correctOrder = true;
			}
			else{
				this.data[index] = this.data[position];
				index = position;
			}
		}
		this.data[index] = key;
		this.currentIndex--;
		return max;
	}
	public void displayHeap(){
		for(int i = 0; i < this.currentIndex; i++){
			System.out.print(this.data[i] + " ");
		}
		if(!this.isEmpty()){
			System.out.println("");
		}
	}
}
