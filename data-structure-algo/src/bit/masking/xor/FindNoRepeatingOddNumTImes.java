package bit.masking.xor;

public class FindNoRepeatingOddNumTImes {

	public static void main(String[] args) {
		int num[] = { 5, 4, 1, 4, 3, 2, 5, 1, 2 };
		int xor = 0;
		for (int in : num) {
			xor ^= in;
		}
		System.out.println(xor);

		int a = 19;

		while (a > 0) {
			System.out.println("a is " + Integer.toBinaryString(a) + " :: " + a);
			System.out.println("a - 1 is " + Integer.toBinaryString(a - 1) + " :: " + (a -1));
			a = a & (a - 1);
		}
		System.out.println("a is " + Integer.toBinaryString(a) + " :: " + a);
	}
}
