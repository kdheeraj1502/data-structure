package binary.search;

public class SortedArrayToBST {
   public TreeNode sortedArrayToBST(int[] nums) {
      return this.createBST(nums, 0, nums.length - 1);
   }

   private TreeNode createBST(int[] nums, int start, int end) {
      if (start <= end && nums.length != 0) {
         int mid = (start + end) / 2;
         TreeNode node = new TreeNode(nums[mid]);
         node.left = this.createBST(nums, start, mid - 1);
         node.right = this.createBST(nums, mid + 1, end);
         return node;
      } else {
         return null;
      }
   }
}
