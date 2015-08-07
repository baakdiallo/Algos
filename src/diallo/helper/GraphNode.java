package diallo.helper;

public class GraphNode {

	String name;
	int distance;
	GraphList neighbors;
	boolean visited = false;;

	public GraphNode(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}

	public GraphNode(String name, int distance, GraphList neighbors) {
		this.name = name;
		this.distance = distance;
		this.neighbors = neighbors;
	}

	public boolean hasNeighbor(GraphNode node) {
		return neighbors.contains(node);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
