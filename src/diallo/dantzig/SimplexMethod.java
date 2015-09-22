package diallo.dantzig;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import diallo.helper.UsefulMethods;

public class SimplexMethod {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stubs

		Inequality[] ineqs = new Inequality[3];
		ineqs[0] = new Inequality(180, 2, 1, 1);
		ineqs[1] = new Inequality(300, 1, 3, 2);
		ineqs[2] = new Inequality(240, 2, 1, 2);
		Inequality p = new Inequality(0, -6, -5, -4);

		double[][] table = readValuesIntoSimplexTable("txt/simplexTable.txt");

		simplexMethod(table, ineqs, p);

	}

	public static void simplexMethod(double[][] table, Inequality[] ineqs,
			Inequality p) {
		int r = table.length;
		int c = table[0].length;
		double[] lastR = table[r - 1];

		while (!done(lastR)) {
			int pC = getPivotColumn(lastR);
			int pR = getPivotRow(pC, ineqs.length, table);
			double pE = table[pC][pR];
			operateOnRow(table, pR, pE);
			zeroOtherRows(table, pR, pC);
		}

		printVariables(table);
	}

	public static void printVariables(double[][] table) {
		for (int j = 0; j < table[0].length; j++)
			if (isBasicColumn(table, j)) {
				int row = rowIndexOfOneInColumn(table, j);
				if (j != table[0].length - 1)
					System.out.println("Variable #" + (j + 1) + ":\t"
							+ table[row][table[0].length - 1]);
				else
					System.out.println("Maximum is " + table[row][j]);
			}
		System.out.println("All other variables are 0.");
	}

	public static int rowIndexOfOneInColumn(double[][] table, int col) {
		for (int i = 0; i < table.length; i++)
			if (table[i][col] == 1)
				return i;
		return -1;
	}

	public static boolean isBasicColumn(double[][] table, int col) {
		int numZeros = 0;
		int numOnes = 0;
		for (int i = 0; i < table.length; i++)
			if (table[i][col] == 0)
				numZeros++;
			else if (table[i][col] == 1)
				numOnes++;

		return numOnes == 1 && numZeros == table.length - 1;
	}

	public static void zeroOtherRows(double[][] table, int pR, int pC) {
		for (int i = 0; i < table.length; i++) {
			if (i != pR) {
				double num = table[i][pC];
				if (num != 0) {
					for (int j = 0; j < table[i].length; j++) {
						table[i][j] -= num * table[pR][j];
					}
				}
			}
		}
	}

	public static void operateOnRow(double[][] table, int pivotRow,
			double pivotElement) {
		for (int i = 0; i < table[pivotRow].length; i++)
			table[pivotRow][i] /= pivotElement;
	}

	public static int getPivotRow(int pivotColumn, int numRows, double[][] table) {
		double[] rows = new double[numRows];
		for (int i = 0; i < numRows; i++) {
			if (table[i][pivotColumn] != 0)
				rows[i] = table[0][table[0].length - 1] / table[i][pivotColumn];
			else
				rows[i] = Double.MAX_VALUE;
		}

		return getPivotColumn(rows);
	}

	public static int getPivotColumn(double[] row) {
		int index = 0;
		for (int i = 1; i < row.length; i++)
			if (row[i] < row[index])
				index = i;
		return index;
	}

	public static boolean done(double[] row) {
		for (double d : row)
			if (d < 0)
				return false;
		return true;
	}

	public static double[][] readValuesIntoSimplexTable(String filename)
			throws FileNotFoundException {
		Scanner scan = new Scanner(new File(filename));
		int numRows = scan.nextInt();
		int numCols = scan.nextInt();
		double[][] table = new double[numRows][numCols];
		scan.nextLine();
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numCols; j++)
				table[i][j] = scan.nextDouble();

		return table;
	}

	public static double[][] simplexTable(Inequality[] ineqs, Inequality p) {

		// populate simplex table
		double[][] table = new double[ineqs.length + 1][ineqs[0].getNumVars()
				+ ineqs.length + 2];
		for (int i = 0; i < ineqs.length; i++)
			for (int j = 0; j < ineqs[i].getNumVars(); j++)
				if (!ineqs[0].coeffsAreDoubles())
					table[i][j] = ineqs[i].getIntLHS()[j];
				else
					table[i][j] = ineqs[i].getDoubleLHS()[j];
		for (int i = 0; i < ineqs.length; i++)
			table[i][ineqs.length + i] = 1;
		for (int i = 0; i < ineqs.length; i++)
			table[i][ineqs[0].getNumVars() + ineqs.length] = 0;
		for (int i = 0; i < ineqs.length; i++)
			if (!ineqs[0].coeffsAreDoubles())
				table[i][table[0].length - 1] = ineqs[i].getIntRHS();
			else
				table[i][table[0].length - 1] = ineqs[i].getDoubleRHS();
		for (int i = 0; i < p.getNumVars(); i++)
			if (!p.coeffsAreDoubles())
				table[table.length - 1][i] = p.getIntLHS()[i];
			else
				table[table.length - 1][i] = p.getDoubleLHS()[i];
		for (int i = p.getNumVars(); i < p.getNumVars() + ineqs.length; i++)
			table[table.length - 1][i] = 0;
		table[table.length - 1][p.getNumVars() + ineqs.length] = 1;
		table[table.length - 1][p.getNumVars() + ineqs.length + 1] = 0;

		return table;
	}

}
