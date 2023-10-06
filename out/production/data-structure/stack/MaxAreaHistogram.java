package stack;

public class MaxAreaHistogram {
   public static int getMaxArea(int[] num) {
      int size = num.length;
      int maxArea = -1;
      int minHeight = false;

      for(int i = 1; i < size; ++i) {
         int minHeight = num[i];

         for(int j = i; j >= 0; --j) {
            if (minHeight > num[j]) {
               minHeight = num[j];
            }

            int currArea = minHeight * (i - j + 1);
            if (maxArea < currArea) {
               System.out.println("i is " + i + " j is : " + j + " curr area is " + currArea);
               maxArea = currArea;
            }
         }
      }

      return maxArea;
   }

   public static void main(String[] args) {
      int[] num = new int[]{7, 6, 5, 44, 1, 6, 3, 1};
      System.out.println(getMaxArea(num));
      System.out.println(solution1(num));
   }

   public static int solution1(int[] num) {
      if (num.length == 0) {
         return 0;
      } else {
         int[][] dp = new int[num.length][num.length];
         int max = Integer.MIN_VALUE;

         for(int width = 1; width <= num.length; ++width) {
            for(int l = 0; l + width - 1 < num.length; ++l) {
               int r = l + width - 1;
               if (width == 1) {
                  dp[l][l] = num[l];
                  max = Math.max(max, dp[l][l]);
               } else {
                  dp[l][r] = Math.min(dp[l][r - 1], num[r]);
                  max = Math.max(max, dp[l][r] * width);
               }
            }
         }

         return max;
      }
   }
}
