package diallo.helper;

public class GraphNode {

	char name;
	int distance;
	GraphList neighbors;
	GraphNode predecessor;
	boolean visited = false;;

	public GraphNode(char name, int distance) {
		this.name = name;
		this.distance = distance;
	}

	public GraphNode(char name, int distance, GraphList neighbors) {
		this.name = name;
		this.distance = distance;
		this.neighbors = neighbors;
	}

	public GraphNode(char name, int distance, GraphNode predecessor) {
		this.name = name;
		this.distance = distance;
		this.predecessor = predecessor;
	}

	public GraphNode(char name, int distance, GraphNode predecessor,
			GraphList neighbors) {
		this.name = name;
		this.distance = distance;
		this.predecessor = predecessor;
		this.neighbors = neighbors;
	}

	public boolean hasNeighbor(GraphNode node) {
		return neighbors.contains(node);
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public GraphList getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(GraphList neighbors) {
		this.neighbors = neighbors;
	}

	public GraphNode getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(GraphNode predecessor) {
		this.predecessor = predecessor;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
