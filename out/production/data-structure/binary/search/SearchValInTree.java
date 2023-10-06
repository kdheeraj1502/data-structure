package binary.search;

public class SearchValInTree {
   public static boolean search(Node root, int val) {
      boolean status;
      if (root == null) {
         status = false;
         return status;
      } else if (root.val == val) {
         status = true;
         return status;
      } else {
         status = search(root.left, val);
         if (status) {
            return status;
         } else {
            status = search(root.right, val);
            return status ? status : false;
         }
      }
   }
}
