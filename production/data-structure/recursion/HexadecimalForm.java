package recursion;

import java.util.Stack;

public class HexadecimalForm {
   static String hex = "0123456789ABCDEFH";

   public static String formChange(int num, StringBuilder result) {
      if (num == 0) {
         return "0";
      } else {
         if (num % 16 < 16) {
            result.append(Character.toString(hex.charAt(num % 16)));
         }

         formChange(num / 16, result);
         return result.toString();
      }
   }

   public static void main(String[] args) {
      String str = formChange(45, new StringBuilder());
      System.out.println(str);
      Stack<Character> stack = new Stack();

      for(int i = 0; i < str.length(); ++i) {
         stack.push(str.charAt(i));
      }

      String output = "";

      while(!stack.isEmpty()) {
         output = output + stack.peek();
         stack.pop();
      }

      System.out.println(output);
   }
}
