package diallo.sierpinski;

import java.awt.Graphics;
import java.awt.Point;

public class SierpinskiTriangle extends JPanel {

	Point p1;
	Point p2;
	Point p3;
	int numIter;

	public SierpinskiTriangle(Point p1, Point p2, Point p3, int numIter) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.numIter = numIter;
		this.paint();
	}

	public void paint(Graphics g) {
		g.drawLine(5, 14, 123, 12);
	}

}
