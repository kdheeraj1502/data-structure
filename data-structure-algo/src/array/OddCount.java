package array;

public class OddCount {

	/// WRONG
	public static int findOddCountEle(int num[]) {
		// Arrays.sort(num);
		/// WRONG	/// WRONG
		int xor = 0;
		for (int i = 0; i < num.length; i++) {
			xor = xor ^ num[i];
		}
		/// WRONG	/// WRONG
		return xor;
	}

	
	/// WRONG	/// WRONG
	public static void main(String[] args) {
		int num[] = { 2, 5, 2, 3, 1, 1, 6, 5, 4, 3, 2, 2 };
		System.out.println(findOddCountEle(num));
	}
}
