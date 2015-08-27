package diallo.fun;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class CirclePanel extends JPanel {

	List<Oval> circles;

	final int WIDTH = 600;

	int radius;

	int numIter;

	public CirclePanel(Point p, int radius, int numIter) {
		this.radius = radius;
		this.numIter = numIter;

		circles = new ArrayList<Oval>();

		setPreferredSize(new Dimension(WIDTH, WIDTH));

		circlify(p, radius, numIter);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		for (Oval o : circles)
			g.drawOval(o.getX(), o.getY(), o.getWidth(), o.getHeight());
	}

	public void circlify(Point p, int radius, int numIter) {
		if (numIter == 0)
			return;

		Oval o = new Oval(p.x - radius, p.y - radius, radius * 2, radius * 2);
		circles.add(o);

		circlify(new Point(o.getX() - radius / 2, o.getY() - radius / 2),
				radius / 2, numIter - 1);
		circlify(new Point(o.getX() + o.getWidth() + radius / 2, o.getY()
				- radius / 2), radius / 2, numIter - 1);
		circlify(new Point(o.getX() - radius / 2, o.getY() + o.getHeight()
				+ radius / 2), radius / 2, numIter - 1);
		circlify(
				new Point(o.getX() + o.getWidth() + radius / 2, o.getY()
						+ o.getHeight() + radius / 2), radius / 2, numIter - 1);

	}

}
