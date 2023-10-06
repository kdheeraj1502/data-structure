package com.hellokoding.algorithm;

import java.util.HashMap;
import java.util.Map;

public class SubarrayGivenSumHashtable {
   public static int countSubArrays(int[] a, int k) {
      int count = 0;
      int cumulativeSum = 0;
      Map<Integer, Integer> map = new HashMap();
      map.put(0, 1);
      int[] var5 = a;
      int var6 = a.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         int value = var5[var7];
         cumulativeSum += value;
         if (map.containsKey(cumulativeSum - k)) {
            count += (Integer)map.get(cumulativeSum - k);
         }

         map.put(cumulativeSum, (Integer)map.getOrDefault(cumulativeSum, 0) + 1);
      }

      return count;
   }

   public static void main(String[] args) {
      int[] a = new int[]{-4, 12, -11, 6, 1, 7};
      int k = 8;
      System.out.println(countSubArrays(a, k));
   }
}
