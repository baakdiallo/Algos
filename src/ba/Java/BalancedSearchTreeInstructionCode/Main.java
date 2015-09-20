
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		int vector[] = {50,17,76,9,23,54,14,19,72,12,67}; 
		for(int i = 0; i < vector.length; i++){
			tree.insertData(vector[i]);
		}
		tree.displayDataRGD();
		cr();
		tree.displayWeightRGD();
		cr();
		tree.getHeight();
	}
	static void cr(){
		System.out.println("");
	}

}
