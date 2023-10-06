package greedy;

public class pickingupchicks {
   public static void main(String[] args) {
      FastReader scn = new FastReader();
      int a = 1;

      for(int t = scn.nextInt(); t > 0; --t) {
         int n = scn.nextInt();
         long k = scn.nextLong();
         long b = scn.nextLong();
         long time = scn.nextLong();
         long[] speed = new long[n];
         long[] pos = new long[n];

         int i;
         for(i = 0; i < pos.length; ++i) {
            pos[i] = scn.nextLong();
         }

         for(i = 0; i < speed.length; ++i) {
            speed[i] = scn.nextLong();
         }

         solve(speed, pos, time, k, b, a);
         ++a;
      }

   }

   public static void solve(long[] speed, long[] pos, long time, long k, long b, int t) {
      int count = 0;
      int swap = 0;
      int notposible = 0;

      for(int i = pos.length - 1; i >= 0; --i) {
         long disttoreach = b - pos[i];
         long distcanreach = speed[i] * time;
         if (distcanreach >= disttoreach) {
            ++count;
            if (notposible > 0) {
               swap += notposible;
            }
         } else {
            ++notposible;
         }

         if ((long)count >= k) {
            break;
         }
      }

      if ((long)count >= k) {
         System.out.println("Case #" + t + ": " + swap);
      } else {
         System.out.println("Case #" + t + ": IMPOSSIBLE");
      }

   }
}
