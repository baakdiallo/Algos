import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Graph {
	private Nature type;
	private int size;
	private Node[] data;
	private int index;
	private char end;
	//default constructor
	public Graph(){
		this.type = null;
		this.size = 0;
		this.data = null;
		this.index = 0;
	}
	public void addDataInTheGraph(char name,boolean start){
		Node n ;
		if (start == true){
			n = new Node(name,0,this.index);
		}
		else{
			n = new Node(name,this.index);
		}
		this.data[this.index] = n;
		this.index++;
	}
	public int getIndexByName(char name){
		int i = 0;
		while(i < this.index && this.data[i].getName() != name){
			i++;
		}
		if (i < this.index){
			return i;//return the real index if the test is true
		}
		else{
			return -1;//return the default index if the is false
		}
	}
	public void setDistByIndx(int i,int d){
		this.data[i].setDist(d);
	}
	public void setPredecessorByIndex(int i,char p){
		this.data[i].setPredecessor(p);
	}
	public Nature getType(){
		return this.type;
	}
	public void displayGrapht(){
		for(int i = 0; i < this.index; i++){
			this.data[i].whoAreYou();
		}
	}
	public void graphLoading(){
		File f;
		int nbr1,nbr2,j,k,l;
		char m1,m2;
		try{
			f = new File("networkConfig1.txt");
			Scanner fc = new Scanner(f);
			int n = fc.nextInt();
			if (n == 1){
				this.type = Nature.oriented;
			}
			else{
				this.type = Nature.noOriented;
			}
			nbr1 = fc.nextInt();//get the number of nodes
			nbr2 = fc.nextInt();//get the number of edges
		    fc.nextLine();
			String nodes[] = fc.nextLine().split(" ");//get the list of nodes
			String edges[] = fc.nextLine().split(" ");//get the list of edges
			String weight[] = fc.nextLine().split(" ");//get the list of weight
			char start = fc.nextLine().charAt(0);//get the start of the path
			char end = fc.nextLine().charAt(0);//get the end of the path
			this.end = end;
			this.data = new Node[nbr1];
			this.size = nbr1;
			for (int i = 0; i < this.size; i++){
				char c = nodes[i].charAt(0);
				if (c == start){
					this.addDataInTheGraph(c,true);
				}
				else{
					this.addDataInTheGraph(c,false);
				}
			}
			for( int i = 0; i < edges.length; i++){
			     j = (Integer.valueOf(weight[2 * i].charAt(0)).intValue() - 48);
				m1 = edges[i].charAt(0);
				m2 = edges[i].charAt(1);
			     k = this.getIndexByName(m1);
			     l = this.getIndexByName(m2);
			     if(this.type == Nature.oriented){
						List p = new List(m2,j,l);
						this.data[k].addNeighbord(p);
			     }
			     else{
			    	 List p = new List(m2,j,l);
			    	 List q = new List(m1,j,k);
					 this.data[k].addNeighbord(p); 
					 this.data[l].addNeighbord(q); 
			     }
			}
			fc.close();
			this.displayGrapht();
		}
		
		catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}
	}
	public void FindShortPathByBellman(){
		int nbr;
		int arrayDist[] = new int[this.size];
		char arrayPred[] = new char[this.size];
		for (int i = 0; i < this.size; i++){
			arrayDist[i] = this.data[i].getDist();
			arrayPred[i] = this.data[i].getPredecessor();
		}
		for(int i = 0; i < this.size - 1; i++){
			for(int j = 0; j < this.size; j++){
				List p = this.data[j].getNeighbord().getData();
				while(p != null){
					char m2 = p.getName();
					int v2 = this.getIndexByName(m2);
					int w = p.getCost();
					int d2 = arrayDist[v2];
					int d1 = arrayDist[j];
					if (d1 == 2147483647){
						nbr = d1;
					}
					else{
						nbr = d1 + w;
					}
					if(nbr < d2){
						arrayDist[v2] = nbr;
						arrayPred[v2] = this.data[j].getName();
					}
					p = p.getNext();
				}
			}
		}
		this.displayTheShortPath(arrayPred, this.end);
	}
	public void displayTheShortPath(char[] v,char end){
		int i,j,k = 0;
	    char p;
	    char path[] = new char[50] ;//list of predecessor max length = 49
	    k++;
	    path[0] = end;
	    i = this.getIndexByName(end);
	    p = v[i];
	    while (p != '!'){
	    	path[k] = p;
	    	k++;
	    	i = this.getIndexByName(p);
	    	p = v[i];
	    }
	    System.out.print("Thes short path to get " + end + " is:");
	    for (j = k - 1; j >=0; j--){
            if (j != 0){
                    System.out.print(path[j] + "---->");
            }
            else{
                 System.out.print(path[j]);
            }

    }
	}
}
