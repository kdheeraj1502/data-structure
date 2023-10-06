package stack;

import java.util.Stack;

public class BracketRemove {
   public static String minRemoveToMakeValid(String s) {
      Stack<Integer> stack = new Stack();
      StringBuilder sb = new StringBuilder();

      int i;
      for(i = 0; i < s.length(); ++i) {
         char ch = s.charAt(i);
         if (ch == '(') {
            stack.push(i);
         }

         if (ch == ')') {
            if (!stack.isEmpty() && s.charAt((Integer)stack.peek()) == '(') {
               stack.pop();
            } else {
               stack.push(i);
            }
         }
      }

      if (stack.isEmpty()) {
         return s;
      } else {
         for(i = s.length() - 1; i >= 0; --i) {
            if ((Integer)stack.peek() == i) {
               stack.pop();
            } else {
               sb.append(s.charAt(i));
            }
         }

         return sb.reverse().toString();
      }
   }

   public static String minRemoveToMakeValid_1(String s) {
      int count = 0;
      char[] arr = s.toCharArray();

      int i;
      char ch;
      for(i = 0; i < arr.length; ++i) {
         ch = arr[i];
         if (ch == '(') {
            ++count;
         }

         if (ch == ')') {
            if (count > 0) {
               --count;
            } else {
               arr[i] = 0;
            }
         }
      }

      if (count > 0) {
         count = 0;

         for(i = arr.length - 1; i >= 0; --i) {
            ch = arr[i];
            if (ch == ')') {
               ++count;
            }

            if (ch == '(') {
               if (count > 0) {
                  --count;
               } else {
                  arr[i] = 0;
               }
            }
         }
      }

      StringBuilder sb = new StringBuilder();
      char[] var9 = arr;
      int var5 = arr.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         char ch = var9[var6];
         if (ch != 0) {
            sb.append(ch);
         }
      }

      return sb.toString();
   }

   public static void main(String[] args) {
      String s = "))((";
      System.out.println(minRemoveToMakeValid(s));
      System.out.println(minRemoveToMakeValid_1(s));
   }
}
