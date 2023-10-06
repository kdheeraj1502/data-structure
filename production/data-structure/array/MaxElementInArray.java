package array;

import java.util.Arrays;

public class MaxElementInArray {
   public static int findMax(int[] arr) {
      int low = 0;
      int high = arr.length - 1;
      int middle = true;

      while(low <= high) {
         int middle = low + (high - low) / 2;
         if (middle == arr.length - 1 && arr[middle] > arr[middle - 1]) {
            return arr[middle];
         }

         if (middle < arr.length - 1 && arr[middle] > arr[middle + 1]) {
            return arr[middle];
         }

         if (arr[low] > arr[middle]) {
            high = middle - 1;
         } else {
            low = middle + 1;
         }
      }

      return -1;
   }

   public static int findMaxIndex(int[] arr) {
      int low = 0;
      int high = arr.length - 1;
      int middle = true;

      while(low <= high) {
         int middle = low + (high - low) / 2;
         if (middle == arr.length - 1 && arr[middle] > arr[middle - 1]) {
            return middle;
         }

         if (middle < arr.length - 1 && arr[middle] > arr[middle + 1]) {
            return middle;
         }

         if (arr[low] > arr[middle]) {
            high = middle - 1;
         } else {
            low = middle + 1;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      int[] num = new int[]{3, 4, 5, 1, 2};
      System.out.println("Array is : " + Arrays.toString(num) + " Max is " + findMax(num) + " Index is : " + findMaxIndex(num));
   }
}
