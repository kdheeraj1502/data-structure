package red.black.tree;

public class RedAndBlackTree implements Tree {
   private Node root;

   public void traverse() {
      if (this.root != null) {
         this.inOrderTraversal(this.root);
      }

   }

   public Node getRoot() {
      return this.root != null ? this.root : null;
   }

   private void inOrderTraversal(Node node) {
      if (node.getLeft() != null) {
         this.inOrderTraversal(node.getLeft());
      }

      System.out.print(node + ", ");
      if (node.getRight() != null) {
         this.inOrderTraversal(node.getRight());
      }

   }

   private Node rightRotate(Node root) {
      Node left = root.getLeft();
      root.setLeft(left.getRight());
      if (root.getParent() != null) {
         root.getParent().setRight(left);
      }

      left.setParent(root.getParent());
      left.setRight(root);
      root.setParent(left);
      return left;
   }

   private Node leftRotate(Node root) {
      Node right = root.getRight();
      root.setRight(right.getLeft());
      if (root.getParent() != null) {
         root.getParent().setLeft(right);
      }

      right.setParent(root.getParent());
      right.setLeft(root);
      root.setParent(right);
      return right;
   }

   public void insert(int val) {
      Node node = new Node(val);
      this.root = this.insertIntoTree(this.root, node);
      this.fixViolation(node);
   }

   private Node insertIntoTree(Node root, Node node) {
      if (root == null) {
         return node;
      } else if (node.getVal() == root.getVal()) {
         return node;
      } else {
         Node node2;
         if (node.getVal() < root.getVal()) {
            node2 = this.insertIntoTree(root.getLeft(), node);
            root.setLeft(node2);
            root.getLeft().setParent(root);
         } else if (node.getVal() > root.getVal()) {
            node2 = this.insertIntoTree(root.getRight(), node);
            root.setRight(node2);
            node2.setParent(root);
         }

         return root;
      }
   }

   private void fixViolation(Node node) {
      Node parent = null;
      Node grand = null;

      while(node != this.root && node.getColor() != NodeColor.BLACK && node.getParent().getColor() == NodeColor.RED) {
         System.out.println(this.root.getVal());
         parent = node.getParent();
         grand = node.getParent().getParent();
         Node uncle;
         NodeColor tempColor;
         if (parent == grand.getLeft()) {
            uncle = grand.getRight();
            if (uncle != null && uncle.getColor() == NodeColor.RED) {
               uncle.setColor(NodeColor.BLACK);
               parent.setColor(NodeColor.BLACK);
               grand.setColor(NodeColor.RED);
               node = grand;
            } else {
               if (node == parent.getRight()) {
                  grand.setLeft(this.leftRotate(parent));
                  parent = parent.getParent();
               }

               parent.setRight(this.rightRotate(grand));
               tempColor = parent.getColor();
               parent.setColor(grand.getColor());
               grand.setColor(tempColor);
               node = parent;
            }
         } else {
            uncle = grand.getLeft();
            if (uncle != null && uncle.getColor() == NodeColor.RED) {
               uncle.setColor(NodeColor.BLACK);
               parent.setColor(NodeColor.BLACK);
               grand.setColor(NodeColor.RED);
               node = grand;
            } else {
               if (node == parent.getLeft()) {
                  grand.setRight(this.rightRotate(parent));
                  System.out.println(this.root.getVal());
                  parent = parent.getParent();
               }

               parent.setLeft(this.leftRotate(grand));
               tempColor = parent.getColor();
               parent.setColor(grand.getColor());
               grand.setColor(tempColor);
               node = parent;
            }
         }
      }

      if (this.root.getColor() == NodeColor.RED) {
         this.root.setColor(NodeColor.BLACK);
      }

   }
}
