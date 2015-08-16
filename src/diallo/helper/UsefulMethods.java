package diallo.helper;

import java.util.ArrayList;
import java.util.List;

public class UsefulMethods {

	/*
	 * The following simple method is to illustrate the swapping of two items.
	 */
	static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	/*
	 * This method determines the greatest common denominator between two
	 * numbers.
	 */
	static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	/*
	 * This method will combine sorted arrays. This means that it will take two
	 * sorted arrays; then it will combine and sort them. It results in a
	 * longer, but still sorted array.
	 */
	static int[] combineSortedArrays(int[] A, int[] B) {
		int[] result = new int[A.length + B.length];
		int i = 0;
		int j = 0;
		int counter = 0;
		while (i < A.length && j < B.length) {
			if (A[i] <= B[j]) {
				result[counter] = A[i];
				counter++;
				i++;
			} else {
				result[counter] = B[j];
				counter++;
				j++;
			}
		}
		while (i < A.length) {
			result[counter] = A[i];
			counter++;
			i++;
		}
		while (j < B.length) {
			result[counter] = B[j];
			counter++;
			j++;
		}
		printArray(result);
		return result;
	}

	/*
	 * This method will combine sorted lists. This means that it will take two
	 * sorted lists; then it will combine and sort them. It results in a longer,
	 * but still sorted list.
	 */
	static ArrayList<Integer> combineSortedLists(List<Integer> A,
			List<Integer> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < A.size() && j < B.size()) {
			if (A.get(i) <= B.get(j)) {
				result.add(A.get(i));
				i++;
			} else {
				result.add(B.get(j));
				j++;
			}
		}
		while (i < A.size()) {
			result.add(A.get(i));
			i++;
		}
		while (j < B.size()) {
			result.add(B.get(j));
			j++;
		}
		System.out.println(result);
		return result;
	}

	/*
	 * This is a method that will return the longest palindrome found within a
	 * given string.
	 */
	static void longestPalindrome(String s) {
		String palindrome = "";
		for (int i = 0; i < s.length(); i++) {
			int j = 1;

			// check whether the next characters are similar to the current one
			while (i + j < s.length() && s.charAt(i + j) == s.charAt(i)) {

				// only replace palindrome if the length of trailing similar
				// characters is greater than current longest palindrome
				if (j + 1 >= palindrome.length()) {
					palindrome = s.substring(i, i + j + 1);
				}

				// increment j to check next character
				j++;
			}

			// counter for left and right symmetry from current char (or
			// substring if similar trailing characters)
			int symmetryCounter = 1;

			// substring which will be checked for palindromicity
			String palindromer = (i + j + symmetryCounter < s.length()) ? s
					.substring(i - symmetryCounter, i + j + symmetryCounter)
					: s.substring(i - symmetryCounter);

			// make sure to stay within the bounds of the given string's length
			// and check palindromicity
			while ((i - symmetryCounter >= 0)
					&& (i + j - 1 + symmetryCounter < s.length())
					&& isPalindrome(palindromer)) {
				palindrome = (palindromer.length() >= palindrome.length()) ? palindromer
						: palindrome;
				symmetryCounter++;
				palindromer = (i + j + symmetryCounter < s.length()) ? s
						.substring(i - symmetryCounter, i + j + symmetryCounter)
						: s.substring(i - symmetryCounter);
			}

			// increment i by number of similar trailing characaters + 1
			i += j;
		}
		System.out.println("The longest palindrome within the given word (" + s
				+ ") is: " + palindrome + ".");
	}

	/*
	 * Find whether or not a given string is a palindrome.
	 */
	public static boolean isPalindrome(String s) {
		String r = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			r += s.charAt(i);
		}
		return s.equals(r);
	}

	static void printList(List<Integer> l) {
		for (Integer i : l)
			System.out.print(i + " ");
		System.out.println();
	}

	static void print2DArray(int[][] a) {
		for (int[] i : a) {
			for (int j : i)
				System.out.print(j + " ");
			System.out.println();
		}
		System.out.println();
	}

	static void printArray(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	static void printArray(Integer[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
