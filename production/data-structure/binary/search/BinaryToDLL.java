package binary.search;

import java.util.Stack;

public class BinaryToDLL {
   Node headOfDLL = null;
   Node prev = null;

   Node bToDLL(Node root) {
      if (root == null) {
         return null;
      } else {
         this.bToDLL(root.left);
         if (this.prev == null) {
            this.headOfDLL = root;
            this.prev = root;
         } else {
            root.left = this.prev;
            this.prev.right = root;
            this.prev = root;
         }

         this.bToDLL(root.right);
         return this.headOfDLL;
      }
   }

   Node bToDLL_Iteration(Node root) {
      Stack<Node> stack = new Stack();
      Node temp = root;

      while(!stack.isEmpty() || temp != null) {
         if (temp != null) {
            stack.push(temp);
            temp = temp.left;
         } else {
            Node curr = (Node)stack.pop();
            if (this.prev == null) {
               this.headOfDLL = curr;
               this.prev = curr;
            } else {
               curr.left = this.prev;
               this.prev.right = curr;
               this.prev = curr;
            }

            temp = curr.right;
         }
      }

      return this.headOfDLL;
   }

   public static void main(String[] args) {
      Node root = new Node(11);
      root.left = new Node(27);
      root.right = new Node(30);
      root.left.left = new Node(19);
      root.left.right = new Node(15);
      root.right.left = new Node(14);
      root.right.right = new Node(23);
      BinaryToDLL btd = new BinaryToDLL();
      Node dll2 = btd.bToDLL_Iteration(root);
      System.out.println();
      System.out.println("-------------------------");

      while(dll2 != null) {
         System.out.print(dll2.val + ", ");
         dll2 = dll2.right;
      }

   }
}
