package com.hellokoding.datastructure;

import java.util.NoSuchElementException;

public class QueueByArray {
   private int[] queue;
   private int front;
   private int rear;

   public QueueByArray(int capacity) {
      this.queue = new int[capacity];
      this.front = 0;
      this.rear = 0;
   }

   public void enqueue(int x) {
      if (this.isFull()) {
         throw new IllegalStateException();
      } else {
         this.queue[this.rear++] = x;
      }
   }

   public int dequeue() {
      if (this.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return this.queue[this.front++];
      }
   }

   public int front() {
      if (this.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return this.queue[this.front];
      }
   }

   public boolean isEmpty() {
      return this.front == this.rear;
   }

   public boolean isFull() {
      return this.rear == this.queue.length;
   }

   public int size() {
      return this.rear - this.front;
   }

   public static void main(String[] args) {
      QueueByArray myQueue = new QueueByArray(3);
      myQueue.enqueue(1);
      myQueue.enqueue(2);
      myQueue.enqueue(3);
      System.out.println(myQueue.front());
      System.out.println(myQueue.dequeue());
      System.out.println(myQueue.front());
      System.out.println(myQueue.size());
      System.out.println(myQueue.isEmpty());
      System.out.println(myQueue.isFull());
   }
}
