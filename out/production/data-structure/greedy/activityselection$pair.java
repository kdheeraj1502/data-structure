package greedy;

public class activityselection$pair implements Comparable<activityselection$pair> {
   int start;
   int end;

   activityselection$pair(int s, int e) {
      this.start = s;
      this.end = e;
   }

   public int compareTo(activityselection$pair o) {
      return this.end - o.end;
   }
}
