package greedy;

public class gergovia {
   public static void main(String[] args) {
      FastReader scn = new FastReader();

      while(true) {
         int n = scn.nextInt();
         if (n == 0) {
            return;
         }

         long[] arr = new long[n];

         for(int i = 0; i < arr.length; ++i) {
            arr[i] = scn.nextLong();
         }

         solve2(arr);
      }
   }

   public static void solve(int[] arr) {
      int work = 0;

      for(int i = 0; i < arr.length; ++i) {
         for(int j = i + 1; j < arr.length; ++j) {
            int min;
            if (arr[i] > 0) {
               if (arr[j] < 0) {
                  min = Math.min(arr[i], -arr[j]);
                  arr[i] -= min;
                  arr[j] += min;
                  work += (j - i) * min;
               }
            } else if (arr[j] > 0) {
               min = Math.min(-arr[i], arr[j]);
               arr[i] += min;
               arr[j] -= min;
               work += (j - i) * min;
            }
         }
      }

      System.out.println(work);
   }

   public static void solve2(long[] arr) {
      long work = 0L;
      int sell = 0;
      int buy = 0;

      while(true) {
         while(sell < arr.length && arr[sell] >= 0L) {
            ++sell;
         }

         while(buy < arr.length && arr[buy] <= 0L) {
            ++buy;
         }

         if (sell == arr.length || buy == arr.length) {
            System.out.println(work);
            return;
         }

         long min = Math.min(arr[buy], -arr[sell]);
         work += min * (long)Math.abs(sell - buy);
         arr[buy] -= min;
         arr[sell] += min;
      }
   }
}
