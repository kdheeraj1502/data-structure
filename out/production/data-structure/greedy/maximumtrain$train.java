package greedy;

public class maximumtrain$train implements Comparable<maximumtrain$train> {
   int at;
   int dt;
   int pn;

   maximumtrain$train(int a, int d, int p) {
      this.at = a;
      this.dt = d;
      this.pn = p;
   }

   public int compareTo(maximumtrain$train o) {
      return this.dt - o.dt;
   }
}
