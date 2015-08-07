package diallo.helper;

public class Graph {

	GraphNode[] nodes;
	boolean directed;

	public Graph(GraphNode[] nodes, boolean directed) {
		this.nodes = nodes;
		this.directed = directed;
	}

	public int numNodes() {
		return nodes.length;
	}

	public int numEdges() {
		int numEdges = 0;
		for (GraphNode node : nodes)
			numEdges += node.neighbors.size();
		if (directed)
			return numEdges / 2;
		return numEdges;
	}

	public GraphNode[] getNodes() {
		return nodes;
	}

	public boolean isDirected() {
		return directed;
	}

}
