package binary.search;

import java.util.LinkedList;
import java.util.Queue;

public class KthAncestorOfTreeNode {
   static int k = 3;
   static Node temp = null;

   static void generateArray(Node root, int[] ancestors) {
      ancestors[root.val] = -1;
      Queue<Node> q = new LinkedList();
      q.add(root);

      while(!q.isEmpty()) {
         Node temp = (Node)q.peek();
         q.remove();
         if (temp.left != null) {
            ancestors[temp.left.val] = temp.val;
            q.add(temp.left);
         }

         if (temp.right != null) {
            ancestors[temp.right.val] = temp.val;
            q.add(temp.right);
         }
      }

   }

   static int kthAncestor(Node root, int n, int k, int node) {
      int[] ancestors = new int[n + 1];
      generateArray(root, ancestors);
      int count = 0;

      while(node != -1) {
         node = ancestors[node];
         ++count;
         if (count == k) {
            break;
         }
      }

      return node;
   }

   public static void main(String[] args) {
      Node root = new Node(1);
      root.left = new Node(4);
      root.left.right = new Node(7);
      root.left.left = new Node(3);
      root.left.right.left = new Node(8);
      root.right = new Node(2);
      root.right.right = new Node(6);
      System.out.println("----------Ancesstor-------------");
      System.out.println(kthAncestor(root, 8, 3, 8));
      int item = 8;
      int loc = k;
      boolean flag = ancestor(root, item);
      if (flag) {
         System.out.println("Ancestor doesn't exist");
      } else {
         System.out.println("is the " + loc + "th ancestor of [" + item + "]");
      }

      k = 3;
      System.out.println("---------DFS--------------");
      kthAncestorDFS(root, 8);
   }

   static Node kthAncestorDFS(Node root, int node) {
      if (root == null) {
         return null;
      } else if (root.val != node && (temp = kthAncestorDFS(root.left, node)) == null && (temp = kthAncestorDFS(root.right, node)) == null) {
         return null;
      } else if (k > 0) {
         --k;
         return root;
      } else if (k == 0) {
         System.out.print("Kth ancestor is: " + root.val);
         return null;
      } else {
         return root;
      }
   }

   static boolean ancestor(Node root, int item) {
      if (root == null) {
         return false;
      } else if (root.val == item) {
         --k;
         return true;
      } else {
         boolean flag = ancestor(root.left, item);
         if (flag) {
            if (k == 0) {
               System.out.print("[" + root.val + "] ");
               return false;
            } else {
               --k;
               return true;
            }
         } else {
            boolean flag2 = ancestor(root.right, item);
            if (flag2) {
               if (k == 0) {
                  System.out.print("[" + root.val + "] ");
                  return false;
               } else {
                  --k;
                  return true;
               }
            } else {
               return false;
            }
         }
      }
   }
}
