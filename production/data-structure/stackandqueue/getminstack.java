package stackandqueue;

import java.util.Stack;

public class getminstack {
   public static int min = 0;

   public static void main(String[] args) {
      Stack<Integer> s = new Stack();
      push(3, s);
      push(2, s);
      push(1, s);
      push(4, s);
      push(5, s);
      System.out.println(min(s));
      System.out.println(pop(s));
      System.out.println(pop(s));
      System.out.println(pop(s));
      System.out.println(min(s));
   }

   public static void push(int a, Stack<Integer> s) {
      if (s.isEmpty()) {
         min = a;
         s.push(a);
      } else if (a >= min) {
         s.push(a);
      } else {
         s.push(a + a - min);
         min = a;
      }

   }

   public static int pop(Stack<Integer> s) {
      if (s.isEmpty()) {
         System.out.println("stack underflow");
         return -1;
      } else if ((Integer)s.peek() >= min) {
         return (Integer)s.pop();
      } else {
         int ogmin = min;
         min = 2 * min - (Integer)s.pop();
         return ogmin;
      }
   }

   public static int min(Stack<Integer> s) {
      return min;
   }

   public static boolean isFull(Stack<Integer> s, int n) {
      return s.size() == n;
   }

   public static boolean isEmpty(Stack<Integer> s) {
      return s.isEmpty();
   }
}
