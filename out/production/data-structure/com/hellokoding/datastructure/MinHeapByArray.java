package com.hellokoding.datastructure;

public class MinHeapByArray {
   private int[] heap;
   private int size;

   public MinHeapByArray(int capacity) {
      this.heap = new int[capacity + 1];
      this.heap[0] = Integer.MIN_VALUE;
      this.size = 0;
   }

   private void swap(int i, int j) {
      int tmp = this.heap[i];
      this.heap[i] = this.heap[j];
      this.heap[j] = tmp;
   }

   private void heapifyDown(int k) {
      int smallest = k;
      int leftIndex = 2 * k;
      int rightIndex = 2 * k + 1;
      if (leftIndex <= this.heap.length && this.heap[leftIndex] < this.heap[k]) {
         smallest = leftIndex;
      }

      if (rightIndex <= this.heap.length && this.heap[rightIndex] < this.heap[smallest]) {
         smallest = rightIndex;
      }

      if (smallest != k) {
         this.swap(k, smallest);
         this.heapifyDown(smallest);
      }

   }

   private void heapifyUp(int k) {
      while(this.heap[k] < this.heap[k / 2]) {
         this.swap(k, k / 2);
         k /= 2;
      }

   }

   private void print() {
      for(int i = 1; i <= this.size / 2; ++i) {
         System.out.printf("Parent: %d, Left child: %d, Right child: %d %s", this.heap[i], this.heap[i * 2], this.heap[i * 2 + 1], System.lineSeparator());
      }

   }

   public void push(int x) {
      this.heap[++this.size] = x;
      this.heapifyUp(this.size);
   }

   public int pop() {
      int head = this.heap[1];
      this.heap[1] = this.heap[this.size--];
      this.heapifyDown(1);
      return head;
   }

   public int peek() {
      return this.heap[1];
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public static void main(String[] args) {
      MinHeapByArray minHeap = new MinHeapByArray(5);
      minHeap.push(3);
      minHeap.push(1);
      minHeap.push(7);
      minHeap.push(2);
      minHeap.push(9);
      minHeap.print();
      System.out.println(minHeap.peek());
      System.out.println(minHeap.pop());
      System.out.println(minHeap.peek());
   }
}
