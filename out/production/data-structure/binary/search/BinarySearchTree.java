package binary.search;

public class BinarySearchTree {
   private Node head = null;

   private Node insert(int val, Node root) {
      if (root == null) {
         root = new Node(val);
      } else if (val < root.val) {
         root.left = this.insert(val, root.left);
      } else {
         root.right = this.insert(val, root.right);
      }

      return root;
   }

   public void insert(int val) {
      this.head = this.insert(val, this.head);
   }

   public void displayPreOrder(Node root) {
      if (root != null) {
         System.out.print(root.val + ", ");
         this.displayPreOrder(root.left);
         this.displayPreOrder(root.right);
      }

   }

   public void displayPostOrder(Node root) {
      if (root != null) {
         this.displayPostOrder(root.left);
         this.displayPostOrder(root.right);
         System.out.print(root.val + ", ");
      }

   }

   public void displayInOrder(Node root) {
      if (root != null) {
         this.displayInOrder(root.left);
         System.out.print(root.val + ", ");
         this.displayInOrder(root.right);
      }

   }

   public static void main(String[] args) {
      BinarySearchTree bst = new BinarySearchTree();
      bst.insert(10);
      bst.insert(15);
      bst.insert(18);
      bst.insert(7);
      bst.insert(5);
      bst.insert(9);
      bst.insert(17);
      bst.displayInOrder(bst.head);
   }
}
