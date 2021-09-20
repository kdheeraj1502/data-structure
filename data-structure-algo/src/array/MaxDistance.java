package array;

public class MaxDistance {
	
	public static int maxDis(int num[]) {
		int maxDiff = -1;
		int j = num.length - 1;
		for(int i = 0; i < num.length; i++) {
			j = num.length - 1;
			while(i < j) {
				if(num[j] > num[i]) {
					maxDiff = Math.max(maxDiff, j - 1);
					break;
				}
				j--;
			}
		}
		
		return maxDiff;
	}

	public static void main(String[] args) {
		int num[] = { 33, 9, 10, 3, 2, 60, 30, 33, 11 };
		System.out.println(maxDis(num));
	}
}
