package com.hellokoding.datastructure;

public class MaxHeapByArray {
   private int[] heap;
   private int size;

   public MaxHeapByArray(int capacity) {
      this.heap = new int[capacity + 1];
      this.heap[0] = Integer.MAX_VALUE;
      this.size = 0;
   }

   private void swap(int i, int j) {
      int tmp = this.heap[i];
      this.heap[i] = this.heap[j];
      this.heap[j] = tmp;
   }

   private void heapifyDown(int k) {
      int largest = k;
      int leftIndex = 2 * k;
      int rightIndex = 2 * k + 1;
      if (leftIndex <= this.heap.length && this.heap[leftIndex] > this.heap[k]) {
         largest = leftIndex;
      }

      if (rightIndex <= this.heap.length && this.heap[rightIndex] > this.heap[largest]) {
         largest = rightIndex;
      }

      if (largest != k) {
         this.swap(k, largest);
         this.heapifyDown(largest);
      }

   }

   private void heapifyUp(int k) {
      while(this.heap[k] > this.heap[k / 2]) {
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

   public static void main(String[] args) {
      MaxHeapByArray maxHeap = new MaxHeapByArray(5);
      maxHeap.push(3);
      maxHeap.push(1);
      maxHeap.push(7);
      maxHeap.push(2);
      maxHeap.push(9);
      maxHeap.print();
      System.out.println(maxHeap.peek());
      System.out.println(maxHeap.pop());
      System.out.println(maxHeap.peek());
   }
}
