package array;

public class BuyAndellStock {

	public static int maxProfit(int num[]) {
		int buy = 0;
		int sell = 0;
		int currMin = 0;
		int currProfit = 0;
		int maxProfit = 0;
		int i;
		for (i = 0; i < num.length; i++) {
			if (num[i] < num[currMin]) {
				currMin = i;
			}
			currProfit = num[i] - num[currMin];
			if (currProfit > maxProfit) {
				buy = currMin;
				sell = i;
				maxProfit = currProfit;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// int num[] = { 5, 9, 3, 1, 7, 5, 8, 4, 3, 9, 9, 9 };
		int num[] = { 2, 1, 2, 1, 0, 1, 2 };
		// System.out.println(maxProfit(num));
		System.out.println(maxProfit_self(num));
		System.out.println(maxProfit_self_1(num));
	}

	public static int maxProfit_self(int num[]) {
		int left = 0;
		int currProfit = 0;
		int maxProfit = 0;
		for (int right = 1; right < num.length; right++) {
			if (num[right] < num[left]) {
				left = right;
			}
			currProfit = num[right] - num[left];
			maxProfit = Math.max(maxProfit, currProfit);
		}
		return maxProfit;
	}
	
	public static int maxProfit_self_1(int num[]) {
		int left = 0;
		int right = 0;
		int maxProfit = 0;
		int currProfit = 0;
		for(right = 1; right < num.length; right++) {
			if(num[left] > num[right]) {
				left = right;
			}
			currProfit = num[right] - num[left];
			maxProfit = Math.max(maxProfit, currProfit);
		}
		return maxProfit;
	}
}
