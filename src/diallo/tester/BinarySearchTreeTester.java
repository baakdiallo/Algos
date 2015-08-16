package diallo.tester;

import diallo.helper.BTNode;
import diallo.helper.BinarySearchTree;

public class BinarySearchTreeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree tree = new BinarySearchTree(new BTNode(5));
		tree.addNode(new BTNode(7));
		tree.addNode(new BTNode(9));
		tree.addNode(new BTNode(6));
		tree.addNode(new BTNode(3));
		tree.addNode(new BTNode(2));
		tree.levelOrder(tree.getRoot());
		System.out.println();
		tree.removeNode(tree.getRoot().getRight());
		tree.levelOrder(tree.getRoot());
		
	}

}
