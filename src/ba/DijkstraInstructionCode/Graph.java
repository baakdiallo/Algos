import java.util.List;
import java.util.ArrayList;
public class Graph {
	private Nature type;
	private int col;
	private int row;
	private boolean[][] data;//the matrix can take only two value: 0 and 1
	private Heap verticeList;
    private VectorEdge edgeList;
    private VectorVertice verticeSet;//this structure contains the list of graph vertices
	//Constructor number 0
	public Graph(int col,int row,Nature type,int nbr1,int nbr2){
		this.type = type;
		this.row = row;
		this.col = col;
		this.data = new boolean[this.row][this.col];
		try{
			this.verticeList = new Heap(nbr1);
		}
		catch(MakeHeapException mhe){}
		this.verticeSet = new VectorVertice(nbr1);
		if (this.type == Nature.oriented){
			this.edgeList = new VectorEdge(nbr2);
		}
		else{
			if(this.type == Nature.nonOriented){
				this.edgeList = new VectorEdge(2 * nbr2);
			}
			else{
				this.edgeList = new VectorEdge(nbr2);
			}
			
		}
	}
	public int getEdgeListSize(){
		return this.edgeList.getSize();
	}
	public void initVerticeList(char[] arrayVertice,char source,int pos){
		this.verticeList.addValue(new Vertice(source,pos,0));//init heap vertices
		//init set vertices
		for (int i = 0; i < arrayVertice.length; i++){
			if(i != pos){
				this.verticeSet.addValue(new Vertice(arrayVertice[i],i));
			}
			else{
				this.verticeSet.addValue(new Vertice(arrayVertice[i],i,0));
			}
		}
	}
	public void initEdgeList(char[] arrayEdge,int[] arrayCost,int limite){
	    for (int i = 0; i < this.edgeList.getSize(); i++){
	    	Edge e = new Edge(arrayEdge[2 * i],arrayEdge[2 * i + 1],arrayCost[i]);
	    	this.edgeList.addValue(e);
	    }
	}
	public void initGraph(GraphConfig gc){
		this.initEdgeList(gc.getArrayEdge(), gc.getArrayCost(),gc.getNumberOfEdge());
		this.initVerticeList(gc.getArrayVertice(),gc.getSource(),gc.getPosSource());
	}
	public void scanGraph(){
		Vertice p,q;
		if (this.type == Nature.nonOriented){
			for(int i = 0; i < this.row; i++){
				p = this.verticeSet.getVerticeByIndice(i);
				for (int j = (i + 1); j < this.col; j++){
					q = this.verticeSet.getVerticeByIndice(j);
					if (this.edgeList.isInVector(p,q)){
						this.data[i][j] = true;
						this.data[j][i] = true;
					}
					else{
						this.data[i][j] = false;
						this.data[j][i] = false;
					}
				}
			}
		}
		else{
			for (int i = 0; i < this.row; i++){
				p = this.verticeSet.getVerticeByIndice(i);
				for (int j = 0; j < this.col; j++){
					q = this.verticeSet.getVerticeByIndice(j);
					if (this.edgeList.isInVector(p,q)){
						this.data[i][j] = true;
					}
			    }
		   }
		}
	}
	public void findtheShortestWay(char beginWay,char endWay){
		while(!this.verticeList.heapUnderFlow()){
			Vertice p = this.verticeList.getRoot();//get the minimum
			for(int j = 0; j < this.verticeSet.getIndex(); j++){
				Vertice q = this.verticeSet.getVerticeByIndice(j);
				if (q != null && !q.isMarked()){
					if (this.edgeList.isInVector(p,q) == true){
						if(p.getValue() + this.edgeList.getCostByVertice(p,q) < q.getValue()){
							int k = this.verticeList.searchVertice(q);
							if (k != -1){
								this.verticeList.removeDupplicate(k);
							}
							this.verticeSet.setValue(p.getValue() + this.edgeList.getCostByVertice(p, q), q);
							this.verticeSet.setPredecessor(p.getName(), q);
							q.setValue(p.getValue() + this.edgeList.getCostByVertice(p, q));
							q.setPredecessor(p.getName());
							this.verticeList.addValue(q);
						}
					}
			
				}
			}
			this.verticeList.removeValue();
		}
		this.displayShortestWay(beginWay,endWay);
	}
	public void addVerticeList(Vertice v){
		this.verticeList.addValue(v);
	}
	public void addEdgeList(Edge e){
		this.edgeList.addValue(e);
	}
	public void displayEdgeList(){
		this.edgeList.disPlayVectorEdge();
	}
	public void displayGraph(){
		for(int i = 0; i < this.row; i++){
			for (int j = 0; j < this.col; j++){
				if (this.data[i][j] == true){
					System.out.print(1 + " ");	
				}
				else{
					System.out.print(0 + " ");
				}
					
				
			}
			System.out.println("");
		}
	}
	public void displayShortestWay(char beginWay,char endWay){
		int i = 0;
		System.out.print("The shortest way leaving the vertice " + beginWay + " to get the vertice " + endWay + " is :");
		List<Character> shortestWay = new ArrayList<Character>();
		shortestWay.add(endWay);
		Vertice pred0 = this.verticeSet.getVerticeByName(shortestWay.get(i));
		int cost = pred0.getValue();
		if(pred0 == null){
			System.out.println("Oups.....!");
		}
		else{
			Vertice pred1 = this.verticeSet.getVerticeByName(pred0.getPredecessor());
			while(pred0.getPredecessor() != '?'){
				i++;
				shortestWay.add(pred1.getName());
				pred0 = pred1;
				pred1 = this.verticeSet.getVerticeByName(pred0.getPredecessor());
			}
			for(int j = i; j >= 0; j--){
				if(shortestWay.get(j) != endWay){
					System.out.print(shortestWay.get(j) + "--->");
				}
				else{
					System.out.print(shortestWay.get(j));
				}
			}
			 System.out.println("");
			 System.out.println("The minimum distance is:" + cost);
		}
		
	}
}
