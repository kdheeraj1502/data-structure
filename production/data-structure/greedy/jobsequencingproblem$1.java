package greedy;

import java.util.Comparator;

final class jobsequencingproblem$1 implements Comparator<jobsequencingproblem.Job> {
   public int compare(jobsequencingproblem.Job a, jobsequencingproblem.Job b) {
      return b.profit - a.profit;
   }
}
