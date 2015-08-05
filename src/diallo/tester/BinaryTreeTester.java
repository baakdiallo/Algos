package diallo.tester;

import diallo.helper.BinaryTree;
import diallo.helper.BTNode;

public class BinaryTreeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BTNode root = new BTNode(5);
		root.setLeft(new BTNode(-7));
		BTNode rootl = root.getLeft();
		rootl.setRight(new BTNode(3, new BTNode(0), new BTNode(1)));
		BTNode rootlrr = rootl.getRight().getRight();
		rootlrr.setLeft(new BTNode(6));
		rootl.getRight().setLeft(new BTNode(0));
		rootl.setLeft(new BTNode(2));
		BTNode rootrr = new BTNode(8);
		rootrr.setLeft(new BTNode(7));
		rootrr.setRight(new BTNode(10));
		BTNode rootr = new BTNode(9);
		rootr.setRight(rootrr);

		BinaryTree subTree = new BinaryTree(rootr);

		BinaryTree tree = new BinaryTree(root);
		tree.setRight(subTree);

		System.out.println("Tree height from the root:\t"
				+ tree.getHeight(tree.getRoot()));

		System.out.print("Level-Order:\t");
		tree.levelOrder(tree.getRoot());
		System.out.println();

		System.out.print("In-Order:\t");
		tree.inOrder(tree.getRoot());
		System.out.println();

		System.out.print("In-Order With Recursion:\t");
		tree.inOrderRecursive(tree.getRoot());
		System.out.println();

		System.out.print("Pre-Order:\t");
		tree.preOrder(tree.getRoot());
		System.out.println();

		System.out.print("Pre-Order With Recursion:\t");
		tree.preOrderRecursive(tree.getRoot());
		System.out.println();

		System.out.print("Post-Order:\t");
		tree.postOrder(tree.getRoot());
		System.out.println();

		System.out.print("Post-Order With Recursion:\t");
		tree.postOrderRecursive(tree.getRoot());
		System.out.println();
		
		// TREE:
		//				       5
		//				 7	   		9
		//			  2     3		   8
		//				  0   1  	 7  10
		//				     6
		//
		// ==================================================
		// OUTPUT:
		//
		// Tree height from the root: 4
		// Level-Order: 5 -7 9 2 3 8 0 1 7 10 6
		// In-Order: 2 -7 0 3 6 1 5 9 7 8 10
		// In-Order With Recursion: 2 -7 0 3 6 1 5 9 7 8 10
		// Pre-Order: 5 -7 2 3 0 1 6 9 8 7 10
		// Pre-Order With Recursion: 5 -7 2 3 0 1 6 9 8 7 10
		// Post-Order: 2 0 6 1 3 -7 7 10 8 9 5
		// Post-Order With Recursion: 2 0 6 1 3 -7 7 10 8 9 5
		// ==================================================
	}

}
