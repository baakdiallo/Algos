package diallo.helper;

public class BinarySearchTree extends BinaryTree {

	public BinarySearchTree(BTNode root) {
		super(root);
	}

	public BinarySearchTree(BTNode root, BinarySearchTree left,
			BinarySearchTree right) {
		super(root, left, right);
	}

	public void addNode(BTNode node) {
		if (root == null)
			root = node;
		else {
			BTNode temp = root;
			while (true) {
				if (root.data >= node.data) {
					if (root.left == null) {
						root.setLeft(node);
						break;
					}
					root = root.left;
				} else {
					if (root.right == null) {
						root.setRight(node);
						break;
					}
					root = root.right;
				}
			}
			root = temp;
		}
	}

	public void removeNode(BTNode node) {
		if (root == null)
			return;
		if (root.data == node.data)
			root = null;
		else {
			BTNode temp = root;
			while (true) {

				// If current node is equal to wanted node
				if (root.data == node.data) {
					BTNode wanted = root;

					// If wanted node has two children
					if (root.left != null && root.right != null) {
						root = root.left;
						// Find maximum value in left subtree
						while (root.right != null)
							root = root.right;

						// If wanted node is a left child
						if (wanted == wanted.parent.left) {
							BTNode p = wanted.parent;
							BTNode l = wanted.left;
							BTNode r = wanted.right;
							BTNode rl = root.left;
							p.setLeft(root);
							p.left.setRight(r);
							if (l.data != root.data) {
								p.left.setLeft(l);
								p.left.left.setRight(rl);
							} else if (rl != null)
								p.left.setLeft(rl);
						}

						// If wanted node is a right child
						else {
							BTNode p = wanted.parent;
							BTNode l = wanted.left;
							BTNode r = wanted.right;
							BTNode rl = root.left;
							p.setRight(root);
							p.right.setRight(r);
							if (l.data != root.data) {
								p.right.setLeft(l);
								p.right.left.setRight(rl);
							} else if (rl != null)
								p.right.setLeft(rl);
						}
					}

					// If wanted node has only left child
					else if (root.left != null) {

						// If wanted node is a left child
						if (root == root.parent.left)
							root.parent.left = root.left;

						// If wanted node is a right child
						else
							root.parent.right = root.left;
					}

					// If wanted node has only right child
					else if (root.right != null) {

						// If wanted node is a left child
						if (root == root.parent.left)
							root.parent.left = root.right;

						// If wanted node is a right child
						else
							root.parent.right = root.right;
					}

					// If wanted node is a leaf node
					else {

						// If wanted node is a left child
						if (root == root.parent.left)
							root.parent.left = null;

						// If wanted node is a right child
						else
							root.parent.right = null;
					}
					break;
				}

				// If wanted node is in left subtree
				else if (root.data > node.data) {
					if (root.left != null)
						root = root.left;
					else
						break;
				}

				// If wanted node is in right subtree
				else {
					if (root.right != null)
						root = root.right;
					else
						break;
				}
			}
			root = temp;
		}
	}

}
