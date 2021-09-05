package searching;

public class FindMissingNumberXOR {
	public static int findMissingNumberXOR(int num[]) {
		int i =0;
		int xorSum = 0;
		for(i = 1; i <= 10; i++) {
			xorSum = xorSum ^ i;
		}
		System.out.println(xorSum);
		for(i = 0; i < num.length; i++) {
			System.out.println(xorSum + " xor " + num[i] + ", ");
			xorSum = xorSum ^ num[i];
		}
		System.out.println();
		return xorSum;
	}
}
