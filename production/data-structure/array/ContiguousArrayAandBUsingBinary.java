package array;

import java.util.Arrays;

public class ContiguousArrayAandBUsingBinary {
   public static int contigousArray(int[] A, int[] B) {
      Arrays.sort(B);
      int currMax = 0;
      int maxSum = 0;

      for(int i = 0; i < A.length; ++i) {
         if (BinarySearch.search(B, A[i]) != -1) {
            currMax = 0;
         } else {
            currMax = Math.max(A[i], currMax + A[i]);
            if (currMax < 0) {
               currMax = 0;
            }

            if (maxSum < currMax) {
               maxSum = currMax;
            }
         }
      }

      return maxSum;
   }

   public static void main(String[] args) {
      int[] A = new int[]{4, 9, 7, -3, 2, 9};
      int[] B = new int[]{1, 7, 9, 2, 3, -5, 1};
      System.out.println(contigousArray(A, B));
   }
}
