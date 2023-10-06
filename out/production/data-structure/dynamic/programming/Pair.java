package dynamic.programming;

class Pair implements Comparable<Pair> {
   int start;
   int end;
   int profit;

   public Pair(int start, int end, int profit) {
      this.profit = profit;
      this.end = end;
      this.start = start;
   }

   public int compareTo(Pair p) {
      return this.end == p.end ? this.start - p.start : this.end - p.end;
   }
}
