package linked.list.doubly;

public class RemoveDuplicate {
   public static void removeDuplicate(Node head, DoubleLinkedList list) {
      for(Node curr = head; curr != null; curr = curr.next) {
         if (curr.next != null && curr.val == curr.next.val) {
            Node deleteNode = curr.next;
            if (deleteNode.next != null) {
               curr.next = deleteNode.next;
               curr.next.prev = curr;
            } else {
               curr.next = null;
            }

            if (deleteNode == list.getTail()) {
               list.setTail(curr);
            }
         }
      }

   }
}
