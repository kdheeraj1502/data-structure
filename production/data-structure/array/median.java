package array;

public class median {
   public static void main(String[] args) {
      int[] arr = new int[]{5, 7, -2, 4, 1, 3};
      quicksort(arr, 0, arr.length - 1);

      for(int i = 0; i < arr.length; ++i) {
         System.out.println(arr[i]);
      }

   }

   public static void median(int[] arr) {
      quicksort(arr, 0, arr.length - 1);
      int size = arr.length;
      if (size % 2 == 0) {
         System.out.println((arr[(size - 1) / 2] + arr[(size + 1) / 2]) / 2);
      } else {
         System.out.println(arr[(size - 1) / 2]);
      }

   }

   public static void quicksort(int[] arr, int start, int end) {
      if (start < end) {
         int p = partition(arr, start, end, arr[end]);
         quicksort(arr, start, p - 1);
         quicksort(arr, p + 1, end);
      }
   }

   public static int partition(int[] arr, int start, int end, int pivot) {
      int i = start;
      int j = start;

      while(j <= end) {
         if (arr[j] > pivot) {
            ++j;
         } else {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            ++i;
            ++j;
         }
      }

      return i - 1;
   }
}
