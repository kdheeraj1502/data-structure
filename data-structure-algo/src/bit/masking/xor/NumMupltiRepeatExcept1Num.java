package bit.masking.xor;

public class NumMupltiRepeatExcept1Num {

	public static int twoTimesRepeat(int num[]) {
		int xor = 0;
		for (int val : num) {
			xor ^= val;
		}
		return xor;
	}

	/*
	 * 
	 * Not working
	 * Use other method present in class
	 * FindElementNonRepeatingOthersRepeatingKTimes
	 * Number is coming once once and rest at any count
	 */
	public static int threeTimesRepeat(int num[]) {
		int xor = 0;
		for (int val : num) {
			xor ^= val;
		}
		return xor;
	}

	public static void main(String[] args) {
		int num[] = { 3, 9, 8, 4, 3, 14, 8, 4, 9 };
		int num1[] = { 8, 9, 4, 3, 3, 9, 8, 4, 3, 77, 8, 4, 9 };
		//int num2[] = { 19, 8, 9, 4, 3, 3, 9, 8, 4, 3,  8, 4, 9 };
		System.out.println(twoTimesRepeat(num));
		System.out.println(threeTimesRepeat(num1));
	}
}
