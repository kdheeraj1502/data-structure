package graphs;

public class minimisecashflow$pair implements Comparable<minimisecashflow$pair> {
   int vname;
   int cost;

   minimisecashflow$pair(int v, int col) {
      this.vname = v;
      this.cost = col;
   }

   public int compareTo(minimisecashflow$pair o) {
      return o.cost - this.cost;
   }
}
