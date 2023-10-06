package graphs;

public class cheapestflights$pair implements Comparable<cheapestflights$pair> {
   int vname;
   int cost;
   String path;
   int stop;

   cheapestflights$pair(int v, int c, String s, int st) {
      this.vname = v;
      this.cost = c;
      this.path = s;
      this.stop = st;
   }

   public int compareTo(cheapestflights$pair o) {
      return this.cost - o.cost;
   }
}
