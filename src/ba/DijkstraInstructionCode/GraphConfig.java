import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class GraphConfig {
	private Nature type;
	private int numberOfVertice;
	private int numberOfEdges;
	private char beginWay;
	private char endWay;
	private int posSource;
	private char[] arrayVertice;
	private char[] arrayEdge;
	private int[] arrayCost;
	public GraphConfig(){
		this.numberOfEdges = 0;
		this.numberOfVertice = 0;
		this.type = null;
		this.beginWay = '?';
		this.endWay = '?';
		this.arrayEdge = null;
		this.arrayVertice = null;
		this.arrayCost = null;
		this.posSource = 0;
	}
	public int getPosByName(char name){
		int i = 0;
		while (i < this.arrayVertice.length && this.arrayVertice[i] != name){
			i++;
		}
		if (i < this.arrayVertice.length){
			return i;
		}
		else{
			return -1;
		}
		
	}
	public void graphLoading(){
		File f = new File("networkConfig2.txt");
		FileInputStream fis = null;
		String sfr = new String("false");
		String svr = new String("true");
		try{
			fis = new FileInputStream(f);
			byte[] b = new byte[1];
			int i;
			String str = "";
			while((i = fis.read(b)) != -1 && (char) b[0] != '!'){
				if (b[0] != 13){
					str += (char) b[0];
				}
			}
			if (str.equals(sfr)){
				this.type = Nature.nonOriented;
			}
			else if(str.equalsIgnoreCase(svr)){
				this.type = Nature.oriented;
			}
			System.out.println("Nature--->" + this.type);
			int nbr = 0;
			while((i = fis.read(b)) != -1 && (char)b[0] != '!'){
				if (b[0] >= 48 && b[0] <= 57){
				  nbr *= 10;
				  nbr += (b[0] - 48);
				}
			}
			System.out.println("Number of vertex--->" + nbr);
			this.numberOfVertice = nbr;
			this.arrayVertice = new char[this.numberOfVertice];
			 nbr = 0;
			while((i = fis.read(b)) != -1 && (char)b[0] != '!'){
				if (b[0] >= 48 && b[0] <= 57){
				  nbr *= 10;
				  nbr += (b[0] - 48);
				}
			}
			System.out.println("Number of edges--->" + nbr);
			this.numberOfEdges = nbr;
			if (this.type == Nature.oriented){
				this.arrayEdge = new char[2 * this.numberOfEdges];
				this.arrayCost = new int[this.numberOfEdges];
			}
			else{
				this.arrayEdge = new char[4 * this.numberOfEdges];
				this.arrayCost = new int[2 * this.numberOfEdges];
			}
			int j =0;
			while((i = fis.read(b)) != -1 && (char)b[0] != '!'){
				if (b[0] >= 65 && b[0] <= 90){
				  this.arrayVertice[j] = (char) b[0];
				  j++;
				}
			}
			System.out.print("List of vertexe---> ");
			for (j = 0; j < this.arrayVertice.length; j++){
				System.out.print(this.arrayVertice[j] + " ");
			}
			System.out.println("");
			j = 0;
			if (this.type == Nature.oriented){
				while((i = fis.read(b)) != -1 && (char)b[0] != '!'){
					if (b[0] >= 65 && b[0] <= 90){
					  this.arrayEdge[j] = (char) b[0];
					  j++;
					}
				}
			}
			else if(this.type == Nature.nonOriented){
				while((i = fis.read(b)) != -1 && (char)b[0] != '!'){
					if (b[0] >= 65 && b[0] <= 90){
					  if(j % 2 == 0){
						 this.arrayEdge[j] = (char) b[0];
						 j++;
					  }
					  else{
						this.arrayEdge[j] = (char) b[0];
						this.arrayEdge[j + 1] = this.arrayEdge[j];
						this.arrayEdge[j + 2] = this.arrayEdge[j - 1];
						j += 3;
					  }
				  }
			   }
			}
			System.out.print("List of edges--->");
			for (j = 0; j < this.arrayEdge.length; j++){
				System.out.print(this.arrayEdge[j]);
				if (j % 2 != 0){
					System.out.print(" ");
				}
			}
			System.out.println("");
			j = 0;
			nbr = 0;
			fis.read(b);
			if (this.type == Nature.oriented){
				while((char)b[0] != '!'){
					while(b[0] >= 48 && b[0] <= 57){
							  nbr *= 10;
							  nbr += (b[0] - 48);
							  fis.read(b);
					}
					if(nbr != 0){
						this.arrayCost[j] = nbr;
						j++;
						nbr = 0;
					}
					else{
						fis.read(b);
					}
				}
			}
			else{
				while((char)b[0] != '!'){
					while(b[0] >= 48 && b[0] <= 57){
							  nbr *= 10;
							  nbr += (b[0] - 48);
							  fis.read(b);
					}
					if(nbr != 0){
						this.arrayCost[j] = nbr;
						this.arrayCost[j + 1] = nbr;
						j += 2;
						nbr = 0;
					}
					else{
						fis.read(b);
					}
						
				}
			}
			System.out.print("List of cost---> ");
			for (j = 0; j < this.arrayCost.length; j++){
				System.out.print(this.arrayCost[j] + " ");
			}
			while((i = fis.read(b)) != -1 && (char)b[0] != '!'){
				if (b[0] >= 65 && b[0] <= 90){
				  this.beginWay = (char) b[0];
				}
			}
			this.posSource = this.getPosByName(this.beginWay);
			while((i = fis.read(b)) != -1 && (char)b[0] != '!'){
				if (b[0] >= 65 && b[0] <= 90){
				  this.endWay = (char) b[0];
				}
			}
			System.out.println("");
			System.out.println("Start of the path--->" + this.beginWay);
			System.out.println("end of the path--->" + this.endWay);
			fis.close();
		}
		catch(FileNotFoundException fne){
			fne.printStackTrace();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		finally{
			try{
				if (fis != null){
					fis.close();
				}
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}
	public Nature getType(){
		return this.type;
	}
	public int getNumberOfVertice(){
		return this.numberOfVertice;
	}
	public int getNumberOfEdge(){
		return this.numberOfEdges;
	}
	public char[] getArrayVertice(){
		return this.arrayVertice;
	}
	public char[] getArrayEdge(){
		return this.arrayEdge;
	}
	public int[] getArrayCost(){
		return this.arrayCost;
	}
	public int getPosSource(){
		return this.posSource;
	}
	public char getSource(){
		return this.beginWay;
	}
	public char getTarget(){
		return this.endWay;
	}
}
