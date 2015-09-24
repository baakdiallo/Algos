
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int g[] = {24,6,28,5,63,19,94,3,100,62,2,1000,0};
		Heap h = new Heap(g.length);
		for(int i = 0; i < g.length; i++){
			h.insertDataByKey(g[i]);
			h.displayHeap();
		}
		while(!h.isEmpty()){
			int min = h.deleteData();
			System.out.println("peak---> " + min);
		}
	}

}
