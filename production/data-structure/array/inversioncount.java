package array;

import java.util.Arrays;
import java.util.Scanner;

public class inversioncount {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int[] arr = new int[n];

      int ans;
      for(ans = 0; ans < arr.length; ++ans) {
         arr[ans] = scn.nextInt();
      }

      inversioncount(arr);
      ans = mergeSortAndCount(arr, 0, arr.length - 1);
      System.out.println(ans);
   }

   public static void inversioncount(int[] arr) {
      int count = 0;

      for(int i = 0; i < arr.length; ++i) {
         for(int j = i + 1; j < arr.length; ++j) {
            if (arr[i] > arr[j]) {
               ++count;
            }
         }
      }

      System.out.println(count);
   }

   public static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }

   private static int mergeAndCount(int[] arr, int l, int m, int r) {
      int[] left = Arrays.copyOfRange(arr, l, m + 1);
      int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
      int i = 0;
      int j = 0;
      int k = l;
      int swaps = 0;

      while(i < left.length && j < right.length) {
         if (left[i] <= right[j]) {
            arr[k++] = left[i++];
         } else {
            arr[k++] = right[j++];
            swaps += left.length - i;
         }
      }

      while(i < left.length) {
         arr[k++] = left[i++];
      }

      while(j < right.length) {
         arr[k++] = right[j++];
      }

      return swaps;
   }

   private static int mergeSortAndCount(int[] arr, int l, int r) {
      int count = 0;
      if (l < r) {
         int m = (l + r) / 2;
         count += mergeSortAndCount(arr, l, m);
         count += mergeSortAndCount(arr, m + 1, r);
         count += mergeAndCount(arr, l, m, r);
      }

      return count;
   }
}
