package diallo.djikstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Djikstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			/* =============================================================================================
			 * Configuration:
			 * Read inputs [vertices, edges, weights, start vertex (and index), end vertex (and index)]
			 * Set up adjacency matrix
			 */
			File file = new File("txt/reseauRoutier.txt");
			Scanner fileScan = new Scanner(file);
			int numV = fileScan.nextInt();
			int numE = fileScan.nextInt();
			fileScan.nextLine();
			String vertices[] = fileScan.nextLine().split(" ");
			String edges[] = fileScan.nextLine().split(" ");
			String weights[] = fileScan.nextLine().split(" ");
			int adjMatrix[][] = new int[numV][numV];
			int a = 0;
			while(a < edges.length){
				char left = edges[a].charAt(0);
				char right = edges[a].charAt(1);
				adjMatrix[left - 'A'][right - 'A'] = Integer.parseInt(weights[a]);
				adjMatrix[right - 'A'][left - 'A'] = Integer.parseInt(weights[a]);
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
			 ============================================================================================= */
			
			// Make hashmap with vertices as keys and initialize value at startIdx to be 0 and all others to be +Inf
			// Also create heap that will be minified after every node visit
			Map<String, Integer> dist = new HashMap<String, Integer>();
			List<Integer> minHeap = new ArrayList<Integer>();
			for(int i = 0; i < numV; i++){
				if(i != startIdx){
					dist.put(String.valueOf((char)('A'+i)), Integer.MAX_VALUE);
					minHeap.add(Integer.MAX_VALUE);
				}else{
					dist.put(String.valueOf((char)('A'+i)), 0);
					minHeap.add(0);
				}
			}
			
			// Create a hashmap that will store the path and an int variable that will store the total weight to a vertex
			//Map<String, Integer> pathAndWeight = new HashMap<String, Integer>();
			
			// Create a hashmap that will store each vertex's previous vertex
			// The starting vertex has no vertex before it
			Map<String, String> before = new HashMap<String, String>();
			before.put(start, "");
			
			// While the end vertex has not yet been visited
			while(vertices[endIdx] != "V"){
				
				// Minheapify the total distances at vertices to get the next closest vertex
				minHeap = minHeapify(minHeap);
				
				// Get next closest vertex based on min heap root
				int min = minHeap.get(0);
				String key = "";
				int keyIdx = 0;
				for (Map.Entry<String, Integer> entry : dist.entrySet()) {
					if (entry.getValue() == min) {
						key = entry.getKey();
						keyIdx = entry.getKey().charAt(0) - 'A';
						break;
					}
				}

				// Mark vertex as visited and remove min value from heap since we already have its key and index
				vertices[keyIdx] = "V";
				
				// Break out of the loop if we reached the EndIdx
				if(keyIdx == endIdx) break;
				else minHeap.remove(0);
				
				for(int i = 0; i < numV; i++){
					String neighbor = String.valueOf((char)('A'+i));
					int total = min + adjMatrix[keyIdx][i];
					if(vertices[i] != "V" && adjMatrix[keyIdx][i] != 0 && 
							total < dist.get(neighbor)){
						
						// Remove old higher value from minHeap and add new lower value for a certain vertex
						// Also update the value on the list of distances
						minHeap.remove(dist.get(neighbor));
						minHeap.add(total);
						dist.put(neighbor, total);
						
						// Add path and weight from vertex to neighbor
						//pathAndWeight.put(key + neighbor, total);
						
						// Update the vertex that comes before the current one in our path
						before.put(neighbor, key);
					}
				}
				
				dist.remove(key);
			}

			//System.out.println(pathAndWeight.toString());
			//System.out.println(before.toString());
			
			// Get the path
			String current = end;
			String path = "=>" + current;
			while(before.get(current) != ""){
				path = "=>" + before.get(current) + path;
				current = before.get(current);
			}
			path = path.substring(2);
			
			System.out.println(String.format("Using Djikstra's algorithm, the Minimum Total Distance from %s to %s is %d.\n"
					+ "The path is:\t %s.", start, end, minHeap.get(0), path));
			
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
	}

	/*
	 * Pass in a list as parameter and get the 'heapified' (min heap) version of
	 * the list.
	 */
	static List<Integer> minHeapify(List<Integer> l) {
		int current = l.size();
		int temp, i, left, right, smaller = 0;

		// add value at index 0 to make index calculations easier
		l.add(0, Integer.MIN_VALUE);
		int swapIndex = 0;
		while (current > 1) {

			// get smaller sibling value
			if (current % 2 == 1) {
				right = l.get(current);
				left = l.get(current - 1);
				smaller = left;
				swapIndex = current - 1;
				if (right <= left) {
					smaller = right;
					swapIndex = current;
				}
			} else {
				left = l.get(current);
				smaller = left;
				swapIndex = current;
				if (current + 1 < l.size()) {
					right = l.get(current + 1);
					if (right <= left) {
						smaller = right;
						swapIndex = current + 1;
					}
				}
			}

			// swap if smaller child has smaller value than parent
			if (smaller < l.get(current / 2)) {
				temp = l.get(current / 2);
				l.set(current / 2, l.get(swapIndex));
				l.set(swapIndex, temp);

				// go back down the tree
				i = swapIndex * 2;
				while (i < l.size()) {

					// get smaller sibling value
					left = l.get(i);
					smaller = left;
					swapIndex = i;
					if (i + 1 < l.size()) {
						right = l.get(i + 1);
						if (right <= left) {
							smaller = right;
							swapIndex = i + 1;
						}
					}

					// swap if smaller child has smaller value than parent
					if (smaller < l.get(swapIndex / 2)) {
						temp = l.get(swapIndex / 2);
						l.set(swapIndex / 2, l.get(swapIndex));
						l.set(swapIndex, temp);
					}
					i = swapIndex * 2;
				}
			}
			current -= 2;
		}

		l.remove(0);

		return l;
	}
}
