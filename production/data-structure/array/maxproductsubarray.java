package array;

public class maxproductsubarray {
   public static void main(String[] args) {
      int[] arr = new int[]{90, 91, -91, 91, -91, -90, 90, 90, -90, -90};
      maxproduct(arr);
      long a = 1876779194L;
      System.out.println(a);
   }

   public static void maxproduct(int[] arr) {
      long max = 1L;
      long min = 1L;
      long finalmax = -2147483648L;

      for(int i = 0; i < arr.length; ++i) {
         if (arr[i] == 0) {
            max = 1L;
            min = 1L;
         } else {
            long temp = max;
            max = Math.max(Math.max((long)arr[i], max * (long)arr[i]), min * (long)arr[i]);
            min = Math.min(Math.min((long)arr[i], temp * (long)arr[i]), min * (long)arr[i]);
            if (finalmax < max) {
               finalmax = max;
            }
         }
      }

      System.out.println(finalmax);
   }
}
