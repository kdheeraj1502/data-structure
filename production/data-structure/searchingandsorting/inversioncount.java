package searchingandsorting;

import java.util.Scanner;

public class inversioncount {
   public static long c = 0L;

   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      long n = scn.nextLong();
      long[] arr = new long[(int)n];

      for(int i = 0; i < arr.length; ++i) {
         arr[i] = scn.nextLong();
      }

      long ans = inversionCount(arr, n);
      System.out.println(ans);
   }

   static long inversionCount(long[] arr, long N) {
      c = 0L;
      long[] fans = mergesort(arr, 0, arr.length - 1);

      for(int i = 0; i < fans.length; ++i) {
         System.out.println(fans[i]);
      }

      return c;
   }

   static long[] mergesort(long[] arr, int start, int end) {
      if (start == end) {
         long[] ans = new long[]{arr[start]};
         return ans;
      } else {
         int mid = (start + end) / 2;
         long[] arr1 = mergesort(arr, start, mid);
         long[] arr2 = mergesort(arr, mid + 1, end);
         return merge(arr1, arr2);
      }
   }

   static long[] merge(long[] arr1, long[] arr2) {
      long[] ans = new long[arr1.length + arr2.length];
      int i = 0;
      int j = 0;
      int k = 0;

      while(i < arr1.length && j < arr2.length) {
         if (arr1[i] <= arr2[j]) {
            ans[k++] = arr1[i];
            ++i;
         } else {
            ans[k++] = arr2[j];
            ++j;
            c += (long)(arr1.length - i);
         }
      }

      while(i < arr1.length) {
         ans[k++] = arr1[i];
         ++i;
      }

      while(j < arr2.length) {
         ans[k++] = arr2[j];
         ++j;
      }

      return ans;
   }
}
