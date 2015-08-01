package diallo.djikstra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Djikstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			/* Configuration:
			 * Read inputs (vertices, edges, weights, start vertex, end vertex)
			 * Set up adjacency matrix
			 */
			File file = new File("reseauRoutier.txt");
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
				System.out.println(weights[a]);
				adjMatrix[left - 'A'][right - 'A'] = Integer.parseInt(weights[a]);
				adjMatrix[right - 'A'][left - 'A'] = Integer.parseInt(weights[a]);
				a++;
			}
			String start = fileScan.next();
			String end = fileScan.next();
			
			
			
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
	}

}
