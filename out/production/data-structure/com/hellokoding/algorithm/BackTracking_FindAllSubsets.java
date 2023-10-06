package com.hellokoding.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BackTracking_FindAllSubsets {
   List<LinkedList<Integer>> result = new ArrayList();

   void printSubsets() {
      Iterator var1 = this.result.iterator();

      while(var1.hasNext()) {
         LinkedList<Integer> subset = (LinkedList)var1.next();
         System.out.println(String.valueOf(subset));
      }

   }

   void enumerate(int[] a, int startIndex, LinkedList<Integer> currentSubset) {
      this.result.add(new LinkedList(currentSubset));

      for(int i = startIndex; i < a.length; ++i) {
         currentSubset.addLast(a[i]);
         this.enumerate(a, i + 1, currentSubset);
         currentSubset.removeLast();
      }

   }

   public static void main(String[] args) {
      int[] a = new int[]{1, 2, 3};
      BackTracking_FindAllSubsets findAllSubsets = new BackTracking_FindAllSubsets();
      findAllSubsets.enumerate(a, 0, new LinkedList());
      findAllSubsets.printSubsets();
   }
}
