package stackandqueue;

public class mergeintervals$pair implements Comparable<mergeintervals$pair> {
   int start;
   int end;

   mergeintervals$pair(int s, int e) {
      this.start = s;
      this.end = e;
   }

   public int compareTo(mergeintervals$pair o) {
      return this.start != o.start ? this.start - o.start : this.end - o.end;
   }
}
