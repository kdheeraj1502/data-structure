package com.hellokoding.datastructure;

import java.util.NoSuchElementException;

public class DequeueByArray {
   private int[] dequeue;
   private int front;
   private int rear;

   public DequeueByArray(int capacity) {
      this.dequeue = new int[capacity];
      this.front = 0;
      this.rear = 0;
   }

   public void enqueueFirst(int x) {
      if (this.isFull()) {
         throw new IllegalStateException();
      } else {
         for(int i = this.rear; i > this.front; --i) {
            this.dequeue[i] = this.dequeue[i - 1];
         }

         this.dequeue[this.front] = x;
         ++this.rear;
      }
   }

   public void enqueueLast(int x) {
      if (this.isFull()) {
         throw new IllegalStateException();
      } else {
         this.dequeue[this.rear++] = x;
      }
   }

   public int dequeueFirst() {
      if (this.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return this.dequeue[this.front++];
      }
   }

   public int dequeueLast() {
      if (this.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return this.dequeue[this.rear--];
      }
   }

   public int front() {
      if (this.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return this.dequeue[this.front];
      }
   }

   public int rear() {
      if (this.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return this.dequeue[this.rear - 1];
      }
   }

   public boolean isEmpty() {
      return this.front == this.rear;
   }

   public boolean isFull() {
      return this.rear == this.dequeue.length;
   }

   public int size() {
      return this.rear - this.front;
   }

   public static void main(String[] args) {
      DequeueByArray myQueue = new DequeueByArray(3);
      myQueue.enqueueFirst(1);
      myQueue.enqueueLast(2);
      myQueue.enqueueFirst(3);
      System.out.println(myQueue.front());
      System.out.println(myQueue.dequeueFirst());
      System.out.println(myQueue.front());
      System.out.println(myQueue.size());
      System.out.println(myQueue.isEmpty());
      System.out.println(myQueue.isFull());
   }
}
