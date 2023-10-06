package com.hellokoding.datastructure;

public class MyLinkedList {
   Node head;

   public void addFirst(int data) {
      if (this.head == null) {
         this.head = new Node(data);
      } else {
         Node newNode = new Node(data);
         newNode.next = this.head;
         this.head = newNode;
      }
   }

   public void addLast(int data) {
      if (this.head == null) {
         this.head = new Node(data);
      } else {
         Node currentNode;
         for(currentNode = this.head; currentNode.next != null; currentNode = currentNode.next) {
         }

         currentNode.next = new Node(data);
      }
   }

   public void removeFirst() {
      if (this.head != null) {
         this.head = this.head.next;
      }
   }

   public void removeLast() {
      if (this.head != null) {
         if (this.head.next == null) {
            this.head = null;
         } else {
            Node currentNode;
            for(currentNode = this.head; currentNode.next.next != null; currentNode = currentNode.next) {
            }

            currentNode.next = null;
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
      MyLinkedList myLinkedList = new MyLinkedList();
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
