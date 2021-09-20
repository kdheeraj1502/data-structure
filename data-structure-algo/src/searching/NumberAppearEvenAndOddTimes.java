package searching;

public class NumberAppearEvenAndOddTimes {

	/// WRONG
	public static int findOddTimesNum(int num[]) {
		/// WRONG
		int xor = 0;
		int i;
		/// WRONG
		for (i = 0; i < num.length; i++) {
			xor ^= num[i];
		}
		/// WRONG
		return xor;
	}

	/// WRONG
	public static void main(String[] args) {
		int num[] = { 5, 3, 1, 1, 6, 5, 4, 3 };
		// { 7, 6, 4, 4, 7, 5, 9, 5, 4, 6, 9, 6, 4, 5, 6, 5, 9, 9, 7};
		System.out.println(findOddTimesNum(num));
	}
}
