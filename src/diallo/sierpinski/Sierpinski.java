package diallo.sierpinski;

import java.awt.Point;
import java.util.Scanner;

import javax.swing.JFrame;

public class Sierpinski {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out
				.println("Please enter the space-separated x values for the triangle ...");
		String[] xS = scan.nextLine().split(" ");
		System.out
				.println("Please enter the space-separated x values for the triangle ...");
		String[] yS = scan.nextLine().split(" ");
		System.out.println("Please enter the number of iterations ...");
		int numIter = scan.nextInt();

		JFrame frame = new JFrame("Sierpinski Triangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(
				new SierpinskiTriangle(new Point(Integer.valueOf(xS[0]),
						Integer.valueOf(yS[0])), new Point(Integer
						.valueOf(xS[0]), Integer.valueOf(yS[0])), new Point(
						Integer.valueOf(xS[0]), Integer.valueOf(yS[0])),
						numIter));
		frame.pack();
		frame.setVisible(true);
	}

}
