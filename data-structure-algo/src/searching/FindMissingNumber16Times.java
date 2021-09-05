package searching;

public class FindMissingNumber16Times {

	public static int findMissingNumber2TImes(int num[]) {
	//	int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++) {
		//	if (min > num[i])
			//	min = num[i];
			if (max < num[i])
				max = num[i];
		}
	//	max *= 2;
	//	min *= 2;
		int expectedTotal = 2 * (max * (max + 1) / 2);
	//	int minTotal = min * (min - 1) / 2;
	
		int arrayTotal = 0;
		for (int i = 0; i < num.length; i++) {
			arrayTotal += num[i];
		}
		int result = Math.abs(expectedTotal - arrayTotal);
		return result;
	}
}
