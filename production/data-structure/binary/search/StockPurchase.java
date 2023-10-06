package binary.search;

public class StockPurchase {
   public static int maxProfit(int[] num) {
      int buy = 0;
      int sell = 0;
      int currMin = 0;
      int currProfit = false;
      int maxProfit = 0;

      for(int i = 0; i < num.length; ++i) {
         if (num[i] < num[currMin]) {
            currMin = i;
         }

         int currProfit = num[i] - num[currMin];
         if (currProfit > maxProfit) {
            buy = currMin;
            sell = i;
            maxProfit = currProfit;
         }
      }

      System.out.println("buy " + buy + " sell " + sell);
      return maxProfit;
   }

   public static int maxProfit(int[] price, int start, int end) {
      if (end <= start) {
         return 0;
      } else {
         int profit = 0;

         for(int i = start; i < end; ++i) {
            for(int j = i + 1; j <= end; ++j) {
               if (price[j] > price[i]) {
                  int curr_profit = price[j] - price[i] + maxProfit(price, start, i - 1) + maxProfit(price, j + 1, end);
                  profit = Math.max(profit, curr_profit);
               }
            }
         }

         return profit;
      }
   }

   static int maxProfit_1(int[] prices, int size) {
      int maxProfit = 0;

      for(int i = 1; i < size; ++i) {
         if (prices[i] > prices[i - 1]) {
            maxProfit += prices[i] - prices[i - 1];
         }
      }

      return maxProfit;
   }

   public static void main(String[] args) {
      int[] num = new int[]{34, 57, 74, 76, 90, 25, 15, 11, 8};
      System.out.println(maxProfit(num));
      System.out.println(maxProfit(num, 0, num.length - 1));
      System.out.println(maxProfit_1(num, num.length));
   }
}
