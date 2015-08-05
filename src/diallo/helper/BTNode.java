package diallo.helper;

public class BTNode {

	int data;
	BTNode parent;
	BTNode left;
	BTNode right;
	
	boolean visited = false;
	
	public BTNode(int data){
		this.data = data;
	}
	
	public BTNode(int data, BTNode parent, BTNode left, BTNode right){
		this.data = data;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	
	public boolean isLeaf(){
		return this.left == null && this.right == null;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public BTNode getParent() {
		return parent;
	}
	
	public void setParent(BTNode parent) {
		this.parent = parent;
	}
	
	public BTNode getLeft() {
		return left;
	}
	
	public void setLeft(BTNode left) {
		this.left = left;
	}
	
	public BTNode getRight() {
		return right;
	}
	
	public void setRight(BTNode right) {
		this.right = right;
	}
	
	public void setVisited(boolean b){
		visited = b;
	}
	
	public boolean getVisited(){
		return visited;
	}
	
	public String toString() {
		return "Data: " + String.valueOf(data);
	}
	
}
