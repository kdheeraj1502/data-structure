package greedy;

public class buymaxstocks$pair implements Comparable<buymaxstocks$pair> {
   int price;
   int n;

   buymaxstocks$pair(int p, int n) {
      this.price = p;
      this.n = n;
   }

   public int compareTo(buymaxstocks$pair o) {
      return this.price - o.price;
   }
}
