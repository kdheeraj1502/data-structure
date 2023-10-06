package array;

public class buysellstock2tran {
   public static void main(String[] args) {
      int[] arr = new int[]{10, 22, 5, 75, 65, 80};
      buysell(arr);
   }

   public static void buysell(int[] arr) {
      int[] lr = new int[arr.length];
      int[] rl = new int[arr.length];
      int minprice = arr[0];

      int maxprice;
      int maxsum;
      for(maxprice = 1; maxprice < arr.length; ++maxprice) {
         if (minprice >= arr[maxprice]) {
            minprice = arr[maxprice];
         }

         maxsum = arr[maxprice] - minprice;
         if (maxsum >= lr[maxprice - 1]) {
            lr[maxprice] = maxsum;
         } else {
            lr[maxprice] = lr[maxprice - 1];
         }

         System.out.println(lr[maxprice]);
      }

      System.out.println();
      maxprice = arr[arr.length - 1];

      int i;
      for(maxsum = arr.length - 2; maxsum >= 0; --maxsum) {
         if (maxprice <= arr[maxsum]) {
            maxprice = arr[maxsum];
         }

         i = maxprice - arr[maxsum];
         if (i >= rl[maxsum + 1]) {
            rl[maxsum] = i;
         } else {
            rl[maxsum] = rl[maxsum + 1];
         }

         System.out.println(rl[maxsum]);
      }

      System.out.println();
      maxsum = 0;

      for(i = 0; i < rl.length; ++i) {
         if (maxsum < lr[i] + rl[i]) {
            maxsum = lr[i] + rl[i];
         }
      }

      System.out.println(maxsum);
   }
}
