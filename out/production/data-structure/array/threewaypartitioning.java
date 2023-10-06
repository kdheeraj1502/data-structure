package array;

public class threewaypartitioning {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 3, 4, 1};
      threeWayPartition(arr, 2, 4);

      for(int i = 0; i < arr.length; ++i) {
         System.out.println(arr[i]);
      }

   }

   public static void partitioning(int[] arr, int a, int b) {
      int i = 0;
      int j = 0;
      int k = arr.length - 1;

      while(j <= k && j < arr.length) {
         int temp;
         if (arr[j] > b) {
            temp = arr[j];
            arr[j] = arr[k];
            arr[k] = temp;
            --k;
         } else if (arr[j] <= b && arr[j] > a) {
            ++j;
         } else if (arr[j] <= a) {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            ++i;
            ++j;
         }
      }

   }

   public static void threeWayPartition(int[] arr, int lowVal, int highVal) {
      int n = arr.length;
      int start = 0;
      int end = n - 1;
      int i = 0;

      while(i <= end) {
         int temp;
         if (arr[i] < lowVal) {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            ++start;
            ++i;
         } else if (arr[i] > highVal) {
            temp = arr[end];
            arr[end] = arr[i];
            arr[i] = temp;
            --end;
         } else {
            ++i;
         }
      }

   }
}
