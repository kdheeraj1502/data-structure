package greedy;

import java.util.PriorityQueue;

public class buymaxstocks {
   public static void main(String[] args) {
      int[] price = new int[]{10, 7, 4};
      int k = 100;
      solve(price, k);
   }

   public static void solve(int[] price, int k) {
      PriorityQueue<pair> heap = new PriorityQueue();

      int maxn;
      for(maxn = 0; maxn < price.length; ++maxn) {
         heap.add(new pair(price[maxn], maxn + 1));
      }

      maxn = 0;
      int amt = 0;

      while(!heap.isEmpty()) {
         pair rv = (pair)heap.remove();

         for(int i = 1; i <= rv.n; ++i) {
            if (amt + rv.price <= k) {
               amt += rv.price;
               ++maxn;
            }
         }
      }

      System.out.println(maxn);
   }
}
