package LinkedList;

public class add1tolinkedlist {
   public static Node addOne(Node head) {
      head = reverse(head);

      for(Node temp = head; temp != null; temp = temp.next) {
         if (temp.data != 9) {
            ++temp.data;
            break;
         }

         if (temp.data == 9 && temp.next == null) {
            Node nn = new Node(1);
            temp.data = 0;
            temp.next = nn;
            break;
         }

         temp.data = 0;
      }

      head = reverse(head);
      return head;
   }

   public static Node reverse(Node head) {
      Node prev = head;

      Node ahead;
      for(Node curr = head.next; curr != null; curr = ahead) {
         ahead = curr.next;
         curr.next = prev;
         prev = curr;
      }

      head.next = null;
      return prev;
   }
}
