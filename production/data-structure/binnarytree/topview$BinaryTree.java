package binnarytree;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class topview$BinaryTree {
   private topview.BinaryTree.Node root;
   private int size;
   Map<Integer, topview.BinaryTree.pair> map;
   // $FF: synthetic field
   final topview this$0;

   topview$BinaryTree(topview this$0) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      this.map = new TreeMap();
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (topview.BinaryTree.Node)null, false);
   }

   private topview.BinaryTree.Node input(Scanner scn, topview.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      topview.BinaryTree.Node node = new topview.BinaryTree.Node(this, data, (topview.BinaryTree.Node)null, (topview.BinaryTree.Node)null);
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

   private void display(topview.BinaryTree.Node parent) {
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

   public void verticallevelorder() {
      this.verticallevelorder(this.root, 0, 0);
   }

   private void verticallevelorder(topview.BinaryTree.Node parent, int ht, int depth) {
      if (parent != null) {
         if (this.map.containsKey(ht)) {
            topview.BinaryTree.pair mp = (topview.BinaryTree.pair)this.map.get(ht);
            if (mp.depth > depth) {
               this.map.replace(ht, new topview.BinaryTree.pair(this, depth, parent.data));
            }
         } else {
            this.map.put(ht, new topview.BinaryTree.pair(this, depth, parent.data));
         }

         this.verticallevelorder(parent.left, ht - 1, depth + 1);
         this.verticallevelorder(parent.right, ht + 1, depth + 1);
      }
   }

   public void topview() {
      this.topview(this.root);
   }

   private void topview(topview.BinaryTree.Node parent) {
      this.verticallevelorder();
      Iterator var2 = this.map.entrySet().iterator();

      while(var2.hasNext()) {
         Map.Entry<Integer, topview.BinaryTree.pair> mp = (Map.Entry)var2.next();
         System.out.println(((topview.BinaryTree.pair)mp.getValue()).data);
      }

   }
}
