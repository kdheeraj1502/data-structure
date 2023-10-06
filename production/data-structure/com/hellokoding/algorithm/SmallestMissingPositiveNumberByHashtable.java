package com.hellokoding.algorithm;

import java.util.HashSet;

public class SmallestMissingPositiveNumberByHashtable {
   public static int findSmallest(int[] a) {
      HashSet<Integer> hashSet = new HashSet();
      int[] var2 = a;
      int var3 = a.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int value = var2[var4];
         if (value > 0) {
            hashSet.add(value);
         }
      }

      int min;
      for(min = 1; hashSet.contains(min); ++min) {
      }

      return min;
   }

   public static void main(String[] args) {
      System.out.println(findSmallest(new int[]{1, 3, 6, 4, 1, 2}));
      System.out.println(findSmallest(new int[]{-1, -3, 5}));
   }
}
