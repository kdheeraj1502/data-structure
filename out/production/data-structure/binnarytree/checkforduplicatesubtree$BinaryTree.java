package binnarytree;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class checkforduplicatesubtree$BinaryTree {
   private checkforduplicatesubtree.BinaryTree.Node root;
   private int size;
   HashMap<String, Integer> map;
   // $FF: synthetic field
   final checkforduplicatesubtree this$0;

   checkforduplicatesubtree$BinaryTree(checkforduplicatesubtree this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      this.map = new HashMap();
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (checkforduplicatesubtree.BinaryTree.Node)null);
   }

   private checkforduplicatesubtree.BinaryTree.Node inputfromstring(String s, checkforduplicatesubtree.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         checkforduplicatesubtree.BinaryTree.Node node = new checkforduplicatesubtree.BinaryTree.Node(this, 0, (checkforduplicatesubtree.BinaryTree.Node)null, (checkforduplicatesubtree.BinaryTree.Node)null);
         node.data = Integer.parseInt(String.valueOf(s.charAt(0)));
         if (s.length() > 1) {
            Stack<Character> stack = new Stack();
            stack.push(s.charAt(1));

            int i;
            for(i = 2; !stack.isEmpty() && i < s.length(); ++i) {
               if (s.charAt(i) == '(') {
                  stack.push(s.charAt(i));
               } else if (s.charAt(i) == ')') {
                  stack.pop();
               }
            }

            String leftsub = s.substring(2, i - 1);
            node.left = this.inputfromstring(leftsub, node);
            if (i + 1 < s.length() - 1) {
               String rightsub = s.substring(i + 1, s.length() - 1);
               node.right = this.inputfromstring(rightsub, node);
            }
         }

         return node;
      }
   }

   public void display() {
      this.display(this.root);
   }

   private void display(checkforduplicatesubtree.BinaryTree.Node parent) {
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

   public boolean checkduplicatesub() {
      return this.checkduplicatesub(this.root).ans;
   }

   private checkforduplicatesubtree.BinaryTree.pair checkduplicatesub(checkforduplicatesubtree.BinaryTree.Node parent) {
      checkforduplicatesubtree.BinaryTree.pair right;
      String s;
      if (parent == null) {
         s = "$";
         right = new checkforduplicatesubtree.BinaryTree.pair(this, s, false);
         return right;
      } else if (parent.right == null && parent.left == null) {
         s = "" + parent.data;
         right = new checkforduplicatesubtree.BinaryTree.pair(this, s, false);
         return right;
      } else {
         checkforduplicatesubtree.BinaryTree.pair left = this.checkduplicatesub(parent.left);
         right = this.checkduplicatesub(parent.right);
         String s = parent.data + left.s + right.s;
         checkforduplicatesubtree.BinaryTree.pair mp = new checkforduplicatesubtree.BinaryTree.pair(this, s, this.map.containsKey(s) || left.ans || right.ans);
         if (!this.map.containsKey(s)) {
            this.map.put(s, 1);
         }

         return mp;
      }
   }
}
