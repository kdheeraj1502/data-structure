package stack;

import java.util.Stack;

public class BalancedParenthesis {
   public static boolean isBalance(String exp) {
      Stack<Character> stack = new Stack();
      char[] var2 = exp.toCharArray();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Character ch = var2[var4];
         switch (ch) {
            case '(':
            case '[':
            case '{':
               stack.push(ch);
               break;
            case ')':
               if ((Character)stack.pop() != '(') {
                  return false;
               }
               break;
            case ']':
               if ((Character)stack.pop() != '[') {
                  return false;
               }
               break;
            case '}':
               if ((Character)stack.pop() != '{') {
                  return false;
               }
         }
      }

      return stack.isEmpty();
   }

   public static int findMaxDepth(String exp) {
      int max = -1;
      int currMax = 0;
      Stack<Character> stack = new Stack();
      if (isBalance(exp)) {
         char[] var4 = exp.toCharArray();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            Character ch = var4[var6];
            if (ch == '(') {
               stack.push(ch);
               ++currMax;
               max = Math.max(max, currMax);
            } else if (ch == ')') {
               stack.pop();
               --currMax;
            }
         }
      } else {
         System.out.print("It is not balanced ");
      }

      return max;
   }

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
            if (!stack.isEmpty() && (Integer)stack.peek() == i) {
               stack.pop();
            } else {
               sb.append(s.charAt(i));
            }
         }

         return sb.reverse().toString();
      }
   }

   public static void main(String[] args) {
      String[] exp = new String[]{"((()))()", "((((A)))((((BBB()))))()()()())"};
      String[] var2 = exp;
      int var3 = exp.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var10000 = var2[var4];
      }

      String s = "()())()";
      System.out.println(minRemoveToMakeValid(s));
   }
}
