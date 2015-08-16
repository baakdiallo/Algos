package diallo.sierpinski;

import java.awt.Point;

import javax.swing.JFrame;

public class Sierpinski {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Scanner scan = new Scanner(System.in);
		 * 
		 * System.out .println(
		 * "Please enter the space-separated x values (three) for the triangle ..."
		 * ); int x1 = scan.nextInt(); int x2 = scan.nextInt(); int x3 =
		 * scan.nextInt();
		 * 
		 * System.out .println(
		 * "Please enter the space-separated y values (two) for the triangle ..."
		 * ); int y1 = scan.nextInt(); int y2 = scan.nextInt();
		 * 
		 * System.out.println("Please enter the number of iterations ..."); int
		 * numIter = scan.nextInt();
		 */

		int x1 = 350;
		int x2 = 100;
		int x3 = 600;
		int y1 = 50;
		int y2 = 350;
		int numIterTriangle = 5;

		JFrame frame = new JFrame("Sierpinski Triangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(
				new SierpinskiTriangle(new Point(x1, y1), new Point(x2, y2),
						new Point(x3, y2), numIterTriangle));
		frame.pack();
		frame.setVisible(true);

		int x = 100;
		int y = 100;
		int length = 400;
		int numIterSquare = 5;

		JFrame frame2 = new JFrame("Sierpinski Triangle");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().add(
				new SierpinskiSquare(new Point(x, y), length, numIterSquare));
		frame2.pack();
		frame2.setVisible(true);
	}

}
