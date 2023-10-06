package bit.masking;

public class XOROfSubarray {
   static int getTotalXorOfSubarrayXors(int[] arr, int N) {
      if (N % 2 == 0) {
         return 0;
      } else {
         int res = 0;

         for(int i = 0; i < N; i += 2) {
            res ^= arr[i];
         }

         return res;
      }
   }

   public static void main(String[] args) {
      int[] arr = new int[]{3, 5, 2, 4, 6, 7};
      int N = arr.length;
      System.out.println(getTotalXorOfSubarrayXors(arr, N));
   }
}
