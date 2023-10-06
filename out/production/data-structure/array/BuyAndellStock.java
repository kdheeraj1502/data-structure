package array;

public class BuyAndellStock {
   public static int maxProfit(int[] num) {
      int buy = false;
      int sell = false;
      int currMin = 0;
      int currProfit = false;
      int maxProfit = 0;

      for(int i = 0; i < num.length; ++i) {
         if (num[i] < num[currMin]) {
            currMin = i;
         }

         int currProfit = num[i] - num[currMin];
         if (currProfit > maxProfit) {
            maxProfit = currProfit;
         }
      }

      return maxProfit;
   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 1, 2, 1, 0, 1, 2};
      System.out.println(maxProfit_self(num));
      System.out.println(maxProfit_self_1(num));
   }

   public static int maxProfit_self(int[] num) {
      int left = 0;
      int currProfit = false;
      int maxProfit = 0;

      for(int right = 1; right < num.length; ++right) {
         if (num[right] < num[left]) {
            left = right;
         }

         int currProfit = num[right] - num[left];
         maxProfit = Math.max(maxProfit, currProfit);
      }

      return maxProfit;
   }

   public static int maxProfit_self_1(int[] num) {
      int left = 0;
      int right = false;
      int maxProfit = 0;
      int currProfit = false;

      for(int right = 1; right < num.length; ++right) {
         if (num[left] > num[right]) {
            left = right;
         }

         int currProfit = num[right] - num[left];
         maxProfit = Math.max(maxProfit, currProfit);
      }

      return maxProfit;
   }
}
