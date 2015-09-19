package diallo.helper;

public class AVL extends BinarySearchTree{

	public AVL(BTNode root) {
		super(root);
		// TODO Auto-generated constructor stub
	}
	
	public AVL(BTNode root, BinarySearchTree left, BinarySearchTree right) {
		super(root, left, right);
		// TODO Auto-generated constructor stub
	}

	public void add(BTNode node){
		if(this.root == null)
			this.setRoot(node);
		else{
			
		}
	}
	
	public void remove(BTNode node){
		
	}
	
}
