package array;

public class buysellstockfees {
   public static void main(String[] args) {
      int[] arr = new int[]{10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25};
      buysell(arr, 3);
   }

   public static void buysell(int[] arr, int fees) {
      int bs = -arr[0];
      int ss = 0;
      System.out.println("  " + bs + " ---- " + ss);

      for(int i = 1; i < arr.length; ++i) {
         if (bs < ss - arr[i]) {
            bs = ss - arr[i];
         }

         if (ss < arr[i] + bs - fees) {
            ss = arr[i] + bs - fees;
         }

         System.out.println("  " + bs + " ---- " + ss);
      }

      System.out.println(ss);
   }
}
