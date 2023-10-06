package dp;

public class maxlengthchain$pair implements Comparable<maxlengthchain$pair> {
   int a;
   int b;
   // $FF: synthetic field
   final maxlengthchain this$0;

   maxlengthchain$pair(maxlengthchain this$0, int a, int b) {
      this.this$0 = this$0;
      this.a = a;
      this.b = b;
   }

   public int compareTo(maxlengthchain$pair o) {
      return this.b - o.b;
   }
}
