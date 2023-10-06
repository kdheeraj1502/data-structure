package misclaneous;

import java.util.Scanner;
import java.util.Stack;

public class joshmirrortreequestion$BinaryTree {
   private joshmirrortreequestion.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final joshmirrortreequestion this$0;

   joshmirrortreequestion$BinaryTree(joshmirrortreequestion this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (joshmirrortreequestion.BinaryTree.Node)null);
   }

   private joshmirrortreequestion.BinaryTree.Node inputfromstring(String s, joshmirrortreequestion.BinaryTree.Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         joshmirrortreequestion.BinaryTree.Node node = new joshmirrortreequestion.BinaryTree.Node(this, 0, (joshmirrortreequestion.BinaryTree.Node)null, (joshmirrortreequestion.BinaryTree.Node)null);

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

   private void display(joshmirrortreequestion.BinaryTree.Node parent) {
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

   public boolean checkmirrorstructure(joshmirrortreequestion.BinaryTree.Node root1, joshmirrortreequestion.BinaryTree.Node root2) {
      if (root1 == null && root2 == null) {
         return true;
      } else if (root1 != null && root2 != null) {
         root2.data = root1.data;
         return this.checkmirrorstructure(root1.left, root2.right) && this.checkmirrorstructure(root1.right, root2.left);
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   static joshmirrortreequestion.BinaryTree.Node access$000(joshmirrortreequestion$BinaryTree x0) {
      return x0.root;
   }
}
