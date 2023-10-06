package binary.search;

public class CopyTree {
   public static Node copyTree(Node root) {
      if (root != null) {
         Node temp = new Node(root.val);
         temp.left = copyTree(root.left);
         temp.right = copyTree(root.right);
         return temp;
      } else {
         return null;
      }
   }

   public static Node copyTree_self(Node root) {
      if (root != null) {
         Node temp = new Node(root.val);
         temp.left = copyTree_self(root.left);
         temp.right = copyTree_self(root.right);
         return temp;
      } else {
         return null;
      }
   }
}
