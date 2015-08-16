package diallo.sierpinski;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class SierpinskiTriangle extends JPanel {

	List<Polygon> polygons;

	Point p1;
	Point p2;
	Point p3;
	int numIter;
	int n = 3;
	int[] x = new int[n];
	int[] y = new int[n];

	int WIDTH = 700;
	int HEIGHT = 400;

	Polygon triangle;

	public SierpinskiTriangle(Point p1, Point p2, Point p3, int numIter) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.numIter = numIter;

		polygons = new ArrayList<Polygon>();

		initializeTriangle();

		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		sierpinskify(numIter, this.p1, this.p2, this.p3);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.ORANGE);
		for (Polygon p : polygons)
			g.fillPolygon(p);
	}

	void sierpinskify(int numIter, Point one, Point two, Point three) {
		// System.out.println(one.x + "," + one.y + ") : (" + two.x + "," +
		// two.y + ") : (" + three.x + "," + three.y + ")");
		if (numIter == 0)
			return;
		Point mid1 = new Point((one.x + two.x) / 2, (one.y + two.y) / 2);
		Point mid2 = new Point((three.x + two.x) / 2, (three.y + two.y) / 2);
		Point mid3 = new Point((one.x + three.x) / 2, (one.y + three.y) / 2);
		x[0] = mid1.x;
		x[1] = mid2.x;
		x[2] = mid3.x;
		y[0] = mid1.y;
		y[1] = mid2.y;
		y[2] = mid3.y;

		triangle = new Polygon(x, y, 3);
		polygons.add(triangle);

		sierpinskify(numIter - 1, one, mid1, mid3);
		sierpinskify(numIter - 1, mid1, two, mid2);
		sierpinskify(numIter - 1, mid3, mid2, three);

		repaint();
	}

	void initializeTriangle() {
		x[0] = p1.x;
		x[1] = p2.x;
		x[2] = p3.x;
		y[0] = p1.y;
		y[1] = p2.y;
		y[2] = p3.y;

		triangle = new Polygon(x, y, 3);
	}

}
