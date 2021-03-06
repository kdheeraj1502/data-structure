package array;

public class FindMissingNumber {

	public static int findMissing(int num[]) {
		int xor = 0;
		for (int i = 0; i < num.length; i++) {
			
			xor ^= num[i];
		}
		
		for(int i = 0; i <= 10; i++) {
			xor ^= i;
		}
		return xor;
	}

	public static void main(String[] args) {
		int num[] = { 1, 4, 2, 3, 6, 7, 8, 9, 10 };
		System.out.println(findMissing(num));
	}
}
