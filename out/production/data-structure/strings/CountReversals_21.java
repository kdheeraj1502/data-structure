package strings;

import java.util.Stack;

public class CountReversals_21 {
   public static void main(String[] args) {
      System.out.println(count("{}{{}{"));
   }

   public static int count(String s) {
      Stack<Character> list = new Stack();
      list.add(s.charAt(0));

      int open;
      for(open = 1; open < s.length(); ++open) {
         if (!list.empty() && (Character)list.peek() == '{' && s.charAt(open) == '}') {
            list.pop();
         } else {
            list.add(s.charAt(open));
         }
      }

      open = 0;
      int close = 0;
      if (list.empty()) {
         return 0;
      } else if (list.size() % 2 != 0) {
         return -1;
      } else {
         for(; !list.empty(); list.pop()) {
            if ((Character)list.peek() == '{') {
               ++open;
            } else if ((Character)list.peek() == '}') {
               ++close;
            }
         }

         return (open + close) / 2 + open % 2;
      }
   }
}
