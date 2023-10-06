package backtracking;

import binary.search.LevelOrderTraversal;
import binary.search.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UniqueBinarySearchTree2 {
   public static List<Node> generateTrees(int n, int[] nums) {
      return (List)(n == 0 ? new ArrayList() : dfs(0, n - 1, nums));
   }

   public static List<Node> dfs(int start, int end, int[] nums) {
      List<Node> res = new ArrayList();
      if (start > end) {
         res.add((Object)null);
         return res;
      } else {
         for(int i = start; i <= end; ++i) {
            List<Node> l = dfs(start, i - 1, nums);
            List<Node> r = dfs(i + 1, end, nums);
            Iterator var7 = l.iterator();

            while(var7.hasNext()) {
               Node ln = (Node)var7.next();
               Iterator var9 = r.iterator();

               while(var9.hasNext()) {
                  Node rn = (Node)var9.next();
                  Node root = new Node(nums[i]);
                  root.left = ln;
                  root.right = rn;
                  res.add(root);
               }
            }
         }

         return res;
      }
   }

   public static void main(String[] args) {
      int[] nums = new int[]{10, 20, 30};
      List<Node> nodeList = generateTrees(3, nums);

      for(int i = 0; i < nodeList.size(); ++i) {
         Node node = (Node)nodeList.get(i);
         if (node != null) {
            LevelOrderTraversal.levelOrder(node);
         }
      }

   }
}
