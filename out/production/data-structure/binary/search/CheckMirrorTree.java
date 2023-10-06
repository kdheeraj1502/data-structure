package binary.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CheckMirrorTree {
   static int checkMirrorTree(int n, int e, int[] A, int[] B) {
      List<Stack<Integer>> stack = new ArrayList();
      List<Queue<Integer>> queue = new ArrayList();

      int i;
      for(i = 0; i <= n; ++i) {
         stack.add(new Stack());
         Queue<Integer> q = new LinkedList();
         queue.add(q);
      }

      for(i = 0; i < 2 * e; i += 2) {
         ((Stack)stack.get(A[i])).push(A[i + 1]);
         ((Queue)queue.get(B[i])).add(B[i + 1]);
      }

      for(i = 1; i <= n; ++i) {
         while(!((Stack)stack.get(i)).isEmpty() && !((Queue)queue.get(i)).isEmpty()) {
            int a = (Integer)((Stack)stack.get(i)).pop();
            int b = (Integer)((Queue)queue.get(i)).remove();
            if (a != b) {
               return 0;
            }
         }
      }

      return 1;
   }

   public static void main(String[] args) {
      int n = 3;
      int e = 2;
      int[] A = new int[]{1, 2, 1, 3};
      int[] B = new int[]{1, 3, 1, 2};
      System.out.println(checkMirrorTree(n, e, A, B));
   }
}
