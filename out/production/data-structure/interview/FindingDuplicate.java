package interview;

public class FindingDuplicate {
   public void solve(int[] nums) {
      for(int i = 0; i < nums.length; ++i) {
         System.out.println("nums[" + i + "] " + nums[i]);
         System.out.println("Math.abs(nums[[" + i + "]) " + Math.abs(nums[i]));
         System.out.println("nums[Math.abs(nums[[" + i + "])] " + nums[Math.abs(nums[i])]);
         if (nums[Math.abs(nums[i])] > 0) {
            nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
         } else {
            System.out.println(Math.abs(nums[i]) + " is repeated!!");
         }
      }

   }

   public static void main(String[] args) {
      int[] nums = new int[]{-5, 2, 3, 1, 2, 4, 3, 4};
      FindingDuplicate fd = new FindingDuplicate();
      fd.solve(nums);
   }
}
