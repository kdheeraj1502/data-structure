package binnarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class printduplicatesubtree$BinaryTree {
   private printduplicatesubtree.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final printduplicatesubtree this$0;

   printduplicatesubtree$BinaryTree(printduplicatesubtree this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (printduplicatesubtree.BinaryTree.Node)null);
   }

   private printduplicatesubtree.BinaryTree.Node inputfromstring(String s, printduplicatesubtree.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         printduplicatesubtree.BinaryTree.Node node = new printduplicatesubtree.BinaryTree.Node(this, 0, (printduplicatesubtree.BinaryTree.Node)null, (printduplicatesubtree.BinaryTree.Node)null);

         int i;
         for(i = 0; i < s.length() && s.charAt(i) != '('; ++i) {
         }

         int start = i + 1;
         String no = s.substring(0, i);
         node.data = Integer.parseInt(no);
         if (i < s.length()) {
            Stack<Character> stack = new Stack();
            stack.push(s.charAt(i));
            ++i;

            for(; !stack.isEmpty() && i < s.length(); ++i) {
               if (s.charAt(i) == '(') {
                  stack.push(s.charAt(i));
               } else if (s.charAt(i) == ')') {
                  stack.pop();
               }
            }

            String leftsub = s.substring(start, i - 1);
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

   private void display(printduplicatesubtree.BinaryTree.Node parent) {
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

   private String printduplicates(printduplicatesubtree.BinaryTree.Node parent, Map<String, Integer> map) {
      String s;
      if (parent == null) {
         s = "";
         return s;
      } else {
         s = "(";
         s = s + this.printduplicates(parent.left, map);
         s = s + parent.data;
         s = s + this.printduplicates(parent.right, map);
         s = s + ")";
         if (map.containsKey(s) && (Integer)map.get(s) == 1) {
            int i = false;
            System.out.print(parent.data + " ");
         }

         if (map.containsKey(s)) {
            map.replace(s, (Integer)map.get(s) + 1);
         } else {
            map.put(s, 1);
         }

         return s;
      }
   }

   public void printall() {
      this.printall(this.root);
   }

   private void printall(printduplicatesubtree.BinaryTree.Node parent) {
      Map<String, Integer> map = new HashMap();
      this.printduplicates(parent, map);
      System.out.println(map);
      int flag = false;
      if (!flag) {
         System.out.println(-1);
      }

   }
}
