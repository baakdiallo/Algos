package diallo.fun;

public class ThreeStackArray {

	int l1 = 0, r1 = 4, l2 = 5, r2 = 9, l3 = 10, r3 = 14;
	int lastIndex1 = 0, lastIndex2 = 5, lastIndex3 = 10;
	int max1 = 5, max2 = 5, max3 = 5;
	int[] array = new int[15];

	public ThreeStackArray() {
	}

	public void pushFirst(int i) {
		if (lastIndex1 == max1)
			doubleSizeFirst();

		array[lastIndex1] = i;
		lastIndex1++;
	}

	public void pushSecond(int i) {
		if (lastIndex2 == max2)
			doubleSizeSecond();

		array[lastIndex2] = i;
		lastIndex2++;
	}

	public void pushThird(int i) {
		if (lastIndex3 == max3)
			doubleSizeThird();

		array[lastIndex3] = i;
		lastIndex3++;
	}

	public int popFirst() {
		if (lastIndex1 - 1 < 0)
			throw new IndexOutOfBoundsException("...");

		if (max1 > 5 && lastIndex1 - 1 == (max1 / 2) - 1)
			halfSizeFirst();

		int peek = peekFirst();
		lastIndex1--;

		return peek;
	}

	public int popSecond() {
		if (lastIndex2 - 1 == r1)
			throw new IndexOutOfBoundsException("...");

		if (max2 > 5 && lastIndex2 - r1 - 1 == max2 / 2)
			halfSizeSecond();

		int peek = peekSecond();
		lastIndex2--;

		return peek;
	}

	public int popThird() {
		if (lastIndex3 - 1 == r2)
			throw new IndexOutOfBoundsException("...");

		if (max2 > 5 && lastIndex3 - r2 - 1 == max3 / 2)
			halfSizeThird();

		int peek = peekThird();
		lastIndex3--;

		return peek;
	}

	public int peekFirst() {
		if (!isEmptyFirst())
			return array[lastIndex1 - 1];
		else
			throw new IndexOutOfBoundsException("...");
	}

	public int peekSecond() {
		if (!isEmptySecond())
			return array[lastIndex2 - 1];
		else
			throw new IndexOutOfBoundsException("...");
	}

	public int peekThird() {
		if (!isEmptyThird())
			return array[lastIndex3 - 1];
		else
			throw new IndexOutOfBoundsException("...");
	}

	public boolean isEmptyFirst() {
		return lastIndex1 == 0;
	}

	public boolean isEmptySecond() {
		return lastIndex2 - l2 == 0;
	}

	public boolean isEmptyThird() {
		return lastIndex3 - l3 == 0;
	}

	public int sizeFirst() {
		return lastIndex1;
	}

	public int sizeSecond() {
		return lastIndex2 - l2;
	}

	public int sizeThird() {
		return lastIndex3 - l3;
	}

	public void doubleSizeFirst() {
		int total = (max1 * 2) + max2 + max3;
		int[] temp = new int[total];
		for (int i = l1; i < max1; i++) {
			temp[i] = array[i];
		}
		for (int i = max1; i < total - max1; i++) {
			temp[max1 + i] = array[i];
		}
		array = temp;
		max1 *= 2;

		r1 = max1 - 1;
		l2 = r1 + 1;
		r2 = l2 + max2 - 1;
		l3 = r2 + 1;
		r3 = l3 + max3 - 1;

		lastIndex2 = lastIndex2 + max1 / 2;
		lastIndex3 = lastIndex3 + max1 / 2;
	}

	public void halfSizeFirst() {
		int total = (max1 / 2) + max2 + max3;
		int[] temp = new int[total];
		for (int i = l1; i < max1 / 2; i++) {
			temp[i] = array[i];
		}
		for (int i = max1 / 2; i < total - max1 / 2; i++) {
			temp[i] = array[(max1 / 2) + i];
		}
		array = temp;
		max1 /= 2;

		r1 = max1 - 1;
		l2 = r1 + 1;
		r2 = l2 + max2 - 1;
		l3 = r2 + 1;
		r3 = l3 + max3 - 1;

		lastIndex2 = lastIndex3 - (max1 / 2);
		lastIndex3 = lastIndex3 - (max1 / 2);
	}

	public void doubleSizeSecond() {
		int total = max1 + (max2 * 2) + max3;
		int[] temp = new int[total];
		for (int i = l1; i < max1 + max2; i++) {
			temp[i] = array[i];
		}
		for (int i = max1 + max2; i < total - max2; i++) {
			temp[max2 + i] = array[i];
		}
		array = temp;
		max2 *= 2;

		r2 = l2 + max2 - 1;
		l3 = r2 + 1;
		r3 = l3 + max3 - 1;

		lastIndex3 = lastIndex3 + max2 / 2;
	}

	public void halfSizeSecond() {
		int total = max1 + (max2 / 2) + max3;
		int[] temp = new int[total];
		for (int i = l1; i < max1 + (max2 / 2); i++) {
			temp[i] = array[i];
		}
		for (int i = max1 + (max2 / 2); i < total - max2 / 2; i++) {
			temp[i] = array[(max2 / 2) + i];
		}
		array = temp;
		max2 /= 2;

		r2 = l2 + max2 - 1;
		l3 = r2 + 1;
		r3 = l3 + max3 - 1;

		lastIndex3 = lastIndex3 - (max2 / 2);
	}

	public void doubleSizeThird() {
		int total = max1 + max2 + (max3 * 2);
		int[] temp = new int[total];
		for (int i = l1; i < max1 + max2 + max3; i++) {
			temp[i] = array[i];
		}
		array = temp;
		max3 *= 2;

		r3 = l3 + max3 - 1;
	}

	public void halfSizeThird() {
		int total = max1 + (max2 / 2) + max3;
		int[] temp = new int[total];
		for (int i = l1; i < max1 + max2 + (max3 / 2); i++) {
			temp[i] = array[i];
		}
		array = temp;
		max3 /= 2;

		r3 = l3 + max3 - 1;
	}

	public String toString() {
		String result = "First stack:\t";
		for (int i = l1; i < lastIndex1; i++)
			result += array[i] + " ";
		result += "\nSecond stack:\t";
		for (int i = l2; i < lastIndex2; i++)
			result += array[i] + " ";
		result += "\nThird stack:\t";
		for (int i = l3; i < lastIndex3; i++)
			result += array[i] + " ";

		return result;
	}

}
