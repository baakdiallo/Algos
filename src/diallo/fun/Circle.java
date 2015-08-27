package diallo.fun;

import java.awt.Point;

import javax.swing.JFrame;

public class Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Fun with recursion: circle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane()
				.add(new CirclePanel(new Point(300, 300), 150, 7));
		frame.pack();
		frame.setVisible(true);

	}

}
