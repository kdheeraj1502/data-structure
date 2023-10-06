package binnarytree;

import java.util.Scanner;

public class diameter {
   private Node root = null;
   private int size = 0;

   private Node input(Scanner scn, Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      Node node = new Node(data, (Node)null, (Node)null);
      ++this.size;
      System.out.println("does " + node.data + " has left child");
      Boolean choice = false;
      choice = scn.nextBoolean();
      if (choice) {
         node.left = this.input(scn, node, true);
      }

      choice = false;
      System.out.println("does " + node.data + " has right child");
      choice = scn.nextBoolean();
      if (choice) {
         node.right = this.input(scn, node, false);
      }

      return node;
   }

   public void display() {
      this.display(this.root);
   }

   private void display(Node parent) {
      String str = "";
      if (parent.left != null) {
         str = str + parent.left.data + " => ";
      } else {
         str = str + "End => ";
      }

      str = str + parent.data;
      if (parent.right != null) {
         str = str + " <= " + parent.right.data;
      } else {
         str = str + " <= End";
      }

      System.out.println(str);
      if (parent.left != null) {
         this.display(parent.left);
      }

      if (parent.right != null) {
         this.display(parent.right);
      }

   }

   public int height(Node root) {
      return root != null ? Math.max(this.height(root.left), this.height(root.right)) + 1 : 0;
   }

   public int diameter1() {
      return this.diameter1(this.root);
   }

   private int diameter1(Node parent) {
      if (parent == null) {
         return 0;
      } else {
         int left = this.diameter1(parent.left);
         int right = this.diameter1(parent.right);
         int leftHeight = this.height(parent.left);
         int rightHeight = this.height(parent.right);
         System.out.println("Node is " + parent.data + " left Height " + leftHeight + " right height " + rightHeight);
         int height = this.height(parent.left) + this.height(parent.right) + 1;
         return Math.max(height, Math.max(left, right));
      }
   }

   public int diameter2() {
      return this.diameter2(this.root).dia;
   }

   private diapair diameter2(Node parent) {
      diapair ld;
      if (parent == null) {
         ld = new diapair(this);
         ld.height = -1;
         ld.dia = 0;
         return ld;
      } else {
         ld = this.diameter2(parent.left);
         diapair rd = this.diameter2(parent.right);
         diapair mp = new diapair(this);
         int f = ld.height + rd.height + 2;
         mp.dia = Math.max(f, Math.max(ld.dia, rd.dia));
         mp.height = Math.max(ld.height, rd.height) + 1;
         return mp;
      }
   }

   public static void main(String[] args) {
      diameter m = new diameter();
      Node root = new Node(10);
      root.left = new Node(20);
      root.right = new Node(30);
      root.right.right = new Node(50);
      root.left.left = new Node(40);
      root.left.right = new Node(60);
      m.root = root;
      System.out.println(m.diameter1());
   }
}
