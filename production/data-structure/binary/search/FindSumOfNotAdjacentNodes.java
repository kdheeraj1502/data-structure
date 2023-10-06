package binary.search;

import java.util.HashMap;
import java.util.Map;

public class FindSumOfNotAdjacentNodes {
   public static int sumOfGrandChildren(Node node, Map<Node, Integer> map) {
      int sum = 0;
      if (node.left != null) {
         sum += getMaxSumUTIL(node.left.left, map) + getMaxSumUTIL(node.left.right, map);
      }

      if (node.right != null) {
         sum += getMaxSumUTIL(node.right.right, map) + getMaxSumUTIL(node.right.left, map);
      }

      return sum;
   }

   private static int getMaxSumUTIL(Node node, Map<Node, Integer> map) {
      if (node == null) {
         return 0;
      } else if (map.containsKey(node)) {
         return (Integer)map.get(node);
      } else {
         int incl = node.val + sumOfGrandChildren(node, map);
         int excl = getMaxSumUTIL(node.left, map) + getMaxSumUTIL(node.right, map);
         map.put(node, Math.max(incl, excl));
         return (Integer)map.get(node);
      }
   }

   public static int getMaxSum(Node node) {
      if (node == null) {
         return 0;
      } else {
         Map<Node, Integer> map = new HashMap();
         return getMaxSumUTIL(node, map);
      }
   }

   public static void main(String[] args) {
      Node node = new Node(1);
      node.left = new Node(2);
      node.right = new Node(3);
      node.left.left = new Node(1);
      node.right.left = new Node(4);
      node.right.right = new Node(5);
      System.out.println(getMaxSum(node));
   }
}
