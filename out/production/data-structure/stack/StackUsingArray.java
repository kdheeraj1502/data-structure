package stack;

import java.util.Arrays;

public class StackUsingArray<T> {
   private int size;
   private int top = -1;
   private Object[] elementData;
   private int minCapacity = 10;
   private int capacity;

   StackUsingArray() {
      this.capacity = 10;
      this.elementData = new Object[this.capacity];
   }

   StackUsingArray(int capacity) {
      this.capacity = capacity;
      this.elementData = new Object[capacity];
   }

   public boolean isEmpty() {
      return this.top == -1;
   }

   public void push(T val) {
      ++this.size;
      this.ensureCapacity(this.size + 1);
      this.elementData[++this.top] = val;
   }

   public Object pop() {
      if (this.size == this.capacity / 2 && this.capacity > this.minCapacity) {
         this.reduceCapacity(this.capacity / 2);
      }

      --this.size;
      return this.elementData[this.top--];
   }

   public int getSize() {
      return this.size;
   }

   private void reduceCapacity(int minCapacity) {
      this.capacity /= 2;
      this.elementData = Arrays.copyOf(this.elementData, this.capacity);
   }

   private void ensureCapacity(int minCapacity) {
      if (minCapacity - this.elementData.length > 0) {
         this.capacity *= 2;
         this.elementData = Arrays.copyOf(this.elementData, this.capacity);
      }

   }

   public void print() {
      for(int i = this.top; i > -1; --i) {
         System.out.print(this.elementData[this.top--] + ", ");
      }

      System.out.println();
   }
}
