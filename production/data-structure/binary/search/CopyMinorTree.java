package binary.search;

public class CopyMinorTree {
   public static Node copyMinorTree(Node root) {
      if (root != null) {
         Node temp = new Node(root.val);
         temp.left = copyMinorTree(root.right);
         temp.right = copyMinorTree(root.left);
         return temp;
      } else {
         return null;
      }
   }
}
