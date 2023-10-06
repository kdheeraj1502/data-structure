package stackandqueue;

import java.util.Stack;

public class sortstack {
   public static void main(String[] args) {
   }

   public Stack<Integer> sort(Stack<Integer> s) {
      if (s.size() == 1) {
         return s;
      } else {
         int top = (Integer)s.pop();
         Stack<Integer> ans = this.sort(s);
         return this.insert(top, ans);
      }
   }

   public Stack<Integer> insert(int top, Stack<Integer> s) {
      if (s.size() == 0) {
         s.push(top);
         return s;
      } else if (top > (Integer)s.peek()) {
         s.push(top);
         return s;
      } else {
         int t = (Integer)s.pop();
         Stack<Integer> ans = this.insert(top, s);
         ans.push(t);
         return ans;
      }
   }
}
