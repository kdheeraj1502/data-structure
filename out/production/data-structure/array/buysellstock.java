package array;

public class buysellstock {
   public static void main(String[] args) {
      int[] arr = new int[]{7, 1, 5, 3, 6, 4};
      maximiseprofit(arr);
   }

   public static void maximiseprofit(int[] arr) {
      int minprice = false;
      int maxprice = false;
      int minprice = arr[0];
      int profit = 0;

      for(int i = 1; i < arr.length; ++i) {
         if (arr[i] <= minprice) {
            minprice = arr[i];
         } else if (arr[i] - minprice >= profit) {
            profit = arr[i] - minprice;
         }
      }

      System.out.println(profit);
   }
}
