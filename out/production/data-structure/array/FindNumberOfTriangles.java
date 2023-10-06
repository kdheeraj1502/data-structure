package array;

import java.util.Arrays;

public class FindNumberOfTriangles {
   public static int numberOfTriangles(int[] num) {
      Arrays.sort(num);
      int count = 0;

      for(int i = num.length - 1; i > 0; --i) {
         int start = 0;
         int end = i - 1;
         int a = num[i];

         while(start < end) {
            int b = num[start];
            int c = num[end];
            int sum = b + c;
            if (sum > a) {
               System.out.println("Triplet : " + num[i] + " < " + num[start] + " + " + num[end]);
               ++count;
               --end;
            } else {
               ++start;
            }
         }
      }

      return count;
   }

   static void countTriangles(int[] A) {
      Arrays.sort(A);
      int count = 0;

      for(int i = A.length - 1; i >= 1; --i) {
         int start = 0;

         for(int end = i - 1; start < end; ++start) {
            if (A[start] + A[end] > A[i]) {
               ++count;
               System.out.println("Triplet : " + A[i] + " < " + A[start] + " + " + A[end]);
            }
         }
      }

      System.out.print("No of possible solutions: " + count);
   }

   static void countTrianglesBook(int[] num) {
      int count = 0;
      Arrays.sort(num);

      for(int i = 0; i < num.length - 2; ++i) {
         int k = i + 2;

         for(int j = i + 1; j < num.length - 1; ++j) {
            while(k < num.length && num[i] + num[j] > num[k]) {
               System.out.println("Triplet : " + num[k] + " < " + num[i] + " + " + num[j]);
               ++k;
               count += k - j - i;
            }
         }
      }

      System.out.println(count);
   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 2, 3, 4, 5};
      int count = numberOfTriangles(num);
      System.out.println(count);
      countTriangles(num);
      System.out.println();
      countTrianglesBook(num);
   }
}
