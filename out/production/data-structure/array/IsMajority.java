package array;

public class IsMajority {
   public static int findIndex(int[] num, int low, int high, int val) {
      int mid = 0;
      if (high >= low) {
         mid = (low + high) / 2;
      }

      if ((mid == 0 || num[mid - 1] < val) && num[mid] == val) {
         return mid;
      } else {
         return num[mid] < val ? findIndex(num, mid + 1, high, val) : findIndex(num, low, mid - 1, val);
      }
   }

   public static boolean isMajority(int[] num) {
      int majority = num[num.length / 2];
      int index = findIndex(num, 0, num.length - 1, majority);
      return index + num.length / 2 <= num.length - 1 && num[index + num.length / 2] == majority;
   }

   public static void main(String[] args) {
      int[] num = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5};
      System.out.println(isMajority(num));
   }
}
