package dynamic.programming;

class WeightedActivitySelection$Job1 implements Comparable<Job> {
   int start;
   int end;
   int profit;
   // $FF: synthetic field
   final WeightedActivitySelection this$0;

   WeightedActivitySelection$Job1(WeightedActivitySelection this$0, int start, int end, int profit) {
      this.this$0 = this$0;
      this.start = start;
      this.end = end;
      this.profit = profit;
   }

   public int compareTo(Job otherJob) {
      return this.start - otherJob.start;
   }
}
