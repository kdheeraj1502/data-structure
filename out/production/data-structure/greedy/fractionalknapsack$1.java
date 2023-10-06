package greedy;

import java.util.Comparator;

final class fractionalknapsack$1 implements Comparator<fractionalknapsack.Item> {
   public int compare(fractionalknapsack.Item a, fractionalknapsack.Item b) {
      double ra = (double)a.value / (double)a.weight;
      double rb = (double)b.value / (double)b.weight;
      return rb - ra < 0.0 ? -1 : 1;
   }
}
