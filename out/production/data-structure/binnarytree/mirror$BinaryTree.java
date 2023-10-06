package binnarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class mirror$BinaryTree {
   private mirror.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final mirror this$0;

   mirror$BinaryTree(mirror this$0) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (mirror.BinaryTree.Node)null, false);
   }

   private mirror.BinaryTree.Node input(Scanner scn, mirror.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      mirror.BinaryTree.Node node = new mirror.BinaryTree.Node(this, data, (mirror.BinaryTree.Node)null, (mirror.BinaryTree.Node)null);
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

   private void display(mirror.BinaryTree.Node parent) {
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

   public int height(mirror.BinaryTree.Node root) {
      return root != null ? Math.max(this.height(root.left), this.height(root.right)) + 1 : 0;
   }

   public void mirror(mirror$BinaryTree tree) {
      this.root = this.mirror(tree.root);
   }

   private mirror.BinaryTree.Node mirror(mirror.BinaryTree.Node parent) {
      if (parent == null) {
         return null;
      } else {
         mirror.BinaryTree.Node node = new mirror.BinaryTree.Node(this, 0, (mirror.BinaryTree.Node)null, (mirror.BinaryTree.Node)null);
         node.data = parent.data;
         node.left = this.mirror(parent.right);
         node.right = this.mirror(parent.left);
         return node;
      }
   }

   private mirror.BinaryTree.Node mirror_self(mirror.BinaryTree.Node parent) {
      Queue<mirror.BinaryTree.Node> queue = new LinkedList();
      queue.add(parent);

      while(!queue.isEmpty()) {
         mirror.BinaryTree.Node temp = (mirror.BinaryTree.Node)queue.remove();
         if (temp != null) {
            mirror.BinaryTree.Node temp1 = temp.left;
            temp.left = temp.right;
            temp.right = temp1;
            queue.add(temp.left);
            queue.add(temp.right);
         }
      }

      return parent;
   }
}
