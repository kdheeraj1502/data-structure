package com.hellokoding.datastructure;

class MyDoublyLinkedList$Node {
   public int data;
   public MyDoublyLinkedList$Node previous;
   public MyDoublyLinkedList$Node next;

   public MyDoublyLinkedList$Node(MyDoublyLinkedList$Node previous, int data, MyDoublyLinkedList$Node next) {
      this.previous = previous;
      if (previous != null) {
         previous.next = this;
      }

      this.data = data;
      this.next = next;
      if (next != null) {
         next.previous = this;
      }

   }
}
