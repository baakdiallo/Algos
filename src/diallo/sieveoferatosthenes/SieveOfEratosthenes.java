package diallo.sieveoferatosthenes;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int max = 1000;
		int[] arr = new int[max + 1];
		for (int i = 0; i < arr.length; i++)
			arr[i] = i;

		arr[0] = -1;
		arr[1] = -1;
		for (int i = 2; i <= Math.sqrt(max); i++) {
			if (arr[i] != -1)
				for (int j = i * i; j < arr.length; j += arr[i]) {
					arr[j] = -1;
				}
		}

		int count = 0;
		String result = "";
		for (int i : arr)
			if (i != -1) {
				count++;
				result += i + " ";
			}

		System.out.println("There are " + count
				+ " numbers of primes less than " + max + ":");
		System.out.println(result);
	}

}
