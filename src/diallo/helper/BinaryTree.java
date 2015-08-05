package diallo.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

	BTNode root;
	BinaryTree left;
	BinaryTree right;

	public BinaryTree(BTNode root) {
		this.root = root;
	}

	public BinaryTree(BTNode root, BinaryTree left, BinaryTree right) {
		this.root = root;
		this.left = left;
		this.right = right;
	}
	
	public int getHeight(BTNode node){
		if(node == null)
			return -1;
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		if(leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}

	public void inOrder(BTNode node) {
		Stack<BTNode> stack = new Stack<BTNode>();
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				visit(node);
				node = node.right;
			}
		}
	}

	public void inOrderRecursive(BTNode node) {
		if (node == null)
			return;
		inOrderRecursive(node.left);
		visit(node);
		inOrderRecursive(node.right);

	}

	public void preOrder(BTNode node) {
		Stack<BTNode> stack = new Stack<BTNode>();
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				visit(node);
				if (node.right != null)
					stack.push(node.right);
				node = node.left;
			} else
				node = stack.pop();
		}
	}

	public void preOrderRecursive(BTNode node) {
		if (node == null)
			return;
		visit(node);
		preOrderRecursive(node.left);
		preOrderRecursive(node.right);
	}

	public void postOrder(BTNode node) {
		Stack<BTNode> stack = new Stack<BTNode>();
		BTNode lastVisited = null;
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				BTNode top = stack.peek();
				if (top.right != null && lastVisited != top.right)
					node = top.right;
				else {
					visit(top);
					lastVisited = stack.pop();
					node = null;
				}
			}
		}
	}

	public void postOrderRecursive(BTNode node) {
		if (node == null)
			return;
		postOrderRecursive(node.left);
		postOrderRecursive(node.right);
		visit(node);
	}

	public void levelOrder(BTNode node) {
		List<BTNode> queue = new ArrayList<BTNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.get(0);
			queue.remove(0);
			visit(node);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}
	
	static void visit(BTNode node){
		System.out.print(node.data + " ");
	}
	
	public boolean isBinarySearchTree(BTNode node){
		if(node == null)
			return true;
		if(node.left != null && node.left.data > node.data)
			return false;
		if(node.right != null && node.right.data < node.data)
			return false;
		return isBinarySearchTree(node.left) && isBinarySearchTree(node.right);
	}

	public BTNode getRoot() {
		return root;
	}

	public void setRoot(BTNode root) {
		this.root = root;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		root.setLeft(left.root);
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		root.setRight(right.root);
		this.right = right;
	}

}
