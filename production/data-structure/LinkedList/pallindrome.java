package LinkedList;

public class pallindrome {
   static boolean isPalindrome(Node head) {
      Node mid = mid(head);
      mid.next = reverse(mid.next);
      mid = mid.next;

      for(Node temp = head; mid != null; mid = mid.next) {
         if (temp.data != mid.data) {
            return false;
         }

         temp = temp.next;
      }

      return true;
   }

   static Node mid(Node head) {
      Node s = head;

      for(Node f = head; f.next != null && f.next.next != null; f = f.next.next) {
         s = s.next;
      }

      return s;
   }

   static Node reverse(Node head) {
      if (head != null && head.next != null) {
         Node prev = head;

         Node ahead;
         for(Node curr = head.next; curr != null; curr = ahead) {
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
         }

         head.next = null;
         return prev;
      } else {
         return head;
      }
   }
}
