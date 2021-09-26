package bit.masking.xor;

public class FindElementNonRepeatingOthersRepeatingKTimes {

	public static int findNum(int num[], int k) {
		int result[] = new int[32];
		for (int i = 0; i < num.length; i++) {
			String str = Integer.toBinaryString(num[i]);
			int j = str.length() - 1;
			int index = 0;
			while (j >= 0) {
				if (str.charAt(j) == '1') {
					result[index] = result[index] + 1;
				}
				j--;
				index++;
			}
		}

		for (int i = 0; i < result.length; i++) {
			result[i] = result[i] % k;
		}

		int output = 0;

		for (int i = 0; i < result.length; i++) {
			output += result[i] * Math.pow(2, i);
		}
		return output;
	}

	public static int findNum_self(int num[], int k) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int countOn = 0;
			for (int val : num) {
				if ((val & (1 << i)) != 0) {
					countOn++;
				}
			}
			result += (countOn % k) * (1 << i);
		}
		return result;
	}

	public static void main(String[] args) {
		int num[] = { 673, 3452, 187, 769, 673, 187, 3452, 3452, 187, 3452, 673, 187, 187, 3452, 673, 673 };
		int xor = 0;
		for (int val : num) {
			xor ^= val;
		}
		System.out.println(xor);
		// System.out.println(findNum(num, 4));
		 System.out.println(findNum_self(num, 5));
	}
}
