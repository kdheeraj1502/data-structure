package array;

public class MajorityOfAValInArray {
   public static int firstIndex(int[] num, int low, int high, int val) {
      int mid = (low + high) / 2;
      if ((mid == 0 || num[num.length - 1] < val) && num[mid] == val) {
         return mid;
      } else {
         return num[mid] < val ? firstIndex(num, low, mid - 1, val) : firstIndex(num, low, mid - 1, val);
      }
   }

   public static boolean isMajority(int[] num) {
      int majority = num[num.length / 2];
      firstIndex(num, 0, num.length, majority);
      return true;
   }
}
