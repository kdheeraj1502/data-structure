package LinkedList;

public class multiplytwoLL {
   public static long multiplyTwoLists(Node first, Node second) {
      long num1 = 0L;
      long num2 = 0L;
      int mod = 1000000007;

      while(first != null || second != null) {
         if (first != null) {
            num1 = (num1 * 10L % (long)mod + (long)first.data) % (long)mod;
            first = first.next;
         }

         if (second != null) {
            num2 = (num2 * 10L % (long)mod + (long)second.data) % (long)mod;
            second = second.next;
         }
      }

      return num1 % (long)mod * (num2 % (long)mod) % (long)mod;
   }

   public Node multiplyTwoListsog(Node l1, Node l2) {
      Node temp1 = reverse(l1);
      Node temp2 = reverse(l2);
      Node t2 = temp2;
      Node ans = new Node(-1);

      for(Node tempans = ans; t2 != null; tempans = tempans.next) {
         Node prod = multiply(temp1, t2.data);
         t2 = t2.next;
         addLL(prod, tempans);
      }

      return reverse(ans.next);
   }

   static void addLL(Node prod, Node tempans) {
      Node ta = tempans;
      Node tp = prod;

      for(int c = 0; c != 0 || tp != null; ta = ta.next) {
         int sum = c + (ta != null ? ta.data : 0) + (tp != null ? tp.data : 0);
         int digit = sum % 10;
         c = sum / 10;
         if (ta.next != null) {
            ta.next.data = digit;
         } else {
            ta.next = new Node(digit);
         }

         if (tp != null) {
            tp = tp.next;
         }
      }

   }

   public static Node multiply(Node head, int d) {
      Node ans = new Node(-1);
      Node temp = head;
      Node tempans = ans;
      int carry = 0;

      while(temp != null || carry != 0) {
         int mult = (temp != null ? temp.data : 0) * d + carry;
         Node nn = new Node(mult % 10);
         carry = mult / 10;
         tempans.next = nn;
         tempans = tempans.next;
         if (temp != null) {
            temp = temp.next;
         }
      }

      return ans.next;
   }

   public static Node reverse(Node head) {
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
