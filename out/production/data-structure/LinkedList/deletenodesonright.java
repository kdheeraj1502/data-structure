package LinkedList;

public class deletenodesonright {
   static Node compute(Node head) {
      Node rh = reverse(head);
      Node temp = rh;
      Node nn = new Node(-1);

      Node nnt;
      for(nnt = nn; temp != null; temp = temp.next) {
         if (temp.data >= nnt.data) {
            nnt.next = temp;
            nnt = nnt.next;
         }
      }

      nnt.next = null;
      return reverse(nn.next);
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
