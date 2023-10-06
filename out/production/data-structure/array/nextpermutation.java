package array;

public class nextpermutation {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 5, 4};
      nextperm(arr);

      for(int i = 0; i < arr.length; ++i) {
         System.out.println(arr[i]);
      }

   }

   public static void nextperm(int[] arr) {
      int i;
      for(i = arr.length - 2; i >= 0 && arr[i] >= arr[i + 1]; --i) {
      }

      if (i >= 0) {
         int j;
         for(j = arr.length - 1; arr[j] <= arr[i]; --j) {
         }

         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
      }

      reverse(arr, i + 1);
   }

   public static void reverse(int[] arr, int i) {
      for(int j = arr.length - 1; i < j; --j) {
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
         ++i;
      }

   }
}
