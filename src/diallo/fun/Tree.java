package diallo.fun;

import java.awt.Point;

import javax.swing.JFrame;

public class Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Fun with recursion: tree");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TreePanel(new Point(250, 450), 50, 10));
		frame.pack();
		frame.setVisible(true);

	}

}
