package diallo.knuthmorrispratt;

public class KnuthMorrisPratt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(kmpMatch("dabd", "ssdabcdabaldabcdabddfe"));

	}

	public static boolean kmpMatch(String pattern, String s) {

		// return true if pattern to match is an empty string
		if (pattern.length() == 0)
			return true;

		// return false if pattern to match is larger than string against which
		// to match
		if (pattern.length() > s.length())
			return false;

		int length = pattern.length();
		int index = 0;
		int[] prefixTable = new int[length];
		prefixTable[0] = index;

		// fill in the prefix table
		for (int i = 1; i < pattern.length(); i++) {
			if (pattern.charAt(index) == pattern.charAt(i)) {
				prefixTable[i] = ++index;
			} else {
				index = 0;
				prefixTable[i] = 0;
			}
		}

		for (int i : prefixTable)
			System.out.print(i + " ");

		index = 0;
		int j = 0;
		int k = j;
		boolean update;
		while (j < s.length()) {

			// variable to let us know whether or not to update j (index of
			// string) and k (last index of j at non-matching characters)
			update = false;

			// if match found for a character, move to next characters
			if (pattern.charAt(index) == s.charAt(j)) {
				index++;
				j++;
			} else {
				update = true;
				index = 0;
			}

			if (update) {

				// move indices of strings if no character
				// match, index j of string depends on our prefix table for the
				// pattern
				j = k + index + 1 - prefixTable[index];
				k = j;
			}

			// match found if length of index = length of pattern n (meaning we
			// have n successful consecutive character comparisons
			if (index == pattern.length()) {
				System.out.println("There is a match for '" + pattern
						+ "' at character # " + (j - pattern.length() + 1)
						+ " of " + s + ".");
				return true;
			}
		}

		return false;
	}

}
