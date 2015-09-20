
public class Tree {
	private Node root;
	public Tree(){
		this.root = null;//The tree is empty
	}
	public boolean isEmpty(){
		if(this.root == null){
			return true;
		}
		else{
			return false;
		}
	}
	public void insertData(int data){
		this.root = Node.insertDataIntoTheTree(this.root, data);
	}
	public void displayDataGDR(){
		System.out.print("GDR : ");
		Node.displayDataGDRMode(this.root);
	}
	public void displayDataGRD(){
		System.out.print("GRD : ");
		Node.displayDataGRDMode(this.root);
	}
	public void displayDataRGD(){
		System.out.print("RGD : ");
		Node.displayDataRGDMode(this.root);
	}
	public void displayWeightGDR(){
		System.out.print("GDR : ");
		Node.displayWeightGDRMode(this.root);
	}
	public void displayWeightGRD(){
		System.out.print("GRD : ");
		Node.displayWeightGRDMode(this.root);
	}
	public void displayWeightRGD(){
		System.out.print("RGD : ");
		Node.displayWeightRGDMode(this.root);
	}
	public void getHeight(){
		int h = Node.getHeightOfTheNode(this.root);
		System.out.println("The height of the tree equals to : " + h );
	}
	public void LRotation(){
		this.root = Node.leftRotationOfTheNode(this.root);
	}
	public void RRototation(){
		this.root = Node.rightRotationOfTheNode(this.root);
	}
	public void getTheMaximum(){
		Node node = Node.getTheMaximumKeyFromTheNode(this.root);
		if(node != null){
			System.out.println("Maximum ---> " + Node.getDataOfTheNode(node));
		}
	}
	public void getTheMinimum(){
		Node node = Node.getTheMinimumKeyFromTheNode(this.root);
		if(node != null){
			System.out.println("Minimum ---> " + Node.getDataOfTheNode(node));
		}
	}
	public void getSize(){
		int size = Node.getTheSizeOfTheNode(this.root);
		System.out.println("Size of the tree ---> " + size);
	}
	public void searchData(int data){
		Node node = Node.searchNodeIntoTheTreeByData(this.root, data);
		if(node != null){
			System.out.println("Search : true | the data that found is ---> " + Node.getDataOfTheNode(node));
		}
		else{
			System.out.println("Search : false | there is no node into the tree that have " + data + " like key");
		}
	}
}
