package array;

public class smallestsubarray {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 4, 45, 6, 0, 19};
      subarray(arr, 51);
   }

   public static void subarray(int[] arr, int sum) {
      int i = 0;
      int j = 0;
      int x = 0;
      int min = Integer.MAX_VALUE;

      while(i < arr.length && j < arr.length) {
         while(x <= sum && j < arr.length) {
            x += arr[j];
            ++j;
         }

         while(x > sum && i < arr.length) {
            int ml = j - i;
            if (ml < min) {
               min = ml;
            }

            x -= arr[i];
            ++i;
         }
      }

      System.out.println(min);
   }
}
