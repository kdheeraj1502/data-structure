package LinkedList;

public class reversedoublyLL {
   public static Node reverseDLL(Node head) {
      if (head != null && head.next != null) {
         Node temp = null;

         for(Node current = head; current != null; current = current.prev) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
         }

         return temp.prev;
      } else {
         return head;
      }
   }
}
