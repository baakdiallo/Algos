package diallo.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

	protected BTNode root;
	protected BinaryTree left;
	protected BinaryTree right;

	public BinaryTree(BTNode root) {
		this.root = root;
	}

	public BinaryTree(BTNode root, BinaryTree left, BinaryTree right) {
		this.root = root;
		root.setLeft(left.root);
		this.left = left;
		root.setRight(right.root);
		this.right = right;
	}

	public boolean isBalanced() {
		Stack<BinaryTree> stack = new Stack<BinaryTree>();
		stack.push(this);
		while (!stack.isEmpty()) {
			BinaryTree current = stack.pop();
			BinaryTree right = current.right;
			BinaryTree left = current.left;
			if ((right != null && left != null && Math.abs(right
					.getHeight(right.root) - left.getHeight(left.root)) > 1)
					|| (right == null && left != null && left
							.getHeight(left.root) > 0)
					|| (left == null && right != null && right
							.getHeight(right.root) > 0))
				return false;
			if (right != null)
				stack.push(right);
			if (left != null)
				stack.push(left);
		}
		return true;
	}

	public int getHeight(BTNode node) {
		if (node == null)
			return -1;
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}

	public int getDepthOf(BTNode node) {
		if (node == null)
			return -1;
		int height = 0;
		BTNode temp = node;
		while (node != null && node != root) {
			height++;
			node = node.parent;
		}
		node = temp;
		return height;
	}

	public int getDepthOfRecursive(BTNode node) {
		if (node == null)
			return -1;
		if (node == root)
			return 0;
		return getDepthOf(node.parent) + 1;
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
		System.out.println();
	}

	static void visit(BTNode node) {
		System.out.print(node.data + " ");
	}

	public boolean isBinarySearchTree(BTNode node) {
		List<BTNode> nodeList = new ArrayList<BTNode>();
		Stack<BTNode> stack = new Stack<BTNode>();
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				nodeList.add(node);
				node = node.right;
			}
		}

		for (int i = 1; i < nodeList.size(); i++)
			if (nodeList.get(i).data < nodeList.get(i - 1).data)
				return false;

		return true;
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
