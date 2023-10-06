package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class minmaxcandies {
   public static void main(String[] args) {
   }

   static ArrayList<Integer> candyStore(int[] candies, int N, int K) {
      int mincost = 0;
      Arrays.sort(candies);
      int j = N - 1;

      int maxcost;
      int i;
      for(maxcost = 0; maxcost <= j; ++maxcost) {
         mincost += candies[maxcost];

         for(i = 0; j >= maxcost && i < K; ++i) {
            --j;
         }
      }

      j = 0;
      maxcost = 0;

      for(i = N - 1; i >= j; --i) {
         maxcost += candies[i];

         for(int c = 0; i > j && c < K; ++c) {
            ++j;
         }
      }

      ArrayList<Integer> ans = new ArrayList();
      ans.add(mincost);
      ans.add(maxcost);
      return ans;
   }
}
