package backtracking;

public class largestnoinkswap {
   public static String max;

   public static void main(String[] args) {
      String s = "4551711527";
      int k = 3;
      char[] arr = s.toCharArray();
      max = s;
      swap(arr, k, 0);
      System.out.println(max);
   }

   public static void swap(char[] arr, int k, int noswap) {
      String s = String.valueOf(arr);
      if (s.compareTo(max) > 0) {
         max = s;
      }

      if (noswap != k) {
         for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = i + 1; j < arr.length; ++j) {
               if (arr[i] < arr[j]) {
                  char temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp;
                  swap(arr, k, noswap + 1);
                  temp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = temp;
               }
            }
         }

      }
   }
}
