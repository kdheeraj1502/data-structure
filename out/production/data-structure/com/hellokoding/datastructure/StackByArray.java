package com.hellokoding.datastructure;

import java.util.NoSuchElementException;

public class StackByArray {
   private int[] stack;
   private int top;

   public StackByArray(int capacity) {
      this.stack = new int[capacity];
      this.top = -1;
   }

   public void push(int x) {
      if (this.isFull()) {
         throw new IllegalStateException();
      } else {
         this.stack[++this.top] = x;
      }
   }

   public int pop() {
      if (this.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return this.stack[this.top--];
      }
   }

   public int peek() {
      if (this.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return this.stack[this.top];
      }
   }

   public boolean isEmpty() {
      return this.top == -1;
   }

   public boolean isFull() {
      return this.top == this.stack.length - 1;
   }

   public int size() {
      return this.top + 1;
   }

   public static void main(String[] args) {
      StackByArray myStack = new StackByArray(3);
      myStack.push(4);
      myStack.push(2);
      myStack.push(5);
      System.out.println(myStack.peek());
      System.out.println(myStack.pop());
      System.out.println(myStack.peek());
      System.out.println(myStack.size());
      System.out.println(myStack.isEmpty());
      System.out.println(myStack.isFull());
   }
}
