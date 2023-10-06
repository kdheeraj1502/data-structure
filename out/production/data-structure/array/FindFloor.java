package array;

public class FindFloor {
   public static int findFloor(int[] num, int key) {
      int start = 0;
      int end = num.length;

      while(start <= end) {
         int mid = (start + end) / 2;
         if (num[mid] == key || num[mid] < key && (mid == num.length - 1 || num[mid + 1] > key)) {
            return mid;
         }

         if (num[mid] < key) {
            start = mid + 1;
         } else {
            end = mid - 1;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 2, 8, 9, 10, 10, 12, 19};
      System.out.println(findFloor(num, 25));
   }
}
