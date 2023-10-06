package searchingandsorting;

public class findfirstandlastindex {
   public static void main(String[] args) {
      int[] arr = new int[]{1};
      find(arr, 4);
   }

   public static void find(int[] arr, int n) {
      if (arr.length == 1 && arr[0] == n) {
         int[] list = new int[2];
         System.out.println("0 0");
      }

      int l = 0;
      int r = arr.length - 1;
      int first = -1;
      int last = -1;

      while(l <= r) {
         int mid = (l + r) / 2;
         if (arr[mid] < n) {
            l = mid + 1;
         } else {
            if (arr[mid] <= n) {
               first = mid;

               for(last = mid; first >= 0 && arr[first] == n; --first) {
               }

               ++first;

               while(last < arr.length && arr[last] == n) {
                  ++last;
               }

               --last;
               break;
            }

            r = mid - 1;
         }
      }

      System.out.println(first + " " + last);
   }
}
