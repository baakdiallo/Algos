package diallo.prim;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			/*
			 * ============================================================
			 * Configuration: Read inputs [vertices, edges, weights, start
			 * vertex (and index), end vertex (and index)] Set up adjacency
			 * matrix
			 */
			File file = new File("txt/minimumSpanningTree.txt");
			Scanner fileScan = new Scanner(file);

			int numV = fileScan.nextInt();
			int numE = fileScan.nextInt();
			fileScan.nextLine();
			String vertices[] = fileScan.nextLine().split(" ");
			String edges[] = fileScan.nextLine().split(" ");
			String weights[] = fileScan.nextLine().split(" ");
			int adjMatrix[][] = new int[numV][numV];

			// initialize matrix with Inf for all edges
			for (int i = 0; i < numV; i++)
				for (int j = 0; j < numV; j++)
					adjMatrix[i][j] = Integer.MAX_VALUE;

			int a = 0;
			while (a < edges.length) {
				char left = edges[a].charAt(0);
				char right = edges[a].charAt(1);
				adjMatrix[left - 'A'][right - 'A'] = Integer
						.parseInt(weights[a]);
				adjMatrix[right - 'A'][left - 'A'] = Integer
						.parseInt(weights[a]);

				a++;
			}

			// Close scanner
			fileScan.close();

			/*
			 * Everything above from the try block is just configuration.
			 * ========
			 * ==========================================================
			 */

			// Create list that will hold minimum spanning tree
			List<String> mst = new ArrayList<String>();

			// Create and initialize arrays that will hold the keys and parents
			// for each vertex
			List<Integer> keys = new ArrayList<Integer>();
			List<String> parents = new ArrayList<String>();
			for (int i = 0; i < numV; i++) {
				keys.add(Integer.MAX_VALUE);
				parents.add(null);
			}

			// Pick a starting vertex and set its key to 0
			int current = 0;
			keys.set(current, 0);

			// Create array to check for visited vertices
			boolean[] visited = new boolean[numV];

			while (notAllVisited(visited)) {

				// Get vertex with minimum key
				int min = Collections.min(keys);
				int index = keys.indexOf(min);

				// Set vertex as visited
				visited[index] = true;

				// If vertex has a parent, add edge from parent to vertex to the
				// Minimum Spanning Tree
				if (parents.get(index) != null)
					mst.add(parents.get(index) + vertices[index]);

				// For each non-visited vertex V adjacent to current vertex C,
				// if the edge CV is less than the key value at V, update key
				// and parent of V
				for (int i = 0; i < numV; i++) {
					if (adjMatrix[index][i] < keys.get(i) && !visited[i]) {
						parents.set(i, vertices[index]);
						keys.set(i, adjMatrix[index][i]);
					}
				}
				// Avoid infinite loop by 'removing' the current min value from the set of keys
				keys.set(index, Integer.MAX_VALUE);
			}

			System.out.println(mst.toString());

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

	}

	static boolean notAllVisited(boolean[] visited) {
		for (boolean b : visited)
			if (!b)
				return true;
		return false;
	}
}
