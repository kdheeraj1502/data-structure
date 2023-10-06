package graphs;

public class prims$pair implements Comparable<prims$pair> {
   String vname;
   String pathvtc;
   int wt;

   prims$pair(String v, String p, int w) {
      this.pathvtc = p;
      this.vname = v;
      this.wt = w;
   }

   public int compareTo(prims$pair o) {
      return this.wt - o.wt;
   }
}
