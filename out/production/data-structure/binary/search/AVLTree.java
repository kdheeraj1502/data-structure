package binary.search;

public class AVLTree {
   private Node head;
   AVLTreeGeek avl1 = new AVLTreeGeek();

   public int height(Node root) {
      return root != null ? Math.max(this.height(root.left), this.height(root.right)) + 1 : 0;
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

   public Node leftRotate(Node root) {
      Node newRoot = root.right;
      Node left = newRoot.left;
      newRoot.left = root;
      root.right = left;
      return newRoot;
   }

   public Node rightRotate(Node root) {
      Node newRoot = root.left;
      Node right = newRoot.right;
      root.left = right;
      newRoot.right = root;
      return newRoot;
   }

   public void displayInOrder(Node root) {
      if (root != null) {
         this.displayInOrder(root.left);
         System.out.print(root.val + ", ");
         this.displayInOrder(root.right);
      }

   }

   public int maxHeight(Node root) {
      return root != null ? Math.max(this.maxHeight(root.left), this.maxHeight(root.right)) + 1 : 0;
   }

   public void inLineDisplay(Node root) {
      int height = this.maxHeight(root);
      this.inLineDisplay(root, height);
   }

   public Node inLineDisplay(Node root, int h) {
      if (root != null) {
         for(int i = h; i > 0; ++i) {
            root = this.inLineDisplay(root.left, h - 1);
            root = this.inLineDisplay(root.right, h - 1);
         }
      }

      System.out.println(root.val);
      return null;
   }

   public static void main(String[] args) {
      AVLTree_1 bst = new AVLTree_1();
      AVLTreeGeek avl = new AVLTreeGeek();
      bst.head = AVLTree_1.insert(bst.head, 10);
      bst.head = AVLTree_1.insert(bst.head, 20);
      bst.head = AVLTree_1.insert(bst.head, 30);
      bst.head = AVLTree_1.insert(bst.head, 40);
      bst.head = AVLTree_1.insert(bst.head, 19);
      bst.head = AVLTree_1.insert(bst.head, 15);
      bst.head = AVLTree_1.insert(bst.head, 25);
      bst.head = AVLTree_1.insert(bst.head, 13);
      bst.head = AVLTree_1.insert(bst.head, 23);
      bst.head = AVLTree_1.insert(bst.head, 33);
      bst.head = AVLTree_1.insert(bst.head, 35);
      bst.head = AVLTree_1.insert(bst.head, 45);
      bst.head = AVLTree_1.insert(bst.head, 5);
      bst.head = AVLTree_1.insert(bst.head, 55);
      bst.head = AVLTree_1.insert(bst.head, 12);
      bst.head = AVLTree_1.insert(bst.head, 11);
      bst.head = AVLTree_1.insert(bst.head, 67);
      bst.head = AVLTree_1.insert(bst.head, 43);
      bst.head = AVLTree_1.insert(bst.head, 17);
      avl.root = avl.insert(avl.root, 10);
      avl.root = avl.insert(avl.root, 20);
      avl.root = avl.insert(avl.root, 30);
      avl.root = avl.insert(avl.root, 40);
      avl.root = avl.insert(avl.root, 19);
      avl.root = avl.insert(avl.root, 15);
      avl.root = avl.insert(avl.root, 25);
      avl.root = avl.insert(avl.root, 13);
      avl.root = avl.insert(avl.root, 23);
      avl.root = avl.insert(avl.root, 33);
      avl.root = avl.insert(avl.root, 35);
      avl.root = avl.insert(avl.root, 45);
      avl.root = avl.insert(avl.root, 5);
      avl.root = avl.insert(avl.root, 55);
      avl.root = avl.insert(avl.root, 12);
      avl.root = avl.insert(avl.root, 11);
      avl.root = avl.insert(avl.root, 67);
      avl.root = avl.insert(avl.root, 43);
      avl.root = avl.insert(avl.root, 17);
      LevelOrderTraversal.levelOrderTopToDown(bst.head);
      System.out.println("geek");
      LevelOrderTraversal.levelOrderTopToDown(avl.root);
      System.out.println();
   }
}
