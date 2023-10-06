package com.hellokoding.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LISByDPBottomUp {
   static List<Integer> findLIS(int[] arr) {
      List<List<Integer>> cache = new ArrayList();

      int i;
      for(i = 0; i < arr.length; ++i) {
         cache.add(new ArrayList());
      }

      ((List)cache.get(0)).add(arr[0]);

      int i;
      for(i = 1; i < arr.length; ++i) {
         for(i = 0; i < i; ++i) {
            if (arr[i] > arr[i] && ((List)cache.get(i)).size() < ((List)cache.get(i)).size() + 1) {
               cache.set(i, new ArrayList((Collection)cache.get(i)));
            }
         }

         ((List)cache.get(i)).add(arr[i]);
      }

      List<Integer> longest = (List)cache.get(0);

      for(i = 0; i < cache.size(); ++i) {
         if (((List)longest).size() < ((List)cache.get(i)).size()) {
            longest = new ArrayList((Collection)cache.get(i));
         }
      }

      return (List)longest;
   }

   public static void main(String[] args) {
      int[] arr = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
      System.out.println(findLIS(arr).toString());
   }
}
