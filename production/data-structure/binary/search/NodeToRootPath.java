package binary.search;

import java.util.ArrayList;
import java.util.List;

public class NodeToRootPath {
   public static List<Integer> nodeToRoot(Node node, int val) {
      List<Integer> path = new ArrayList();
      getPath(node, val, path);
      return path;
   }

   public static boolean getPath(Node node, int val, List<Integer> path) {
      if (node == null) {
         return false;
      } else if (node.val == val) {
         path.add(node.val);
         return true;
      } else {
         boolean lp = getPath(node.left, val, path);
         if (lp) {
            path.add(node.val);
            return true;
         } else {
            boolean rp = getPath(node.right, val, path);
            if (rp) {
               path.add(node.val);
               return true;
            } else {
               return false;
            }
         }
      }
   }

   private static int LCA(Node node, int val1, int val2) {
      List<Integer> path1 = new ArrayList();
      List<Integer> path2 = new ArrayList();
      getPath(node, val1, path1);
      getPath(node, val2, path2);
      int i = path1.size() - 1;

      int j;
      for(j = path2.size() - 1; i >= 0 && j >= 0 && path1.get(i) == path2.get(j); --j) {
         --i;
      }

      ++i;
      ++j;
      return i + j + 1;
   }

   public static void main(String[] args) {
      Node node = new Node(50);
      node.left = new Node(25);
      node.right = new Node(75);
      node.left.left = new Node(13);
      node.left.right = new Node(37);
      node.right.left = new Node(62);
      node.right.right = new Node(87);
      System.out.println(LCA(node, 62, 87));
   }
}
