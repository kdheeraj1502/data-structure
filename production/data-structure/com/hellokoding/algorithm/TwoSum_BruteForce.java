package com.hellokoding.algorithm;

public class TwoSum_BruteForce {
   static boolean bruteForce(int[] a, int k) {
      for(int i = 0; i < a.length; ++i) {
         for(int j = i + 1; j < a.length; ++j) {
            if (a[i] + a[j] == k) {
               return true;
            }
         }
      }

      return false;
   }

   public static void main(String[] args) {
      int[] a = new int[]{1, 3, 7};
      System.out.println(bruteForce(a, 8));
      System.out.println(bruteForce(a, 5));
      int[] b = new int[]{4, -9, 0, 11, 6, -20, 1, 7};
      System.out.println(bruteForce(b, -14));
      System.out.println(bruteForce(b, -15));
   }
}
