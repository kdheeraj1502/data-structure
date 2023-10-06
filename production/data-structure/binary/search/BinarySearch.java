package binary.search;

public class BinarySearch {
   public static int getFirst(int[] num, int val) {
      int start = 0;
      int end = num.length - 1;
      int index = -1;

      while(start <= end) {
         int mid = (start + end) / 2;
         if (num[mid] == val && (mid == 0 || num[mid - 1] < num[mid])) {
            index = mid;
            break;
         }

         if (num[mid] > val) {
            start = mid + 1;
         } else {
            end = mid - 1;
         }
      }

      return index;
   }

   public static int getLast(int[] num, int val) {
      int start = 0;
      int end = num.length - 1;
      int index = -1;

      while(start <= end) {
         int mid = (start + end) / 2;
         if (num[mid] == val && (mid == num.length - 1 || num[mid + 1] != num[mid])) {
            index = mid;
            break;
         }

         if (num[mid] < val) {
            end = mid - 1;
         } else {
            start = mid + 1;
         }
      }

      return index;
   }

   public static int search(int[] num, int start, int end, int val) {
      int index = -1;

      while(start <= end) {
         int mid = (start + end) / 2;
         if (num[mid] == val) {
            index = mid;
            break;
         }

         if (num[mid] < val) {
            start = mid + 1;
         } else {
            end = mid - 1;
         }
      }

      return index;
   }

   public static int searchRecursively(int[] num, int low, int high, int val) {
      int mid = (low + high) / 2;
      int index = true;
      int index;
      if (num[mid] == val) {
         index = mid;
      } else if (num[mid] < val) {
         index = searchRecursively(num, low, mid - 1, val);
      } else {
         index = searchRecursively(num, mid + 1, high, val);
      }

      return index;
   }
}
