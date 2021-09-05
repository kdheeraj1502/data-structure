package searching;

public class FindMissingElement {

	public static int findMissingNumber(int num[]) {
		int i, j , found = 0;
		for(i = 1; i < num.length; i++) {
			found = 0;
			for(j = 0; j < num.length; j++) {
				if(num[j] == i) {
					found = 1;
					break;
				}
			}
			if(found == 0) {
				return i;
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public static int findMissingNumberMath(int num[]) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < num.length; i++) {
			if(min > num[i])
				min = num[i];
			if(max < num[i])
				max = num[i];
		}
		
		int minTotal = 0;
		if(min > 0) {
			minTotal = (min - 1) * ((min - 1) + 1)/2;
		}
		int maxTotal = max * (max + 1)/2;
		int expectedTotal = maxTotal - minTotal;
		int arrayTotal = 0;
		for(int i = 0; i < num.length; i++) {
			arrayTotal += num[i];
		}
		return Math.abs(arrayTotal - expectedTotal);
	}
	
}
