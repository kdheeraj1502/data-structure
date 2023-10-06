package array;

import java.util.Arrays;

public class mergearrayNospace {
   public static void main(String[] args) {
      int[] arr1 = new int[]{5, 18, 20};
      int[] arr2 = new int[]{10, 12};
      mergearray(arr1, arr2);
   }

   public static void merge(int[] arr1, int[] arr2) {
      int i = 0;
      int j = 0;

      int k;
      while(i < arr1.length && j < arr2.length) {
         if (arr1[i] > arr2[j]) {
            k = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = k;
            ++i;
            sort(arr2);
         } else {
            ++i;
         }
      }

      for(k = 0; k < arr1.length; ++k) {
         System.out.println(arr1[k]);
      }

      for(k = 0; k < arr2.length; ++k) {
         System.out.println(arr2[k]);
      }

   }

   public static void sort(int[] arr) {
      for(int i = 0; i < arr.length - 1; ++i) {
         if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
         }
      }

   }

   public static void mergearray(int[] arr1, int[] arr2) {
      int i = arr1.length - 1;

      int j2;
      for(int j = 0; i >= 0 && j < arr2.length && arr1[i] > arr2[j]; ++j) {
         j2 = arr1[i];
         arr1[i] = arr2[j];
         arr2[j] = j2;
         --i;
      }

      Arrays.sort(arr1);
      Arrays.sort(arr2);

      for(j2 = 0; j2 < arr1.length; ++j2) {
         System.out.println(arr1[j2]);
      }

      System.out.println();

      for(j2 = 0; j2 < arr2.length; ++j2) {
         System.out.println(arr2[j2]);
      }

   }
}
