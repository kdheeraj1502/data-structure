package leet.code;

class ListNode$Node {
   int val;
   ListNode$Node next;
   public ListNode$Node random;

   ListNode$Node() {
      this.next = this.random = null;
   }

   ListNode$Node(int val) {
      this.val = val;
      this.next = this.random = null;
   }

   ListNode$Node(int val, ListNode$Node next) {
      this.val = val;
      this.next = next;
   }

   public String toString() {
      return "Node [val=" + this.val + ", next=" + this.next + ", random=" + this.random + "]";
   }
}
