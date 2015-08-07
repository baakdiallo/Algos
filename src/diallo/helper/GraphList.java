package diallo.helper;

public class GraphList {

	int max = 5;
	GraphNode[] nodes = new GraphNode[max];
	int lastIndex = 0;

	public GraphList() {

	}

	public void addNeighbor(GraphNode node) {
		if (lastIndex == max)
			resize();

		nodes[lastIndex] = node;
		lastIndex++;
	}

	public void removeNeighbor(GraphNode node) {
		int index = -1;
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] == node)
				index = i;
		}
		if (index != -1)
			for (int i = index; i < nodes.length - 1; i++)
				nodes[i] = nodes[i + 1];
	}

	public boolean contains(GraphNode node) {
		for (GraphNode n : nodes)
			if (n == node)
				return true;
		return false;
	}

	public int size() {
		return lastIndex;
	}

	public void resize() {
		max *= 2;
		GraphNode[] temp = new GraphNode[max];
		for (int i = 0; i < nodes.length; i++) {
			temp[i] = nodes[i];
		}
		nodes = temp;
	}

}
