package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class printksumpath$BinaryTree {
   private printksumpath.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final printksumpath this$0;

   printksumpath$BinaryTree(printksumpath this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (printksumpath.BinaryTree.Node)null);
   }

   private printksumpath.BinaryTree.Node inputfromstring(String s, printksumpath.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         printksumpath.BinaryTree.Node node = new printksumpath.BinaryTree.Node(this, 0, (printksumpath.BinaryTree.Node)null, (printksumpath.BinaryTree.Node)null);

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

   private void display(printksumpath.BinaryTree.Node parent) {
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

   public void path(int k) {
      ArrayList<Integer> ans = new ArrayList();
      this.path(this.root, k, ans);
   }

   private void path(printksumpath.BinaryTree.Node parent, int k, ArrayList<Integer> ans) {
      if (parent != null) {
         ans.add(parent.data);
         this.path(parent.left, k, ans);
         this.path(parent.right, k, ans);
         Integer[] arr = new Integer[ans.size()];
         ans.toArray(arr);
         int sum = 0;
         String s = "";

         for(int i = arr.length - 1; i >= 0; --i) {
            sum += arr[i];
            s = arr[i] + " " + s;
            if (sum == k) {
               System.out.println(s);
            }
         }

         ans.remove(ans.size() - 1);
      }
   }
}
