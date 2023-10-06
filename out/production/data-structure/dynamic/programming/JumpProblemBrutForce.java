package dynamic.programming;

public class JumpProblemBrutForce {
   public boolean canJump(int[] num) {
      int count = 0;
      if (num.length == 1) {
         return true;
      } else {
         boolean[] jumps = new boolean[num.length];
         jumps[0] = true;

         for(int i = 0; i < num.length && !jumps[jumps.length - 1]; ++i) {
            if (!jumps[i]) {
               return false;
            }

            for(int j = i + 1; j < Math.min(num.length, i + 1 + num[i]); ++j) {
               jumps[j] = true;
            }

            ++count;
         }

         System.out.println(count);
         return true;
      }
   }

   public boolean canJump_optimize(int[] num) {
      if (num.length == 1) {
         return true;
      } else {
         int dis = 0;

         for(int i = 0; i < num.length; ++i) {
            dis = Math.max(dis, num[i]);
            if (dis == 0 && i != num.length - 1) {
               return false;
            }

            --dis;
         }

         return true;
      }
   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 1, 1, 1, 4};
      JumpProblemBrutForce jpbf = new JumpProblemBrutForce();
      System.out.println(jpbf.canJump(num));
      System.out.println(jpbf.canJump_optimize(num));
   }
}
