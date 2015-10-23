package cod;
import java.io.IOException;
import java.util.Scanner;


public class COD {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		boolean y = false;
		do{
			System.out.println("Please enter a number...");
			int num = scan.nextInt();
			System.out.println("What digit are you searching for?");
			int search = scan.nextInt();
			
			System.out.println(totalNumOccurences(num, search));
			
			System.out.println("Enter n for a new search, or q to quit.");
			y = scan.next().equals("y");
		} while(y);
		
	}
	
	static int totalNumOccurences(int n, int s){
		String numStr = String.valueOf(n);
		int counter = 0;
		int step = 1;
		for(int i = numStr.length() - 1; i >= 0; i--){
			counter += numOccurences(Integer.valueOf(numStr.charAt(i)) * step, s);
			step *= 10;
		}
	}
	
	static int numOccurences(int n, int s){
		int counter = 0;
		int bar = 10;
		while()
	}
	
	static int getResultFromLevel(int level){
		String l = String.valueOf(level);
		for(int i = 0; i < level; i++)
			l += "0";
		
		return Integer.valueOf(l);
	}

}
