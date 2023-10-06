package binnarytree;

import java.util.Scanner;
import java.util.Stack;

public class treefromstring {
   public Node root = null;
   private int size = 0;

   treefromstring() {
      Scanner scn = new Scanner(System.in);
      this.root = this.input(scn, (Node)null, false);
   }

   public treefromstring(String s) {
      new Scanner(System.in);
      this.root = this.inputfromstring(s, (Node)null);
   }

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

   private Node inputfromstring(String s, Node parent) {
      if (s.length() == 0) {
         return null;
      } else {
         Node node = new Node(0, (Node)null, (Node)null);

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

   public static void main(String[] args) {
      treefromstring m = new treefromstring();
      m.display();
      System.out.println();
   }
}
