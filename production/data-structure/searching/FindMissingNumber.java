package searching;

public class FindMissingNumber {
   public int firstMissingPositive(int[] nums) {
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

      return 0;
   }

   public int firstMissingPositive_self(int[] nums) {
      int[] aux = new int[nums.length + 1];

      int i;
      for(i = 0; i < nums.length; ++i) {
         if (nums[i] > 0 && nums[i] < aux.length) {
            aux[nums[i]] = nums[i];
         }
      }

      for(i = 0; i < aux.length; ++i) {
         if (aux[i] == 0) {
            return i + 1;
         }
      }

      return 0;
   }
}
