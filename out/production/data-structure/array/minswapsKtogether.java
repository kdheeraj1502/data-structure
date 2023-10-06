package array;

public class minswapsKtogether {
   public static void main(String[] args) {
      int[] arr = new int[]{10, 12, 20, 20, 5, 19, 19, 12, 1, 20, 1};
      ktogether(arr, 1);
   }

   public static void ktogether(int[] arr, int k) {
      int klessequal = 0;
      int min = Integer.MAX_VALUE;

      int i;
      for(i = 0; i < arr.length; ++i) {
         if (arr[i] <= k) {
            ++klessequal;
         }
      }

      i = 0;

      for(int j = klessequal - 1; j < arr.length; ++j) {
         int kgreater = 0;

         for(int j2 = i; j2 <= j; ++j2) {
            if (arr[j2] > k) {
               ++kgreater;
            }
         }

         if (min > kgreater) {
            min = kgreater;
         }

         ++i;
      }

      System.out.println(min);
   }
}
