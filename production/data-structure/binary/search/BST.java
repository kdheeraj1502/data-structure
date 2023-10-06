package binary.search;

public class BST {
   private static Node root;

   public static void insert(int val) {
      root = insert(root, val);
   }

   public static Node getRoot() {
      return root != null ? root : null;
   }

   private static Node insert(Node root, int val) {
      if (root == null) {
         root = new Node(val);
      } else if (val < root.val) {
         root.left = insert(root.left, val);
      } else if (val > root.val) {
         root.right = insert(root.right, val);
      }

      return root;
   }

   public static boolean find(Node root, int val) {
      if (root == null) {
         return false;
      } else if (root != null) {
         if (root.val == val) {
            return true;
         } else {
            return val < root.val ? find(root.left, val) : find(root.right, val);
         }
      } else {
         return false;
      }
   }

   public static Node findNode(Node root, int val) {
      Node temp = null;
      if (root != null) {
         if (root.val == val) {
            return root;
         } else if (val < root.val) {
            temp = findNode(root.left, val);
            return temp;
         } else {
            temp = findNode(root.right, val);
            return temp;
         }
      } else {
         return temp;
      }
   }

   public static int findMin(Node root) {
      if (root == null) {
         return Integer.MIN_VALUE;
      } else {
         Node curr;
         for(curr = root; curr.left != null; curr = curr.left) {
         }

         return curr.val;
      }
   }

   public static Node findMinNode(Node root) {
      if (root == null) {
         return null;
      } else {
         Node curr;
         for(curr = root; curr.left != null; curr = curr.left) {
         }

         return curr;
      }
   }

   public static int findMax(Node root) {
      if (root == null) {
         return Integer.MIN_VALUE;
      } else {
         Node curr;
         for(curr = root; curr.right != null; curr = curr.right) {
         }

         return curr.val;
      }
   }

   public static Node findMaxNode(Node root) {
      if (root == null) {
         return null;
      } else {
         Node curr;
         for(curr = root; curr.right != null; curr = curr.right) {
         }

         return curr;
      }
   }
}
