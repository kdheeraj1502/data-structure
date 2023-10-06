package com.hellokoding.algorithm;

public class FibonacciMemoization {
   int[] cache;

   FibonacciMemoization(int[] cache) {
      this.cache = cache;
   }

   int fibonacci(int n) {
      if (this.cache[n] == 0) {
         if (n < 2) {
            this.cache[n] = n;
         } else {
            this.cache[n] = this.fibonacci(n - 1) + this.fibonacci(n - 2);
         }
      }

      return this.cache[n];
   }

   public static void main(String[] args) {
      int n = 10;
      System.out.println((new FibonacciMemoization(new int[n + 1])).fibonacci(n));
   }
}
