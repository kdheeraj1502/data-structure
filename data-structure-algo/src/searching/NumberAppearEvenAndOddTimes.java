package searching;

public class NumberAppearEvenAndOddTimes {

	public static int findOddTimesNum(int num[]) {
		int xor = 0;
		int i;
		for(i = 0; i < num.length; i++) {
			xor ^= num[i];
		}
		return xor;
	}
	public static void main(String[] args) {
		int num[] = { 7, 6, 4, 4, 7, 5, 9, 5, 4, 6, 9, 6, 4, 5, 6, 5, 9, 9, 7};
		System.out.println(findOddTimesNum(num));
	}
}
