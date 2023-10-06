package binary.search;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DuplicateSubTree {
   static int dupSub(Node root) {
      Map<String, Integer> map = new HashMap();
      dupSub(root, map);
      Iterator var2 = map.entrySet().iterator();

      Map.Entry m;
      do {
         if (!var2.hasNext()) {
            return 0;
         }

         m = (Map.Entry)var2.next();
      } while((Integer)m.getValue() <= 1);

      return 1;
   }

   static String dupSub(Node root, Map<String, Integer> map) {
      if (root == null) {
         return "$";
      } else {
         String res = "";
         if (root.left == null && root.right == null) {
            return String.valueOf(root.val);
         } else {
            res = res + String.valueOf(root.val);
            res = res + dupSub(root.left, map);
            res = res + dupSub(root.right, map);
            map.put(res, (Integer)map.getOrDefault(res, 0) + 1);
            return res;
         }
      }
   }

   public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(4);
      root.right = new Node(4);
      root.left.left = new Node(6);
      root.left.right = new Node(9);
      root.right.left = new Node(5);
      root.left.left.left = new Node(10);
      root.left.left.right = new Node(5);
      System.out.println(dupSub(root));
   }
}
