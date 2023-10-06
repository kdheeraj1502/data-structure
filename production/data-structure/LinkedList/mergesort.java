package LinkedList;

public class mergesort {
   static Node mergeSort(Node head) {
      if (head != null && head.next != null) {
         Node mid = middle(head);
         Node head2 = mid.next;
         mid.next = null;
         Node temp1 = mergeSort(head);
         Node temp2 = mergeSort(head2);
         Node nn = merge(temp1, temp2);
         return nn;
      } else {
         return head;
      }
   }

   static Node merge(Node head1, Node head2) {
      Node temp1 = head1;
      Node temp2 = head2;
      Node newhead = new Node(-1);
      Node temp3 = newhead;

      Node prev;
      Node nn;
      for(prev = newhead; temp1 != null && temp2 != null; temp3 = nn) {
         if (temp1.data < temp2.data) {
            temp3.data = temp1.data;
            temp1 = temp1.next;
         } else {
            temp3.data = temp2.data;
            temp2 = temp2.next;
         }

         prev = temp3;
         nn = new Node(-1);
         temp3.next = nn;
      }

      prev.next = null;
      if (temp1 == null) {
         if (temp2 != null) {
            prev.next = temp2;
         }
      } else if (temp2 == null && temp1 != null) {
         prev.next = temp1;
      }

      return newhead;
   }

   static Node mergenospace(Node head1, Node head2) {
      Node temp1 = head1;
      Node temp2 = head2;
      Node newhead = new Node(-1);

      Node temp3;
      for(temp3 = newhead; temp1 != null && temp2 != null; temp3 = temp3.next) {
         if (temp1.data < temp2.data) {
            temp3.next = temp1;
            temp1 = temp1.next;
         } else {
            temp3.next = temp2;
            temp2 = temp2.next;
         }
      }

      if (temp1 == null) {
         if (temp2 != null) {
            temp3.next = temp2;
         }
      } else if (temp2 == null && temp1 != null) {
         temp3.next = temp1;
      }

      return newhead.next;
   }

   static Node middle(Node head) {
      if (head != null && head.next != null) {
         Node s = head;

         for(Node f = head; f.next != null && f.next.next != null; f = f.next.next) {
            s = s.next;
         }

         return s;
      } else {
         return head;
      }
   }
}
