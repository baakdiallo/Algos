package diallo.sierpinski;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class SierpinskiSquare extends JPanel {

	List<Polygon> polygons;

	Point topLeft;
	int length;
	int numIter;
	int n = 4;
	int[] x = new int[n];
	int[] y = new int[n];

	int WIDTH = 600;

	public SierpinskiSquare(Point topLeft, int length, int numIter) {
		this.topLeft = topLeft;
		this.length = length;
		this.numIter = numIter;

		polygons = new ArrayList<Polygon>();

		Point p2 = new Point(topLeft.x + length, topLeft.y);
		Point p3 = new Point(topLeft.x + length, topLeft.y + length);
		Point p4 = new Point(topLeft.x, topLeft.y + length);

		setPreferredSize(new Dimension(WIDTH, WIDTH));

		sierpinskify(numIter, topLeft, p2, p3, p4);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		for (Polygon p : polygons)
			g.fillPolygon(p);
	}

	void sierpinskify(int numIter, Point topLeft, Point p2, Point p3, Point p4) {
		if (numIter == 0)
			return;
		int third = (p2.x - topLeft.x) / 3;
		Point newTopLeft = new Point(topLeft.x + third, topLeft.y + third);
		Point newP2 = new Point(newTopLeft.x + third, newTopLeft.y);
		Point newP3 = new Point(newTopLeft.x + third, newTopLeft.y + third);
		Point newP4 = new Point(newTopLeft.x, newTopLeft.y + third);
		x[0] = newTopLeft.x;
		x[1] = newP2.x;
		x[2] = newP3.x;
		x[3] = newP4.x;
		y[0] = newTopLeft.y;
		y[1] = newP2.y;
		y[2] = newP3.y;
		y[3] = newP4.y;

		Polygon square = new Polygon(x, y, 4);
		polygons.add(square);

		sierpinskify(numIter - 1, topLeft, new Point(newTopLeft.x, topLeft.y),
				newTopLeft, new Point(topLeft.x, newTopLeft.y));
		sierpinskify(numIter - 1, new Point(newTopLeft.x, topLeft.y),
				new Point(newP2.x, p2.y), newP2, newTopLeft);
		sierpinskify(numIter - 1, new Point(newP2.x, p2.y), p2, new Point(p2.x,
				newP2.y), newP2);
		sierpinskify(numIter - 1, newP2, new Point(p2.x, newP2.y), new Point(
				p2.x, newP3.y), newP3);
		sierpinskify(numIter - 1, newP3, new Point(p3.x, newP3.y), p3,
				new Point(newP3.x, p3.y));
		sierpinskify(numIter - 1, newP4, newP3, new Point(newP3.x, p3.y),
				new Point(newP4.x, p4.y));
		sierpinskify(numIter - 1, new Point(p4.x, newP4.y), newP4, new Point(
				newP4.x, p4.y), p4);
		sierpinskify(numIter - 1, new Point(topLeft.x, newTopLeft.y),
				newTopLeft, newP4, new Point(topLeft.x, newP4.y));

		repaint();
	}

}
