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
		int num[] = { 5, 9, 3, 1, 7, 5, 8, 4, 3, 9, 9, 9 };
		// System.out.println(maxProfit(num));
		System.out.println(maxProfit_self(num));
	}

	public static int maxProfit_self(int num[]) {
		int min = 0;
		int profit = 0;
		int currProfit = 0;
		int maxProfit = 0;
		for(int i = 0; i < num.length; i++) {
			if(num[i] < num[min]) {
				min = i;
			}
			currProfit = num[i] - num[min];
			maxProfit = Math.max(maxProfit, currProfit);
		}
		return maxProfit;
	}
}
