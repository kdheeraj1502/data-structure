package com.hellokoding.algorithm;

import java.util.Arrays;

public class SubarrayGivenSumWindowSliding {
   public static int[] findSubarray(int[] a, int k) {
      int windowSum = 0;
      int i = 0;

      for(int j = 0; i < a.length; windowSum -= a[i++]) {
         while(j < a.length && windowSum < k) {
            windowSum += a[j++];
         }

         if (windowSum == k) {
            return Arrays.copyOfRange(a, i, j);
         }
      }

      return null;
   }

   public static void main(String[] args) {
      int[] a = new int[]{4, 0, 11, 6, 1, 7};
      int k = 8;
      System.out.println(Arrays.toString(findSubarray(a, k)));
   }
}
