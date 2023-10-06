package array;

public class reversearray {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 4, 5};
      reverse(arr, 0, 4);
   }

   public static void reverse(int[] arr, int start, int end) {
      while(start < end) {
         int temp = arr[start];
         arr[start] = arr[end];
         arr[end] = temp;
         ++start;
         --end;
      }

      for(int i = 0; i < arr.length; ++i) {
         System.out.println(arr[i]);
      }

   }
}
