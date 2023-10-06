package queue;

class CustomQueueUsingLinkedList$Node {
   CustomQueueUsingLinkedList$Node next;
   int val;

   CustomQueueUsingLinkedList$Node() {
   }

   CustomQueueUsingLinkedList$Node(int val) {
      this.val = val;
      this.next = null;
   }

   CustomQueueUsingLinkedList$Node(int val, CustomQueueUsingLinkedList$Node next) {
      this.val = val;
      this.next = next;
   }
}
