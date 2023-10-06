package com.hellokoding.algorithm;

public class FibonacciRecursion {
   int fibonacci(int i) {
      return i < 2 ? i : this.fibonacci(i - 1) + this.fibonacci(i - 2);
   }

   public static void main(String[] args) {
      System.out.println((new FibonacciRecursion()).fibonacci(10));
   }
}
