package LinkedList;

public class removeduplicate {
   Node removeDuplicates(Node head) {
      if (head == null) {
         return head;
      } else {
         for(Node temp = head; temp != null; temp = temp.next) {
            for(Node ahead = temp.next; ahead != null && temp.data == ahead.data; ahead = temp.next) {
               temp.next = ahead.next;
            }
         }

         return head;
      }
   }
}
