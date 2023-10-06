package heap;

public class kthlargest {
   public static void main(String[] args) {
      int[] arr = new int[]{3, 5, 1, 4, 6, 2};
      int k = 5;
      kthlargest(arr, k);
   }

   public static void largest(int[] arr, int k) {
      minheap heap = new minheap();

      for(int i = 0; i < arr.length; ++i) {
         if (i < k) {
            heap.add(arr[i]);
         } else if ((Integer)heap.heap.get(0) < arr[i]) {
            heap.remove();
            heap.add(arr[i]);
         }
      }

      System.out.println(heap.remove());
   }

   public static void kthlargest(int[] arr, int k) {
      int pi = partitioning(arr, 0, arr.length - 1);
      int ogi = arr.length - k;

      while(pi != ogi) {
         if (pi < ogi) {
            pi = partitioning(arr, pi + 1, arr.length - 1);
         } else {
            pi = partitioning(arr, 0, pi - 1);
         }
      }

      System.out.println(arr[pi]);
   }

   public static int partitioning(int[] arr, int st, int en) {
      int i = 0;
      int j = 0;
      int p = arr[en];

      while(j <= en) {
         if (arr[j] > p) {
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
