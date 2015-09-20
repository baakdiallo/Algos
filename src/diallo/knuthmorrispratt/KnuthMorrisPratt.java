package diallo.knuthmorrispratt;

public class KnuthMorrisPratt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(kmpMatch("bcdabd", "ssdabcdabaldabcdabddfe"));

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

		index = 0;
		int j = 0;
		while (j < s.length()) {
			System.out.println(index + ":" + j);
			// match found if length of index = length of pattern n (meaning we
			// have n successful consecutive character comparisons
			if (index == pattern.length()) {
				System.out.println("There is a match for '" + pattern
						+ "' at character # " + (j - pattern.length() + 1)
						+ " of " + s + ".");
				return true;
			}

			// if match found for a character, move to next characters
			if (pattern.charAt(index) == s.charAt(j)) {
				index++;
				j++;
			}

			// move indices of strings if no character
			// match, index of pattern depends on our prefix table for the
			// pattern
			else {
				if (index > 1)
					index = prefixTable[index - 1];
				j++;
			}
		}

		return false;
	}

}
