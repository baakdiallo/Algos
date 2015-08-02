package diallo.bellmanford;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BellmanFord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			/*
			 * ==================================================================
			 * Configuration: Read inputs [vertices,
			 * edges, weights, start vertex (and index), end vertex (and index)]
			 * Set up adjacency matrix
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

			// Create and initialize array to store distances from start vertex
			// to other vertices
			int[] dist = new int[numV];
			for (int i = 0; i < numV; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[startIdx] = 0;

			// Iterate numV - 1 times
			for (int i = 1; i < numV; i++) {

				// Attempt an update of distances from start vertex to its
				// neighbors
				for (int b = 0; b < numV; b++) {
					if (adjMatrix[startIdx][b] != 0
							&& adjMatrix[startIdx][b] < dist[b])
						dist[b] = adjMatrix[startIdx][b];
				}

				// For each edge between a vertex (not startIdx) and its
				// neighbors, attempt an update of the total edge distances
				for (int j = 0; j < numV; j++) {
					if (j != startIdx) {
						for (int k = 0; k < numV; k++) {
							if (adjMatrix[j][k] != 0
									&& dist[j] != Integer.MAX_VALUE
									&& dist[j] + adjMatrix[j][k] < dist[k])
								dist[k] = dist[j] + adjMatrix[j][k];
						}
					}
				}
			}

			printDistances(dist, startIdx);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}

	static void printDistances(int[] distances, int startIdx) {
		String result = "The minimum distances to each vertex from "
				+ String.valueOf((char) ('A' + startIdx) + " are:\n");
		String start = String.valueOf((char) ('A' + startIdx));
		for (int i = 0; i < distances.length; i++) {
			result += String.format("%s = %d, ",
					start + String.valueOf((char) ('A' + i)), distances[i]);
		}
		result = result.substring(0, result.length() - 2);

		System.out.println(result);
	}

}
