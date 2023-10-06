package binnarytree;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class bottomview$BinaryTree {
   private bottomview.BinaryTree.Node root;
   private int size;
   Map<Integer, bottomview.BinaryTree.pair> map;
   // $FF: synthetic field
   final bottomview this$0;

   bottomview$BinaryTree(bottomview this$0) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      this.map = new TreeMap();
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (bottomview.BinaryTree.Node)null, false);
   }

   private bottomview.BinaryTree.Node input(Scanner scn, bottomview.BinaryTree.Node parent, Boolean isleftorright) {
      if (parent == null) {
         System.out.println("Enter data for the parent node");
      } else if (isleftorright) {
         System.out.println("Enter data for the left child of " + parent.data);
      } else {
         System.out.println("Enter data for the right child of " + parent.data);
      }

      int data = scn.nextInt();
      bottomview.BinaryTree.Node node = new bottomview.BinaryTree.Node(this, data, (bottomview.BinaryTree.Node)null, (bottomview.BinaryTree.Node)null);
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

   private void display(bottomview.BinaryTree.Node parent) {
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

   private void verticallevelorder(bottomview.BinaryTree.Node parent, int ht, int depth) {
      if (parent != null) {
         if (this.map.containsKey(ht)) {
            bottomview.BinaryTree.pair mp = (bottomview.BinaryTree.pair)this.map.get(ht);
            if (mp.depth < depth) {
               this.map.replace(ht, new bottomview.BinaryTree.pair(this, depth, parent.data));
            }
         } else {
            this.map.put(ht, new bottomview.BinaryTree.pair(this, depth, parent.data));
         }

         this.verticallevelorder(parent.left, ht - 1, depth + 1);
         this.verticallevelorder(parent.right, ht + 1, depth + 1);
      }
   }

   public void bottomview() {
      this.bottomview(this.root);
   }

   private void bottomview(bottomview.BinaryTree.Node parent) {
      this.verticallevelorder();
      Iterator var2 = this.map.entrySet().iterator();

      while(var2.hasNext()) {
         Map.Entry<Integer, bottomview.BinaryTree.pair> mp = (Map.Entry)var2.next();
         System.out.println(((bottomview.BinaryTree.pair)mp.getValue()).data);
      }

   }
}
