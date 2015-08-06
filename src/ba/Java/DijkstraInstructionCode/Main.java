
public class Main {

	public static void main(String[] args) {
		System.out.println("Find the short path by the Dijkstra method");
		GraphConfig gc = new GraphConfig();
		gc.graphLoading();
		Graph g = new Graph(gc.getNumberOfVertice(),gc.getNumberOfVertice(),gc.getType(),gc.getNumberOfVertice(),gc.getNumberOfEdge());
		g.initGraph(gc);
		g.scanGraph();
		g.findtheShortestWay(gc.getSource(),gc.getTarget());
		rc();
	}
	static void rc(){
		System.out.println("");
	}

}
