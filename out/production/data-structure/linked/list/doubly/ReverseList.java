package linked.list.doubly;

public class ReverseList {
   public static Node reverse(Node head) {
      Node curr = head;
      Node next = null;

      Node prev;
      for(prev = null; curr != null; curr = next) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr.prev = next;
      }

      return prev;
   }

   public static Node reverseByAdding(Node head) {
      Node node = null;
      if (head != null) {
         node = new Node(head.val, (Node)null, (Node)null);

         for(Node curr = head.next; curr != null; curr = curr.next) {
            addFrontForReverse(node, curr.val);
         }
      }

      return node;
   }

   public static void addFrontForReverse(Node prev, int val) {
      Node node = new Node(val, (Node)null, (Node)null);

      Node temp;
      for(temp = prev; temp.prev != null; temp = temp.prev) {
      }

      temp.prev = node;
   }
}
