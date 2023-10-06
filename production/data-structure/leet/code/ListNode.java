package leet.code;

public class ListNode {
   public Node reverseBetween_self(Node head, int left, int right) {
      int pos = 1;
      Node curr = head;

      Node start;
      for(start = head; pos < left; ++pos) {
         start = curr;
         curr = curr.next;
      }

      Node prev = null;

      for(Node next = null; pos >= left && pos <= right; ++pos) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }

      start.next = prev;
      curr.next = curr;
      return left == 1 ? prev : head;
   }

   public Node reverseBetween(Node head, int left, int right) {
      if (left != right && head != null) {
         Node dummy = new Node(0);
         dummy.next = head;
         Node pre = dummy;
         Node post = dummy;

         for(int i = 1; i <= right + 1; ++i) {
            if (i < left) {
               pre = pre.next;
            }

            post = post.next;
         }

         Node start = pre.next;

         Node temp;
         Node next;
         for(temp = post; start != post; start = next) {
            next = start.next;
            start.next = temp;
            temp = start;
         }

         pre.next = temp;
         return dummy.next;
      } else {
         return head;
      }
   }

   public Node cloneIt(Node head) {
      Node curr;
      Node newNode;
      for(curr = head; curr != null; curr = curr.next.next) {
         newNode = new Node(curr.val);
         newNode.next = curr.next;
         curr.next = newNode;
      }

      for(curr = head; curr != null; curr = curr.next.next) {
         if (curr.random != null) {
            curr.next.random = curr.random.next;
         }
      }

      curr = head;
      newNode = new Node(0);

      for(Node temp = newNode; curr != null; temp = temp.next) {
         temp.next = curr.next;
         curr.next = curr.next.next;
         curr = curr.next;
      }

      return newNode.next;
   }

   public Node rotate(Node head, int k) {
      Node curr = head;

      int size;
      for(size = 0; curr != null; ++size) {
         curr = curr.next;
      }

      k %= size;
      if (size >= 2 && k != 0) {
         Node fast = head;

         Node slow;
         for(slow = head; k-- > 0; fast = fast.next) {
         }

         while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
         }

         Node rev1 = slow.next;
         slow.next = null;
         Node rev2 = head;

         for(head = rev1; rev1.next != null; rev1 = rev1.next) {
         }

         rev1.next = rev2;
         return head;
      } else {
         return head;
      }
   }

   public Node reverseBetween_1(Node head, int left, int right) {
      int pos = 1;
      Node start = head;

      Node curr;
      for(curr = head; pos < left; ++pos) {
         start = curr;
         curr = curr.next;
      }

      Node next = null;

      Node prev;
      for(prev = null; pos >= left && pos <= right; ++pos) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }

      start.next = prev;
      curr.next = curr;
      return left == 1 ? prev : head;
   }

   public static void main(String[] args) {
      Node ln = new Node(1);
      ln.next = new Node(2);
      ln.next.next = new Node(3);
      ln.next.next.next = new Node(4);
      ln.next.next.next.next = new Node(5);
      ListNode list = new ListNode();
      System.out.println();
      System.out.println("-----reverse part----------");

      for(Node reverse = list.reverseBetween_1(ln, 2, 4); reverse != null; reverse = reverse.next) {
         System.out.print(reverse.val + ", ");
      }

   }
}
