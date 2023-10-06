package misclaneous;

public class joshlinkedlisttobst {
   public static Node pointer = null;

   public static void main(String[] args) {
      Node head = new Node(1);
      head.prev = null;
      Node two = new Node(2);
      head.next = two;
      two.prev = head;
      Node three = new Node(3);
      two.next = three;
      three.prev = two;
      Node four = new Node(4);
      three.next = four;
      four.prev = three;
      Node five = new Node(5);
      four.next = five;
      five.prev = four;
      Node six = new Node(6);
      five.next = six;
      six.prev = five;
      six.next = null;
      Node anshead = solvebrute(head);
      print(anshead);
   }

   public static void print(Node root) {
      if (root != null) {
         if (root.prev != null) {
            System.out.print(root.prev.data + " ");
         }

         System.out.print(" => " + root.data + " <= ");
         if (root.next != null) {
            System.out.print(root.next.data + " ");
         }

         System.out.println();
         print(root.prev);
         print(root.next);
      }
   }

   public static int size(Node root) {
      int c = 0;

      for(Node temp = root; temp != null; ++c) {
         temp = temp.next;
      }

      return c;
   }

   public static Node solve(Node root) {
      pointer = root;
      int size = size(root);
      return solverec(size);
   }

   private static Node solverec(int n) {
      if (n <= 0) {
         return null;
      } else {
         Node left = solverec(n / 2);
         Node myroot = pointer;
         pointer = pointer.next;
         myroot.prev = left;
         myroot.next = solverec(n - n / 2 - 1);
         return myroot;
      }
   }

   public static Node solvebrute(Node root) {
      if (root == null) {
         return null;
      } else {
         Node mid = mid(root);
         if (mid == root) {
            return mid;
         } else {
            mid.prev = solvebrute(root);
            mid.next = solvebrute(mid.next);
            return mid;
         }
      }
   }

   private static Node mid(Node root) {
      if (root == null) {
         return root;
      } else {
         Node slow = root;
         Node fast = root;

         Node prev;
         for(prev = root; fast != null && fast.next != null; fast = fast.next.next) {
            prev = slow;
            slow = slow.next;
         }

         if (prev == slow) {
            root = null;
         } else {
            prev.next = null;
         }

         slow.prev = null;
         return slow;
      }
   }
}
