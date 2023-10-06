package LinkedList;

public class flattenedLL {
   Node flatten(Node root) {
      if (root.next == null) {
         return root;
      } else {
         Node temp = this.flatten(root.next);
         Node tempfinal = this.merge(root, temp);
         return tempfinal;
      }
   }

   Node merge(Node head1, Node head2) {
      Node temp1 = head1;
      Node temp2 = head2;
      Node temp3 = new Node(this, 0);

      Node temp;
      for(temp = temp3; temp1 != null && temp2 != null; temp = temp.bottom) {
         if (temp1.data < temp2.data) {
            temp.bottom = temp1;
            temp1 = temp1.bottom;
         } else {
            temp.bottom = temp2;
            temp2 = temp2.bottom;
         }
      }

      if (temp1 == null) {
         if (temp2 != null) {
            temp.bottom = temp2;
         }
      } else if (temp2 == null && temp1 != null) {
         temp.bottom = temp1;
      }

      return temp3.bottom;
   }
}
