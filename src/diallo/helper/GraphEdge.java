package diallo.helper;

public class GraphEdge {

	GraphNode first;
	GraphNode second;
	int weight;

	public GraphEdge(GraphNode first, GraphNode second, int weight) {
		this.first = first;
		this.second = second;
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public GraphNode getFirst() {
		return first;
	}

	public GraphNode getSecond() {
		return second;
	}

}
