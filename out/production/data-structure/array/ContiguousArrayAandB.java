package array;

import java.util.HashSet;

public class ContiguousArrayAandB {
   public static int contigousArray(int[] A, int[] B) {
      HashSet<Integer> set = new HashSet();
      int[] var3 = B;
      int maxSum = B.length;

      int i;
      for(i = 0; i < maxSum; ++i) {
         Integer b = var3[i];
         set.add(b);
      }

      int currMax = 0;
      maxSum = 0;

      for(i = 0; i < A.length; ++i) {
         if (set.contains(A[i])) {
            currMax = 0;
         } else {
            currMax = Math.max(A[i], A[i] + currMax);
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
