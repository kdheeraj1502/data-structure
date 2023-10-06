package sorting;

public class MergeSort {
   public static void sort(int[] num) {
      int low = 0;
      int high = num.length - 1;
      mergeSort(num, low, high);
   }

   private static void mergeSort(int[] num, int low, int high) {
      if (low < high) {
         int mid = (low + high) / 2;
         mergeSort(num, low, mid);
         mergeSort(num, mid + 1, high);
         merge(num, low, mid, high);
      }

   }

   private static void merge(int[] num, int low, int mid, int high) {
      int l = mid - low + 1;
      int r = high - mid;
      int[] L = new int[l];
      int[] R = new int[r];

      int i;
      for(i = 0; i < l; ++i) {
         L[i] = num[low + i];
      }

      int j;
      for(j = 0; j < R.length; ++j) {
         R[j] = num[mid + 1 + j];
      }

      i = 0;
      j = 0;
      int k = low;

      while(i < l && j < r) {
         if (L[i] <= R[j]) {
            num[k++] = L[i++];
         } else {
            num[k++] = R[j++];
         }
      }

      while(i < l) {
         num[k++] = L[i++];
      }

      while(j < r) {
         num[k++] = R[j++];
      }

   }
}
