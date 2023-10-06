package searchingandsorting;

public class bookallocation {
   public static void main(String[] args) {
      int[] arr = new int[]{250, 74, 159, 181, 23, 45, 129, 174};
      int m = 6;
      allocation(arr, m);
   }

   public static void allocation(int[] arr, int m) {
      int lo = 0;

      int hi;
      for(hi = 0; hi < arr.length; ++hi) {
         if (lo < arr[hi]) {
            lo = arr[hi];
         }
      }

      hi = 0;

      int max;
      for(max = 0; max < arr.length; ++max) {
         hi += arr[max];
      }

      max = Integer.MAX_VALUE;

      while(lo <= hi) {
         int mid = lo + (hi - lo) / 2;
         int nostudents = 1;
         int nopages = 0;

         for(int i = 0; i < arr.length && arr[i] <= mid; ++i) {
            if (arr[i] + nopages <= mid) {
               nopages += arr[i];
            } else {
               ++nostudents;
               nopages = arr[i];
            }
         }

         if (nostudents <= m) {
            if (max > mid) {
               max = mid;
            }

            hi = mid - 1;
         } else {
            lo = mid + 1;
         }
      }

      System.out.println(max);
   }
}
