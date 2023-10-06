package dp;

public class buyingstockstwice {
   public static void main(String[] args) {
      int[] arr = new int[]{2, 30, 15, 10, 8, 25, 80};
      solve(arr);
   }

   public static void solve(int[] arr) {
      int[] buytoday = new int[arr.length];
      int[] selltoday = new int[arr.length];
      int min = arr[0];
      selltoday[0] = 0;

      int max;
      int ans;
      for(max = 1; max < selltoday.length; ++max) {
         if (min > arr[max]) {
            min = arr[max];
         }

         ans = arr[max] - min;
         selltoday[max] = Math.max(selltoday[max - 1], ans);
      }

      buytoday[arr.length - 1] = 0;
      max = arr[arr.length - 1];

      int i;
      for(ans = arr.length - 2; ans >= 0; --ans) {
         if (max < arr[ans]) {
            max = arr[ans];
         }

         i = max - arr[ans];
         buytoday[ans] = Math.max(buytoday[ans + 1], i);
      }

      for(ans = 0; ans < selltoday.length; ++ans) {
         System.out.println(selltoday[ans] + " " + buytoday[ans]);
      }

      ans = buytoday[0] + selltoday[0];

      for(i = 1; i < selltoday.length; ++i) {
         ans = Math.max(ans, selltoday[i] + buytoday[i]);
      }

      System.out.println(ans);
   }
}
