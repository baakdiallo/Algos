
public class Node {
	private int data;
	private Node leftSon;
	private Node rightSon;
	private int weight;
	//Default constructor
	Node(){}
	//Constructor main
	Node(int data,Node leftSon,Node rightSon){
		this.data = data;
		this.leftSon = leftSon;
		this.rightSon = rightSon;
		this.weight = 0;
	}
	//This function allows to know if the node is empty or not
	static boolean isEmpty(Node node){
		if(node == null){
			return true;
		}
		else{
			return false;
		}
	}
	//This function return the data of the node
	static int getDataOfTheNode(Node node){
		return node.data;
	}
	//This function return the left son of the node
	static Node getLeftSonOfTheNode(Node node){
		return node.leftSon;
	}
	//This function return the right son of the node
	static Node getRightSonOfTheNode(Node node){
		return node.rightSon;
	}
	//This function return the weight of the node
	static int getWeightOfTheNode(Node node){
		return node.weight;
	}
	//This function change the data of the node
	static void setDataOfTheNode(Node node,int data){
		node.data = data;
	}
	//This function change the left son of the node
	static void setLeftSonOfTheNode(Node node,Node leftSon){
		node.leftSon = leftSon;
	}
	//This function change the right son of the node
	static void setRightSonOfTheNode(Node node,Node rightSon){
		node.rightSon = rightSon;
	}
	//This function change the weight of the node
	static void setWeightOfTheNode(Node node,int weight){
		node.weight = weight;
	}
	//This function is used to return the maximum value from the tree
	static Node getTheMaximumKeyFromTheNode(Node node){
		while(node.rightSon != null){
			node = node.rightSon;
		}
		return node;
	}
	//This function is used to return the minimum value from the tree
	static Node getTheMinimumKeyFromTheNode(Node node){
		while(node.leftSon != null){
			node = node.leftSon;
		}
		return node;
	}
	//This function is used to get the tree size
	static int getTheSizeOfTheNode(Node node){
		if(isEmpty(node) == true){
			return 0;
		}
		else{
			return 1 + getTheSizeOfTheNode(node.leftSon) + getTheSizeOfTheNode(node.rightSon);
		}
	}
	//This function is used to get the maximum between two number
	static int getTheMaximumBetweenTwoData(int x,int y){
		return (x > y) ?  x :  y;
	}
	//This function is used to know that if the node is leaf or not
	static boolean isLeaf(Node node){
		if(isEmpty(node)){
			System.out.println("Oups the node is empty");
			return false;
		}
		else if(node.leftSon == null && node.rightSon == null){
			return true;
		}
		else{
			return false;
		}
	}
	//This function is used to return the height of the node
	static int getHeightOfTheNode(Node node){
		if(isEmpty(node) == true){
			return -1;
		}
		else{
			return  1 + getTheMaximumBetweenTwoData(getHeightOfTheNode(node.leftSon),getHeightOfTheNode(node.rightSon));
		}
	}
	//This function is used to get the height of the node's left tree
	static int getHeightOfTheLeftSon(Node node){
		return 1 + getHeightOfTheNode(node.leftSon);
	}
	//This function is used to get the height of the node's right tree
	static int getHeightOfTheRightSon(Node node){
		return 1 + getHeightOfTheNode(node.rightSon);
	}
	//This function is used to update the weight after using the left or right rotation
	static void updateWeightOfTheNode(Node node){
		int LHeight = getHeightOfTheLeftSon(node);
		int RHeight = getHeightOfTheRightSon(node);
		node.weight = RHeight - LHeight;
	}
	//This function is used to display the data of the node in RGD
	static void displayDataRGDMode(Node node){
		if(!isEmpty(node)){
			System.out.print(node.data + " ");
			displayDataRGDMode(node.leftSon);
			displayDataRGDMode(node.rightSon);
		}
	}
	//This function is used to display the data of the node in GRD
	static void displayDataGRDMode(Node node){
		if(!isEmpty(node)){
			displayDataGRDMode(node.leftSon);
			System.out.print(node.data + " ");
			displayDataGRDMode(node.rightSon);
		}
	}
	//This function is used to display the data of the node in GDR
	static void displayDataGDRMode(Node node){
		if(!isEmpty(node)){
			displayDataGDRMode(node.leftSon);
			displayDataGDRMode(node.rightSon);
			System.out.print(node.data + " ");
		}
	}
	//This function is used to display the weight of the node in RGD
	static void displayWeightRGDMode(Node node){
		if(!isEmpty(node)){
			System.out.print(node.weight + " ");
			displayWeightRGDMode(node.leftSon);
			displayWeightRGDMode(node.rightSon);
		}
	}
	//This function is used to display the weight of the node in GRD
	static void displayWeightGRDMode(Node node){
		if(!isEmpty(node)){
			displayWeightGRDMode(node.leftSon);
			System.out.print(node.weight + " ");
			displayWeightGRDMode(node.rightSon);
		}
	}
	//This function is used to display the weight of the node in GDR
	static void displayWeightGDRMode(Node node){
		if(!isEmpty(node)){
			displayWeightGDRMode(node.leftSon);
			displayWeightGDRMode(node.rightSon);
			System.out.print(node.weight + " ");
		}
	}
	//This function allows to fine a node into the tree by its data
	static Node searchNodeIntoTheTreeByData(Node node,int data){
		if(node == null){
			return null;
		}
		else if(node.data == data){
			return node;
		}
		else if(node.data > data){
			return searchNodeIntoTheTreeByData(node.leftSon,data);
		}
		else{
			return searchNodeIntoTheTreeByData(node.rightSon,data);
		}
	}
	//This function is used to insert a data into the balanced search tree by conserving the balance
	static Node insertDataIntoTheTree(Node node,int data){
		if(isEmpty(node)){
			return new Node(data,null,null);
		}
		else{
			if(node.data >= data){
				node.leftSon = insertDataIntoTheTree(node.leftSon,data);
			}
			else{
				node.rightSon = insertDataIntoTheTree(node.rightSon,data);
			}
			updateWeightOfTheNode(node);
			if(node.weight < -1){
				if(node.leftSon.weight >= 0){
					node.leftSon = leftRotationOfTheNode(node.leftSon);
					node = rightRotationOfTheNode(node);
				}
				else{
					node = rightRotationOfTheNode(node);
				}
			}
			else if(node.weight > 1){
				if(node.rightSon.weight <= 0){
					node.rightSon = rightRotationOfTheNode(node.rightSon);
					node = leftRotationOfTheNode(node);
				}
				else{
					node = leftRotationOfTheNode(node);
				}
				
			}
			return node;
		}
	}
	//This function is used to do a right rotation over the node 
	static Node rightRotationOfTheNode(Node node){
		if(!isEmpty(node)){
			Node n = node;
			node = node.leftSon;
			setLeftSonOfTheNode(n,node.rightSon);
			setRightSonOfTheNode(node,n);
			updateWeightOfTheNode(node);
			updateWeightOfTheNode(node.rightSon);
		}
		return node;
	}
	//This function is used to do a left rotation over the node
	static Node leftRotationOfTheNode(Node node){
		if(!isEmpty(node)){
			Node n = node;
			node = node.rightSon;
			setRightSonOfTheNode(n,node.leftSon);
			setLeftSonOfTheNode(node,n);
			updateWeightOfTheNode(node);
			updateWeightOfTheNode(node.leftSon);
		}
		return node;
	}
}
