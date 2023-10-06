package greedy;

public class minplatforms$train implements Comparable<minplatforms$train> {
   int at;
   int dt;

   minplatforms$train(int a, int d) {
      this.at = a;
      this.dt = d;
   }

   public int compareTo(minplatforms$train o) {
      return this.at - o.at < 0 ? -1 : 1;
   }
}
