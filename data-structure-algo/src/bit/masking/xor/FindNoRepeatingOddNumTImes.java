package bit.masking.xor;

public class FindNoRepeatingOddNumTImes {

	public static void main(String[] args) {
		int num[] = { 5, 4, 1, 4, 3, 2, 5, 1, 2 };
		int xor = 0;
		for(int in : num) {
			xor ^= in;
		}
		System.out.println(xor);
	}
}
