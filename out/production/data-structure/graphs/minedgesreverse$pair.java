package graphs;

public class minedgesreverse$pair implements Comparable<minedgesreverse$pair> {
   int vname;
   int cost;
   String path;

   minedgesreverse$pair(int v, int c, String s) {
      this.vname = v;
      this.cost = c;
      this.path = s;
   }

   public int compareTo(minedgesreverse$pair o) {
      return this.cost - o.cost;
   }
}
