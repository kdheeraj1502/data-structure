package array;

import java.util.HashSet;

public class unionintersectionofarrays {
   public static void main(String[] args) {
      int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
      int[] arr2 = new int[]{5, 6, 7, 8, 9};
      unionhashmap(arr1, arr2);
      printIntersection(arr1, arr2);
   }

   public static void unionhashmap(int[] arr1, int[] arr2) {
      HashSet<Integer> union = new HashSet();

      int i;
      for(i = 0; i < arr1.length; ++i) {
         union.add(arr1[i]);
      }

      for(i = 0; i < arr2.length; ++i) {
         union.add(arr2[i]);
      }

      System.out.println(union);
   }

   static void printIntersection(int[] arr1, int[] arr2) {
      HashSet<Integer> hs = new HashSet();
      new HashSet();

      int i;
      for(i = 0; i < arr1.length; ++i) {
         hs.add(arr1[i]);
      }

      for(i = 0; i < arr2.length; ++i) {
         if (hs.contains(arr2[i])) {
            System.out.print(arr2[i] + " ");
         }
      }

   }

   public static int[] unionIntersection(int[] arr1, int[] arr2) {
      int[] temp = new int[arr1.length + arr2.length];

      int i;
      for(i = 0; i < arr1.length; ++i) {
         temp[i] = arr1[i];
      }

      for(i = 0; i < arr2.length; ++i) {
         int flag = false;

         for(int j = 0; j < arr1.length; ++j) {
            if (arr2[i] == arr1[j]) {
               flag = true;
            }
         }

         if (!flag) {
            temp[arr1.length + i] = arr2[i];
         }
      }

      return temp;
   }

   public static boolean search(int[] arr, int no) {
      int lo = 0;
      int hi = arr.length - 1;

      while(lo <= hi) {
         int mid = (lo + hi) / 2;
         if (arr[mid] > no) {
            hi = mid - 1;
         } else {
            if (arr[mid] >= no) {
               return true;
            }

            lo = mid + 1;
         }
      }

      return false;
   }
}
