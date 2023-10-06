package queue;

import java.util.Arrays;

public class CustomQueue {
   private int front = 0;
   private int back = 0;
   private int capacity;
   private int[] data;
   private int size;

   public CustomQueue() {
      this.capacity = 20;
      this.data = new int[this.capacity];
   }

   public CustomQueue(int capacity) {
      this.capacity = capacity;
      this.data = new int[this.capacity];
   }

   public boolean add(int val) {
      if (this.size >= this.capacity) {
         System.out.println("Queue is full");
         return false;
      } else {
         ++this.size;
         this.data[this.back] = val;
         this.back = ++this.back % (this.capacity - 1);
         return true;
      }
   }

   public int remove() {
      if (this.size <= 0) {
         System.out.println("Queue is empty");
         return -1;
      } else {
         --this.size;
         int val = this.data[this.front];
         this.front = ++this.front % (this.capacity - 1);
         return val;
      }
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public int size() {
      return this.size;
   }

   public void print() {
      System.out.println(Arrays.toString(this.data));
   }

   public static void main(String[] args) {
      CustomQueue cq = new CustomQueue();
      cq.add(5);
   }
}
