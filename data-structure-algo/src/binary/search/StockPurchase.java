package binary.search;

public class StockPurchase {

	public static int maxProfit(int num[]) {
		int buy = 0, sell = 0;
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
		System.out.println("buy " + buy + " sell " + sell);
		return maxProfit;
	}

	public static int maxProfit(int price[], int start, int end) {

		// If the stocks can't be bought
		if (end <= start)
			return 0;

		// Initialise the profit
		int profit = 0;

		// The day at which the stock
		// must be bought
		for (int i = start; i < end; i++) {

			// The day at which the
			// stock must be sold
			for (int j = i + 1; j <= end; j++) {

				// If buying the stock at ith day and
				// selling it at jth day is profitable
				if (price[j] > price[i]) {

					// Update the current profit
					int curr_profit = price[j] - price[i] + maxProfit(price, start, i - 1)
							+ maxProfit(price, j + 1, end);

					// Update the maximum profit so far
					profit = Math.max(profit, curr_profit);
				}
			}
		}
		return profit;
	}
	

    static int maxProfit_1(int prices[], int size)
    {
       
        // maxProfit adds up the difference between
        // adjacent elements if they are in increaisng order
        int maxProfit = 0;
       
        // The loop starts from 1
        // as its comparing with the previous
        for (int i = 1; i < size; i++)
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        return maxProfit;
    }
   

	public static void main(String[] args) {
		int num[] = { 34, 57, 74, 76, 90, 25, 15, 11, 8 };
		System.out.println(maxProfit(num));
		System.out.println(maxProfit(num, 0, num.length - 1));
		System.out.println(maxProfit_1(num, num.length));
	}
}
