package array;

public class FirstMissingPositiveNumber {
   public static int firstMissingPositive(int[] nums) {
      int[] aux = new int[nums.length + 1];

      int i;
      for(i = 0; i < nums.length; ++i) {
         if (nums[i] > 0 && nums[i] < aux.length) {
            ++aux[nums[i] - 1];
         }
      }

      for(i = 0; i < aux.length; ++i) {
         if (aux[i] == 0) {
            return i + 1;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      int[] var10000 = new int[]{3, 1, 0};
      var10000 = new int[]{3, 4, -1, 1};
      int[] nums2 = new int[]{7, 8, 9, 11, 12};
      System.out.println("Smallest missing positive number is " + firstMissingPositive(nums2));
   }
}
