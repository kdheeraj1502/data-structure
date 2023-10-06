package LinkedList;

public class segregateevenodd {
   Node divide(int N, Node head) {
      Node nne = new Node(this, -1);
      Node nno = new Node(this, -1);
      Node nnte = nne;
      Node nnto = nno;

      for(Node temp = head; temp != null; temp = temp.next) {
         if (temp.data % 2 == 0) {
            nnte.next = temp;
            nnte = nnte.next;
         } else {
            nnto.next = temp;
            nnto = nnto.next;
         }
      }

      nnte.next = null;
      nnto.next = null;
      if (nne.next != null) {
         nnte.next = nno.next;
         return nne.next;
      } else {
         return nno.next;
      }
   }
}
