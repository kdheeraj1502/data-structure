package LinkedList;

public class sort012 {
   static Node segregate(Node head) {
      Node k = head;
      int c0 = 0;
      int c1 = 0;

      int c2;
      for(c2 = 0; k != null; k = k.next) {
         if (k.data == 0) {
            ++c0;
         } else if (k.data == 1) {
            ++c1;
         } else {
            ++c2;
         }
      }

      k = head;

      while(k != null) {
         while(c0 > 0) {
            k.data = 0;
            k = k.next;
            --c0;
         }

         while(c1 > 0) {
            k.data = 1;
            k = k.next;
            --c1;
         }

         while(c2 > 0) {
            k.data = 2;
            k = k.next;
            --c2;
         }
      }

      return head;
   }

   static Node segregatewithlinkchange(Node head) {
      Node temp0 = new Node(-1);
      Node temp1 = new Node(-1);
      Node temp2 = new Node(-1);
      Node temp = head;
      Node t0 = temp0;
      Node t1 = temp1;

      Node t2;
      for(t2 = temp2; temp != null; temp = temp.next) {
         if (temp.data == 0) {
            t0.next = temp;
            t0 = t0.next;
         } else if (temp.data == 1) {
            t1.next = temp;
            t1 = t1.next;
         } else {
            t2.next = temp;
            t2 = t2.next;
         }
      }

      if (temp1.next != null) {
         t0.next = temp1.next;
      } else {
         t0.next = temp2.next;
      }

      t1.next = temp2.next;
      t2.next = null;
      return temp0.next;
   }
}
