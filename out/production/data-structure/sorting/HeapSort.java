package sorting;

public class HeapSort {
   public static void sort(int[] arr) {
      int n = arr.length;

      int i;
      for(i = n / 2 - 1; i >= 0; --i) {
         heapify(arr, n, i);
      }

      for(i = n - 1; i > 0; --i) {
         int temp = arr[0];
         arr[0] = arr[i];
         arr[i] = temp;
         heapify(arr, i, 0);
      }

   }

   private static void heapify(int[] arr, int n, int i) {
      int largest = i;
      int l = 2 * i + 1;
      int r = 2 * i + 2;
      if (l < n && arr[l] > arr[i]) {
         largest = l;
      }

      if (r < n && arr[r] > arr[largest]) {
         largest = r;
      }

      if (largest != i) {
         int swap = arr[i];
         arr[i] = arr[largest];
         arr[largest] = swap;
         heapify(arr, n, largest);
      }

   }
}