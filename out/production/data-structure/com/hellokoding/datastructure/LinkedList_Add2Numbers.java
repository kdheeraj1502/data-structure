package com.hellokoding.datastructure;

public class LinkedList_Add2Numbers {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummyHead = new ListNode(0);
      ListNode p = l1;
      ListNode q = l2;
      ListNode curr = dummyHead;
      int carry = 0;

      while(p != null || q != null) {
         int x = p != null ? p.val : 0;
         int y = q != null ? q.val : 0;
         int sum = carry + x + y;
         carry = sum / 10;
         curr.next = new ListNode(sum % 10);
         curr = curr.next;
         if (p != null) {
            p = p.next;
         }

         if (q != null) {
            q = q.next;
         }
      }

      if (carry > 0) {
         curr.next = new ListNode(carry);
      }

      return dummyHead.next;
   }

   public ListNode createListNode(String s) {
      ListNode r = new ListNode(this.getValue(s.charAt(s.length() - 1)));

      for(int i = s.length() - 2; i >= 0; --i) {
         int v = this.getValue(s.charAt(i));
         r.next = new ListNode(v);
         r = r.next;
      }

      return r;
   }

   public int getValue(char c) {
      return Integer.parseInt(String.valueOf(c));
   }

   public String getNumber(ListNode l) {
      StringBuilder s = new StringBuilder();

      do {
         s.append(l.val);
      } while((l = l.next) != null);

      return s.reverse().toString();
   }

   public static void main(String[] args) {
      LinkedList_Add2Numbers t = new LinkedList_Add2Numbers();
      ListNode result = t.addTwoNumbers(t.createListNode("243"), t.createListNode("64"));
      System.out.println(t.getNumber(result));
   }
}
