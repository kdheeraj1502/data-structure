package searchingandsorting;

public class productarray {
   public static void main(String[] args) {
   }

   public static long[] productExceptSelf(int[] arr, int n) {
      long[] ans = new long[n];
      if (n == 1) {
         ans[0] = 1L;
         return ans;
      } else {
         long[] left = new long[n];
         long[] right = new long[n];
         left[0] = (long)arr[0];

         int i;
         for(i = 1; i < n; ++i) {
            left[i] = left[i - 1] * (long)arr[i];
         }

         right[n - 1] = (long)arr[n - 1];

         for(i = n - 2; i >= 0; --i) {
            right[i] = right[i + 1] * (long)arr[i];
         }

         ans[0] = right[1];
         ans[n - 1] = left[n - 2];

         for(i = 1; i < n - 1; ++i) {
            ans[i] = left[i - 1] * right[i + 1];
         }

         return ans;
      }
   }

   public static long[] productExceptSelfopti(int[] arr, int n) {
      long[] ans = new long[n];
      if (n == 1) {
         ans[0] = 1L;
         return ans;
      } else {
         ans[0] = (long)arr[0];

         for(int i = 1; i < n; ++i) {
            ans[i] = ans[i - 1] * (long)arr[i];
         }

         ans[n - 1] = ans[n - 2];
         long rp = (long)arr[n - 1];

         for(int i = n - 2; i > 0; --i) {
            ans[i] = ans[i - 1] * rp;
            rp *= (long)arr[i];
         }

         ans[0] = rp;
         return ans;
      }
   }
}
