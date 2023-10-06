package searchingandsorting;

public class kthsmallestAGAIN$pair implements Comparable<kthsmallestAGAIN$pair> {
   long start;
   long end;

   kthsmallestAGAIN$pair(long s, long e) {
      this.start = s;
      this.end = e;
   }

   public int compareTo(kthsmallestAGAIN$pair o) {
      return this.start != o.start ? (int)(this.start - o.start) : (int)(this.end - o.end);
   }
}
