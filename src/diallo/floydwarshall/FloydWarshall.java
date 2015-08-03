package diallo.floydwarshall;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FloydWarshall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			/*
			 * ==================================================================
			 * Configuration: Read inputs [vertices, edges, weights, start
			 * vertex (and index), end vertex (and index)] Set up adjacency
			 * matrix
			 */
			File file = new File("txt/reseauRoutier.txt");
			Scanner fileScan = new Scanner(file);

			// Check if graph is directed or not
			boolean directed = fileScan.nextInt() == 1;

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
				if (directed) {

					// For directed graph
					adjMatrix[left - 'A'][right - 'A'] = Integer
							.parseInt(weights[a]);
				} else {

					// For undirected graph
					adjMatrix[left - 'A'][right - 'A'] = Integer
							.parseInt(weights[a]);
					adjMatrix[right - 'A'][left - 'A'] = Integer
							.parseInt(weights[a]);
				}

				a++;
			}
			String start = fileScan.next();
			String end = fileScan.next();
			int startIdx = start.charAt(0) - 'A';
			int endIdx = end.charAt(0) - 'A';

			// Close scanner
			fileScan.close();

			/*
			 * Everything from the try block to here is just configuration.
			 * ============================================================
			 */

			for (int i = 0; i < numV; i++) {
				for (int j = 0; j < numV; j++) {
					for (int k = 0; k < numV; k++) {
						if (adjMatrix[j][i] != Integer.MAX_VALUE
								&& adjMatrix[i][k] != Integer.MAX_VALUE
								&& adjMatrix[j][i] + adjMatrix[i][k] < adjMatrix[j][k]) {
							adjMatrix[j][k] = adjMatrix[j][i] + adjMatrix[i][k];
						}
					}
				}
			}

			printAdjacencyMatrix(adjMatrix);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

	}

	// Print matrix with shortest distance i->j at adjacencyMatrix[i][j]
	static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
		for (int i = 0; i < adjacencyMatrix.length; i++)
			System.out.print("\t" + String.valueOf((char) ('A' + i)));
		System.out.println();
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			System.out.print(String.valueOf((char) ('A' + i)) + "\t");
			for (int j = 0; j < adjacencyMatrix[i].length; j++)
				if (adjacencyMatrix[i][j] != Integer.MAX_VALUE)
					System.out.print(adjacencyMatrix[i][j] + "\t");
				else
					System.out.print("-\t");
			System.out.println();
		}
	}
}
