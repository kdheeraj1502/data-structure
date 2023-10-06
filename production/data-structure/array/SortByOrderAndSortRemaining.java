package array;

import java.util.Arrays;

public class SortByOrderAndSortRemaining {
   public static void sortAccording(int[] A1, int[] A2) {
      int m = A1.length;
      int n = A2.length;
      int[] temp = new int[m];
      int[] visited = new int[m];

      int index;
      for(index = 0; index < m; ++index) {
         temp[index] = A1[index];
         visited[index] = 0;
      }

      Arrays.sort(temp);
      index = 0;

      int i;
      for(i = 0; i < n; ++i) {
         int f = first(temp, 0, m - 1, A2[i], m);
         if (f != -1) {
            for(int j = f; j < m && temp[j] == A2[i]; ++j) {
               A1[index++] = temp[j];
               visited[j] = 1;
            }
         }
      }

      for(i = 0; i < m; ++i) {
         if (visited[i] == 0) {
            A1[index++] = temp[i];
         }
      }

   }

   static int first(int[] arr, int low, int high, int x, int n) {
      if (high < low) {
         return -1;
      } else {
         int mid = low + (high - low) / 2;
         if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
            return mid;
         } else {
            return x > arr[mid] ? first(arr, mid + 1, high, x, n) : first(arr, low, mid - 1, x, n);
         }
      }
   }

   public static void main(String[] args) {
      int[] num = new int[]{898, 1, 13422, 898, 3, 7, 1, 879, 13422, 6, 8, 8};
      int[] order = new int[]{13422, 1, 898, 3};
      sortAccording(num, order);
      System.out.println(Arrays.toString(num));
   }
}
