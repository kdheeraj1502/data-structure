package com.hellokoding.datastructure;

public class MyDoublyLinkedList {
   Node head;
   Node tail;

   public void addFirst(int data) {
      Node newNode = new Node((Node)null, data, this.head);
      this.head = newNode;
      if (this.tail == null) {
         this.tail = this.head;
      }

   }

   public void addLast(int data) {
      Node newNode = new Node(this.tail, data, (Node)null);
      this.tail = newNode;
      if (this.head == null) {
         this.head = this.tail;
      }

   }

   public void removeFirst() {
      if (this.head != null) {
         this.head = this.head.next;
         if (this.head == null) {
            this.tail = null;
         }

         this.head.previous = null;
      }
   }

   public void removeLast() {
      if (this.head != null) {
         if (this.head.next == null) {
            this.head = null;
            this.tail = null;
         } else {
            Node beforeTail = this.tail.previous;
            beforeTail.next = null;
            this.tail = beforeTail;
         }
      }
   }

   public void traversal() {
      for(Node currentNode = this.head; currentNode != null; currentNode = currentNode.next) {
         System.out.printf("%d ", currentNode.data);
      }

      System.out.println();
   }

   public static void main(String[] args) {
      MyDoublyLinkedList myLinkedList = new MyDoublyLinkedList();
      myLinkedList.addLast(2);
      myLinkedList.addLast(6);
      myLinkedList.addFirst(9);
      myLinkedList.traversal();
      myLinkedList.removeFirst();
      myLinkedList.traversal();
      myLinkedList.removeLast();
      myLinkedList.traversal();
   }
}
