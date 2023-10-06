package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class iterativeprepostinorder$BinaryTree {
   private iterativeprepostinorder.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final iterativeprepostinorder this$0;

   iterativeprepostinorder$BinaryTree(iterativeprepostinorder this$0) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (iterativeprepostinorder.BinaryTree.Node)null, false);
   }

   private iterativeprepostinorder.BinaryTree.Node input(Scanner scn, iterativeprepostinorder.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      iterativeprepostinorder.BinaryTree.Node node = new iterativeprepostinorder.BinaryTree.Node(this, data, (iterativeprepostinorder.BinaryTree.Node)null, (iterativeprepostinorder.BinaryTree.Node)null);
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

   private void display(iterativeprepostinorder.BinaryTree.Node parent) {
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

   public void inorder() {
      this.inorder(this.root);
   }

   private void inorder(iterativeprepostinorder.BinaryTree.Node parent) {
      if (parent != null) {
         this.inorder(parent.left);
         System.out.print(parent.data + " ");
         this.inorder(parent.right);
      }
   }

   public void iterative() {
      this.iterative(this.root);
   }

   private void iterative(iterativeprepostinorder.BinaryTree.Node parent) {
      Stack<iterativeprepostinorder.BinaryTree.pair> stack = new Stack();
      String pre = "";
      String post = "";
      String in = "";
      iterativeprepostinorder.BinaryTree.pair mp = new iterativeprepostinorder.BinaryTree.pair(this, parent, 1);
      stack.push(mp);

      while(!stack.isEmpty()) {
         iterativeprepostinorder.BinaryTree.pair top = (iterativeprepostinorder.BinaryTree.pair)stack.peek();
         iterativeprepostinorder.BinaryTree.pair rightp;
         if (top.state == 1) {
            pre = pre + top.node.data + " ";
            ++top.state;
            if (top.node.left != null) {
               rightp = new iterativeprepostinorder.BinaryTree.pair(this, top.node.left, 1);
               stack.push(rightp);
            }
         } else if (top.state == 2) {
            in = in + top.node.data + " ";
            ++top.state;
            if (top.node.right != null) {
               rightp = new iterativeprepostinorder.BinaryTree.pair(this, top.node.right, 1);
               stack.push(rightp);
            }
         } else {
            post = post + top.node.data + " ";
            stack.pop();
         }
      }

      System.out.println(pre);
      System.out.println(in);
      System.out.println(post);
   }
}
