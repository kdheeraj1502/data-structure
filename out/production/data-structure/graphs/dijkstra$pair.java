package graphs;

public class dijkstra$pair implements Comparable<dijkstra$pair> {
   String vname;
   String path;
   int wt;

   dijkstra$pair(String vname, String path, int w) {
      this.vname = vname;
      this.path = path;
      this.wt = w;
   }

   public int compareTo(dijkstra$pair o) {
      return this.wt - o.wt;
   }
}
