package binnarytree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class minswaptomakeBST$BinaryTree {
   private minswaptomakeBST.BinaryTree.Node root;
   private int size;
   // $FF: synthetic field
   final minswaptomakeBST this$0;

   minswaptomakeBST$BinaryTree(minswaptomakeBST this$0, String s) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      new Scanner(System.in);
      this.root = this.inputfromstring(s);
   }

   minswaptomakeBST$BinaryTree(minswaptomakeBST this$0, int[] arr) {
      this.this$0 = this$0;
      this.root = null;
      this.size = 0;
      this.root = this.inputfromarr(arr, 0);
   }

   private minswaptomakeBST.BinaryTree.Node inputfromstring(String s) {
      if (s.length() == 0) {
         return null;
      } else {
         minswaptomakeBST.BinaryTree.Node node = new minswaptomakeBST.BinaryTree.Node(this, 0, (minswaptomakeBST.BinaryTree.Node)null, (minswaptomakeBST.BinaryTree.Node)null);
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
            node.left = this.inputfromstring(leftsub);
            if (i + 1 < s.length() - 1) {
               String rightsub = s.substring(i + 1, s.length() - 1);
               node.right = this.inputfromstring(rightsub);
            }
         }

         return node;
      }
   }

   private minswaptomakeBST.BinaryTree.Node inputfromarr(int[] arr, int i) {
      if (i >= arr.length) {
         return null;
      } else {
         minswaptomakeBST.BinaryTree.Node node = new minswaptomakeBST.BinaryTree.Node(this, arr[i], (minswaptomakeBST.BinaryTree.Node)null, (minswaptomakeBST.BinaryTree.Node)null);
         node.left = this.inputfromarr(arr, 2 * i + 1);
         node.right = this.inputfromarr(arr, 2 * i + 2);
         return node;
      }
   }

   public void display() {
      this.display(this.root);
   }

   private void display(minswaptomakeBST.BinaryTree.Node parent) {
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

   public void inorder(minswaptomakeBST.BinaryTree.Node parent, ArrayList<Integer> ans) {
      if (parent != null) {
         this.inorder(parent.left, ans);
         ans.add(parent.data);
         this.inorder(parent.right, ans);
      }
   }

   // $FF: synthetic method
   static minswaptomakeBST.BinaryTree.Node access$000(minswaptomakeBST$BinaryTree x0) {
      return x0.root;
   }
}
