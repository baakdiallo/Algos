package diallo.kruskal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Kruskal {

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

			// Close scanner
			fileScan.close();

			/*
			 * Everything above from the try block is just configuration.
			 * ========
			 * ==========================================================
			 */

			// Create hashmap of edges and their respective weights
			Map<String, Integer> edgeWeights = new HashMap<String, Integer>();

			// Add weights to hashmap then sort list of edge weights
			for (int i = 0; i < weights.length; i++) {
				edgeWeights.put(edges[i], Integer.valueOf(weights[i]));
			}
			List<Integer> weightList = new ArrayList<Integer>(
					edgeWeights.values());
			Collections.sort(weightList);

			// Create and initialize list that will hold the list of different
			// sets of subgraphs
			List<String> sets = new ArrayList<String>();
			for (String s : vertices)
				sets.add(s);

			// Create array that will hold minimum spanning tree
			List<String> mst = new ArrayList<String>();

			int index = 0;
			while (index < numV - 1) {
				int weight = weightList.get(0);
				String edge = "";

				// Find edge from weight
				for (String key : edgeWeights.keySet()) {
					if (edgeWeights.get(key) == weight) {
						edge = key;
						break;
					}
				}

				// Merge sets of edge vertices if vertices not in the same set
				if (!sameSet(edge, sets)) {
					mergeSets(edge, sets);
					mst.add(edge);

					index++;
				}

				// Remove edge after it's added to the Minimum Spanning Tree
				edgeWeights.remove(edge);
				weightList.remove(0);
			}

			System.out.println(mst.toString());

		} catch (FileNotFoundException fnfe) {

		}

	}

	static boolean sameSet(String edge, List<String> sets) {
		String left = edge.substring(0, 1);
		String right = edge.substring(1);
		for (String s : sets)
			if (s.contains(left) && s.contains(right))
				return true;
		return false;
	}

	static void mergeSets(String edge, List<String> sets) {
		String left = edge.substring(0, 1);
		String right = edge.substring(1);
		int leftIdx = 0;
		int rightIdx = 0;
		for (int i = 0; i < sets.size(); i++) {
			if (sets.get(i).contains(left))
				leftIdx = i;
			else if (sets.get(i).contains(right))
				rightIdx = i;
		}
		boolean broke = false;
		for (int i = 0; i < sets.size(); i++) {
			if (sets.get(i).contains(left)) {
				sets.set(i, sets.get(i) + sets.get(rightIdx));
				sets.remove(rightIdx);
				broke = true;
				break;
			} else if (sets.get(i).contains(right)) {
				sets.set(i, sets.get(i) + sets.get(leftIdx));
				sets.remove(leftIdx);
				broke = true;
				break;
			}
		}
		if (!broke)
			sets.add(edge);
	}

}
