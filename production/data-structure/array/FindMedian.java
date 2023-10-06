package array;

import java.util.Arrays;

public class FindMedian {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      if ((nums1.length != 0 || nums2.length != 0) && (nums1.length == 0 || nums2.length == 0)) {
         return 0.0;
      } else if (nums1.length == 1 && nums2.length == 0 || nums1.length == 0 && nums2.length == 1) {
         return 1.0;
      } else if (nums1.length == 0 && nums2.length == 0) {
         return 0.0;
      } else {
         int a = 0;
         int b = 0;
         int i = 0;
         int[] result = new int[nums1.length + nums2.length];

         while(a < b) {
            while(a < nums1.length && b < nums2.length) {
               if (nums1[a] < nums2[b]) {
                  result[i++] = nums1[a++];
               } else {
                  result[i++] = nums2[b++];
               }
            }

            while(a < nums1.length) {
               result[i++] = nums1[a++];
            }

            while(b < nums2.length) {
               result[i++] = nums2[b++];
            }
         }

         System.out.print(Arrays.toString(result));
         int size = result.length;
         if (size % 2 == 0) {
            int index = size / 2;
            return (double)((result[index] + result[index - 1]) / 2);
         } else {
            return (double)result[size / 2];
         }
      }
   }

   public static void main(String[] args) {
      int[] a1 = new int[]{10, 27, 38, 43, 82};
      int[] a2 = new int[]{3, 9};
      merge(a1, a2, a1.length, a2.length);
   }

   private static int nextGap(int gap) {
      return gap <= 1 ? 0 : gap / 2 + gap % 2;
   }

   private static void merge(int[] arr1, int[] arr2, int n, int m) {
      int gap = n + m;

      for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
         int i;
         int temp;
         for(i = 0; i + gap < n; ++i) {
            if (arr1[i] > arr1[i + gap]) {
               temp = arr1[i];
               arr1[i] = arr1[i + gap];
               arr1[i + gap] = temp;
            }
         }

         int j;
         for(j = gap > n ? gap - n : 0; i < n && j < m; ++j) {
            if (arr1[i] > arr2[j]) {
               temp = arr1[i];
               arr1[i] = arr2[j];
               arr2[j] = temp;
            }

            ++i;
         }

         if (j < m) {
            for(j = 0; j + gap < m; ++j) {
               if (arr2[j] > arr2[j + gap]) {
                  temp = arr2[j];
                  arr2[j] = arr2[j + gap];
                  arr2[j + gap] = temp;
               }
            }
         }
      }

   }
}
