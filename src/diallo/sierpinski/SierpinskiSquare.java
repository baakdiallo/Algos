package diallo.sierpinski;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class SierpinskiSquare extends JPanel{
	
	List<Polygon> polygons;

	Point topLeft;
	int length;
	int numIter;
	int n = 4;
	int[] x = new int[n];
	int[] y = new int[n];

	int WIDTH = 700;

	Polygon square;
	
	public SierpinskiSquare(Point topLeft, int length, int numIter){
		this.topLeft = topLeft;
		this.length = length;
		this.numIter = numIter;
		
		polygons = new ArrayList<Polygon>();
	}

}
