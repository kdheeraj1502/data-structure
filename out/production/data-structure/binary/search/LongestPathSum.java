package binary.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LongestPathSum {
   public static int sumOfLongRootToLeafPath(TreeNode root) {
      Queue<SumLevel> queue = new LinkedList();
      queue.add(new SumLevel(root, root.val, 1));
      int level = 0;
      int max = Integer.MIN_VALUE;
      Map<Integer, List<Integer>> result = new HashMap();

      int large;
      while(!queue.isEmpty()) {
         large = queue.size();
         ++level;

         while(large-- > 0) {
            SumLevel temp = (SumLevel)queue.remove();
            result.put(level, result.getOrDefault(level, new ArrayList()));
            ((List)result.get(level)).add(temp.sum);
            int sum;
            if (temp.node.left != null) {
               sum = temp.sum + temp.node.left.val;
               queue.add(new SumLevel(temp.node.left, sum, level));
            }

            if (temp.node.right != null) {
               sum = temp.sum + temp.node.right.val;
               queue.add(new SumLevel(temp.node.right, sum, level));
            }
         }
      }

      large = Integer.MIN_VALUE;
      Iterator var9 = result.entrySet().iterator();

      while(var9.hasNext()) {
         Map.Entry<Integer, List<Integer>> map = (Map.Entry)var9.next();
         if ((Integer)map.getKey() > large) {
            large = (Integer)map.getKey();
         }
      }

      List<Integer> largest = (List)result.get(large);
      Iterator var12 = largest.iterator();

      while(var12.hasNext()) {
         int in = (Integer)var12.next();
         if (max < in) {
            max = in;
         }
      }

      return max;
   }

   public static void main(String[] args) {
      TreeNode node = new TreeNode(1);
      node.right = new TreeNode(7);
      node.right.left = new TreeNode(6);
      node.right.right = new TreeNode(10);
      node.right.left.left = new TreeNode(2);
      node.right.right.left = new TreeNode(9);
      node.right.left.left.right = new TreeNode(3);
      node.right.right.left.left = new TreeNode(8);
      node.right.left.left.right.right = new TreeNode(5);
      node.right.left.left.right.right.left = new TreeNode(4);
      System.out.println(sumOfLongRootToLeafPath(node));
   }
}
