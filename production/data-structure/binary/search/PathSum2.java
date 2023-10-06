package binary.search;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
   public List<List<Integer>> pathSum(TreeNode root, int target) {
      List<List<Integer>> result = new ArrayList();
      this.helper(result, root, target, 0, new ArrayList());
      return result;
   }

   private void helper(List<List<Integer>> result, TreeNode root, int target, int sum, List<Integer> sumList) {
      if (root != null) {
         sumList.add(root.val);
         sum += root.val;
         if (root.left == null && root.right == null && target == sum) {
            result.add(new ArrayList(sumList));
         } else {
            this.helper(result, root.left, target, sum, sumList);
            if (root.left != null) {
               sumList.remove(sumList.size() - 1);
            }

            this.helper(result, root.right, target, sum, sumList);
            if (root.right != null) {
               sumList.remove(sumList.size() - 1);
            }

         }
      }
   }

   public static void main(String[] args) {
      TreeNode node = new TreeNode(5);
      node.left = new TreeNode(4);
      node.right = new TreeNode(8);
      node.left.left = new TreeNode(11);
      node.right.left = new TreeNode(13);
      node.right.right = new TreeNode(4);
      node.right.right.left = new TreeNode(5);
      node.left.left.left = new TreeNode(7);
      node.left.left.right = new TreeNode(2);
      node.right.right.right = new TreeNode(1);
      PathSum2 pm = new PathSum2();
      System.out.println(pm.pathSum(node, 22));
   }
}
