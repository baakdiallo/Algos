package diallo.fun;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

class TreePanel extends JPanel {

	final int WIDTH = 500;

	int[] x = new int[2];
	int[] y = new int[2];

	int numIter;

	List<Polygon> lines;

	public TreePanel(Point origin, int length, int numIter) {
		this.numIter = numIter;

		lines = new ArrayList<Polygon>();
		x[0] = origin.x;
		x[1] = origin.x;
		y[0] = origin.y;
		y[1] = origin.y - length;

		lines.add(new Polygon(x, y, 2));

		setPreferredSize(new Dimension(WIDTH, WIDTH));

		treefy(numIter, new Point(x[1], y[1]), 5, length);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		for (Polygon line : lines)
			g.drawPolygon(line);
	}

	public void treefy(int numIter, Point o, int xOffset, int yOffset) {
		if (numIter == 0)
			return;

		int[] a = new int[2];
		int[] b = new int[2];

		a[0] = o.x;
		a[1] = a[0] + xOffset;
		b[0] = o.y;
		b[1] = b[0] - yOffset;

		Polygon l1 = new Polygon(a, b, 2);
		lines.add(l1);

		treefy(numIter - 1, new Point(a[1], b[1]), xOffset + 5, yOffset - 5);

		a[1] = a[0] - xOffset;

		Polygon l2 = new Polygon(a, b, 2);
		lines.add(l2);

		treefy(numIter - 1, new Point(a[1], b[1]), xOffset + 5, yOffset - 5);
	}
}