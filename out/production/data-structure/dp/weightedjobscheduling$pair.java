package dp;

public class weightedjobscheduling$pair implements Comparable<weightedjobscheduling$pair> {
   int s;
   int e;
   int p;

   weightedjobscheduling$pair(int s, int e, int p) {
      this.s = s;
      this.e = e;
      this.p = p;
   }

   public int compareTo(weightedjobscheduling$pair o) {
      return this.e - o.e;
   }
}
