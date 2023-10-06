package binary.search;

public class LargestSubTreeSum {
   static int findLargestSubtreeSum(Node root) {
      INT ans = new INT(Integer.MIN_VALUE);
      findLargestSubtreeSum(root, ans);
      return ans.v;
   }

   static int findLargestSubtreeSum(Node root, INT ans) {
      if (root == null) {
         return 0;
      } else {
         int currSum = findLargestSubtreeSum(root.left, ans) + findLargestSubtreeSum(root.right, ans) + root.val;
         ans.v = Math.max(ans.v, currSum);
         return currSum;
      }
   }

   public static void main(String[] args) {
      Node node = new Node(1);
      node.left = new Node(-2);
      node.right = new Node(3);
      node.left.left = new Node(4);
      node.left.right = new Node(5);
      node.right.left = new Node(-6);
      node.right.right = new Node(2);
      System.out.println(findLargestSubtreeSum(node));
   }
}
