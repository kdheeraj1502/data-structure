package binary.search;

public class AVLTreeGeek {
   public Node root;

   public Node rightRotate(Node root) {
      Node newRoot = root.left;
      Node right = newRoot.right;
      newRoot.right = root;
      root.left = right;
      return newRoot;
   }

   public Node leftRotate(Node root) {
      Node newRoot = root.right;
      Node left = newRoot.left;
      newRoot.left = root;
      root.right = left;
      return newRoot;
   }

   public int balanceFactor(Node root) {
      int left = this.height(root.left);
      int right = this.height(root.right);
      return left - right;
   }

   public Node insert(Node node, int val) {
      if (node == null) {
         return new Node(val);
      } else {
         if (val < node.val) {
            node.left = this.insert(node.left, val);
         } else {
            if (val <= node.val) {
               return node;
            }

            node.right = this.insert(node.right, val);
         }

         int bf = this.balanceFactor(node);
         if (bf < -1 && val > node.right.val) {
            return this.leftRotate(node);
         } else if (bf < -1 && val < node.right.val) {
            node.right = this.rightRotate(node.right);
            return this.leftRotate(node);
         } else if (bf > 1 && val > node.left.val) {
            node.left = this.leftRotate(node.left);
            return this.rightRotate(node);
         } else {
            return bf > 1 && val < node.left.val ? this.rightRotate(node) : node;
         }
      }
   }

   public int height(Node root) {
      return root != null ? Math.max(this.height(root.left), this.height(root.right)) + 1 : 0;
   }
}
