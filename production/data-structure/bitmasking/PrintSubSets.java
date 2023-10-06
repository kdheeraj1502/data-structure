package bitmasking;

public class PrintSubSets {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 4};
      subsets(arr);
   }

   public static void subsets(int[] arr) {
      int limit = 1 << arr.length;

      for(int i = 0; i < limit; ++i) {
         String set = "";
         int temp = i;

         for(int j = arr.length - 1; j >= 0; --j) {
            if ((temp & 1) == 1) {
               set = arr[j] + set;
            } else {
               set = " _ " + set;
            }

            temp >>= 1;
         }

         System.out.println(set);
      }

   }
}
