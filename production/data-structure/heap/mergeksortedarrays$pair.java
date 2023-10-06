package heap;

public class mergeksortedarrays$pair implements Comparable<mergeksortedarrays$pair> {
   int i;
   int arrname;
   int val;

   mergeksortedarrays$pair(int i, int a, int val) {
      this.i = i;
      this.arrname = a;
      this.val = val;
   }

   public int compareTo(mergeksortedarrays$pair o) {
      return this.val - o.val;
   }
}
