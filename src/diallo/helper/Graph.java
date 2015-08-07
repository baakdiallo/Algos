package diallo.helper;

public class Graph {

	GraphNode[] nodes;
	GraphEdge[] edges;
	boolean directed;

	public Graph(GraphNode[] nodes, GraphEdge[] edges, boolean directed) {
		this.nodes = nodes;
		this.edges = edges;
		this.directed = directed;
	}

	public int numEdges() {
		return edges.length;
	}

	public int numNodes() {
		return nodes.length;
	}

	public GraphNode[] getNodes() {
		return nodes;
	}

	public GraphEdge[] getEdges() {
		return edges;
	}

	public boolean isDirected() {
		return directed;
	}

}
