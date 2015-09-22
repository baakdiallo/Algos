package diallo.dantzig;

public class Inequality {

	private int numVars;
	private int[] intLHS;
	private double[] doubleLHS;
	private int intRHS;
	private double doubleRHS;
	private boolean doubles;

	public Inequality(int rhs, int... vars) {
		int n = vars.length;
		numVars = n;
		intLHS = new int[numVars];
		for (int i = 0; i < n; i++) {
			intLHS[i] = vars[i];
		}
		this.intRHS = rhs;
		doubles = false;
	}

	public Inequality(double rhs, double... vars) {
		int n = vars.length;
		numVars = n;
		doubleLHS = new double[numVars];
		for (int i = 0; i < n; i++) {
			doubleLHS[i] = vars[i];
		}
		this.doubleRHS = rhs;
		doubles = true;
	}

	public boolean coeffsAreDoubles() {
		return doubles;
	}

	public int[] getIntLHS() {
		if (doubles)
			try {
				throw new Exception("LHS is in double array format...");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return intLHS;
	}

	public double[] getDoubleLHS() {
		if (!doubles)
			try {
				throw new Exception("LHS is in int array format...");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return doubleLHS;
	}

	public int getIntRHS() {
		if (doubles)
			try {
				throw new Exception("RHS is in double format...");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return intRHS;
	}

	public double getDoubleRHS() {
		if (!doubles)
			try {
				throw new Exception("RHS is in int format...");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return doubleRHS;
	}

	public int getNumVars() {
		return numVars;
	}

}
