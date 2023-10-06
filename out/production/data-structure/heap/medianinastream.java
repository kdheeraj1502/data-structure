package heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class medianinastream {
   public static PriorityQueue<Integer> leftmaxheap = new PriorityQueue(Collections.reverseOrder());
   public static PriorityQueue<Integer> rightminheap = new PriorityQueue();

   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);

      for(int n = scn.nextInt(); n > 0; --n) {
         int a = scn.nextInt();
         insertHeap(a);
         System.out.println(getMedian());
      }

      scn.close();
   }

   public static void insertHeap(int x) {
      if (rightminheap.size() > 0 && x > (Integer)rightminheap.peek()) {
         rightminheap.add(x);
      } else {
         leftmaxheap.add(x);
      }

      balanceHeaps();
   }

   public static void balanceHeaps() {
      if (leftmaxheap.size() - rightminheap.size() == 2) {
         rightminheap.add(leftmaxheap.remove());
      } else if (rightminheap.size() - leftmaxheap.size() == 2) {
         leftmaxheap.add(rightminheap.remove());
      }

   }

   public static double getMedian() {
      if (leftmaxheap.size() > rightminheap.size()) {
         return (double)(Integer)leftmaxheap.peek();
      } else if (leftmaxheap.size() < rightminheap.size()) {
         return (double)(Integer)rightminheap.peek();
      } else {
         int a = (Integer)leftmaxheap.peek();
         int b = (Integer)rightminheap.peek();
         double ans = (double)(a + b) / 2.0;
         return ans;
      }
   }
}
