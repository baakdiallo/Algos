package diallo.dfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import diallo.helper.LinkedList;
import diallo.helper.Node;

public class DepthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			/*
			 * ============================================================
			 * Configuration: Read inputs [vertices, edges, weights, start
			 * vertex (and index), end vertex (and index)] Set up adjacency
			 * matrix
			 */
			File file = new File("txt/bfsdfs.txt");
			Scanner fileScan = new Scanner(file);

			// Check if graph is directed or not
			boolean directed = fileScan.nextInt() == 1;

			int numV = fileScan.nextInt();
			int numE = fileScan.nextInt();
			fileScan.nextLine();
			String vertices[] = fileScan.nextLine().split(" ");
			String edges[] = fileScan.nextLine().split(" ");
			int adjMatrix[][] = new int[numV][numV];

			int a = 0;
			while (a < edges.length) {
				char left = edges[a].charAt(0);
				char right = edges[a].charAt(1);
				if (directed) {
					// For directed graph
					adjMatrix[left - 'A'][right - 'A'] = 1;
				} else {
					// For undirected graph
					adjMatrix[left - 'A'][right - 'A'] = 1;
					adjMatrix[right - 'A'][left - 'A'] = 1;
				}
				a++;
			}
			String start = fileScan.next();
			int startIdx = start.charAt(0) - 'A';

			// Close scanner
			fileScan.close();

			/*
			 * Everything above from the try block is just configuration.
			 * ========
			 * ==========================================================
			 */

			// char array to store the order of our visited vertices
			// Initialize all values to some character
			// Set value at index 0 to be our starting vertex
			char[] order = new char[numV];
			for (int i = 0; i < order.length; i++)
				order[i] = '-';
			order[0] = (char) ('A' + startIdx);

			// Use my LinkedList implementation as a Stack
			LinkedList stack = new LinkedList(new Node(startIdx, null));

			// Create a LinkedLsit for visited node indices
			LinkedList visited = new LinkedList(new Node(startIdx, null));

			// Index to know where we should add the new vertex in our list of
			// vertices.
			int index = 1;

			// Lexicographical order
			while (index != numV) {
				int current = stack.getDataAtIndex(0);
				stack.removeNodeAtIndex(0);
				for (int i = numV - 1; i >= 0; i--) {

					// If vertex is neighbor and not yet visited
					if (adjMatrix[current][i] == 1 && !visited.contains(i)) {

						// Add neighbor to the top of our stack
						stack.addFirst(new Node(i, null));

						// Add node to visited list
						visited.addLast(new Node(i, null));
					}
				}
				order[index] = (char) (stack.getDataAtIndex(0) + 'A');
				index++;
			}

			// Print result
			printVertices(order);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

	}

	static void printVertices(char[] order) {
		String result = "Depth-First Search order:\t";
		for (char c : order)
			result += c + " ";
		System.out.println(result);
	}

}
