package searching;

public class OddCountElement2 {

	public static void oddCOunt2(int num[]) {
		int xorSum = 0;
		int first = 0;
		int second = 0;
		int setBit;

		for (int i = 0; i < num.length; i++)
			xorSum ^= num[i];

		setBit = xorSum & ~(xorSum - 1);

		for (int i = 0; i < num.length; i++) {
			if ((num[i] & setBit) != 0)
				first ^= num[i];
			else
				second ^= num[i];
		}
		System.out.println(first + " and " + second);
	}

	public static void main(String[] args) {
		
		System.out.println(5&~4);
		
		
		int num[] = { 4, 5, 3, 7, 4, 9, 2, 5, 2, 9, 3, 7, 3, 4 };
		oddCOunt2(num);
	}
}
