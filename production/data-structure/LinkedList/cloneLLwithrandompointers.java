package LinkedList;

public class cloneLLwithrandompointers {
   static Node copyList(Node head) {
      Node temp;
      Node nlist;
      for(temp = head; temp != null; temp = nlist.next) {
         nlist = new Node(temp.data);
         nlist.next = temp.next;
         temp.next = nlist;
      }

      Node temp1;
      for(temp = head; temp != null; temp = nlist.next) {
         nlist = temp.next;
         temp1 = temp.arb;
         if (temp1 != null) {
            nlist.arb = temp.arb.next;
         }
      }

      nlist = new Node(-1);
      temp1 = nlist;

      for(temp = head; temp != null && temp.next != null; temp = temp.next) {
         temp1.next = temp.next;
         temp1 = temp1.next;
         temp.next = temp.next.next;
      }

      return nlist.next;
   }
}
