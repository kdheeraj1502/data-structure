package com.hellokoding.algorithm;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSortTopDown {
   public int[] sort(int[] arr) {
      int n = arr.length;
      if (n < 2) {
         return arr;
      } else {
         int[] left = Arrays.copyOfRange(arr, 0, n / 2);
         int[] right = Arrays.copyOfRange(arr, n / 2, n);
         int[] sortedLeft = this.sort(left);
         int[] sortedRight = this.sort(right);
         return this.merge(sortedLeft, sortedRight, n);
      }
   }

   private int[] merge(int[] left, int[] right, int n) {
      int[] result = new int[n];
      int l = 0;
      int r = 0;

      for(int i = 0; i < n; ++i) {
         if (l >= left.length || r < right.length && left[l] >= right[r]) {
            result[i] = right[r];
            ++r;
         } else {
            result[i] = left[l];
            ++l;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] a = new int[]{7, 9, 2, 3, 1};
      a = (new MergeSortTopDown()).sort(a);
      IntStream var10000 = Arrays.stream(a);
      PrintStream var10001 = System.out;
      var10000.forEach(var10001::println);
   }
}
