package heap;

public class mergeksortedlinkedlist$pair implements Comparable<mergeksortedlinkedlist$pair> {
   int llname;
   mergeksortedlinkedlist.Node node;

   mergeksortedlinkedlist$pair(int l, mergeksortedlinkedlist.Node n) {
      this.llname = l;
      this.node = n;
   }

   public int compareTo(mergeksortedlinkedlist$pair o) {
      return this.node.data - o.node.data;
   }
}
