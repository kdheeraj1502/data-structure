package com.hellokoding.algorithm;

import java.util.Arrays;

public class SubarrayGivenSumBruteforce {
   public static int[] findSubarray(int[] a, int k) {
      for(int i = 0; i < a.length; ++i) {
         int currentSum = a[i];

         for(int j = i + 1; j <= a.length; ++j) {
            if (currentSum == k) {
               return Arrays.copyOfRange(a, i, j);
            }

            if (currentSum > k || j == a.length) {
               break;
            }

            currentSum += a[j];
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
